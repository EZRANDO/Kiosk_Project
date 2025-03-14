package task3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 이 클래스는 사용자가 메뉴 항목을 선택하여 주문을 진행할 수 있는 간단한 키오스크 시스템을 구현한 클래스입니다.
 * 사용자는 번호를 입력하여 메뉴 항목을 선택하고, 선택된 항목에 대한 주문을 확인할 수 있습니다.
 * 사용자가 "0"을 입력하면 프로그램이 종료됩니다.
 */
public class Kiosk {

    /** 메뉴 항목을 관리하는 리스트 */
    private List<MenuItem> menuItems; // 메뉴 항목을 담는 리스트

    private String name; // Kiosk의 이름
    private double price; // 가격 (현재 사용되지 않음)

    /**
     * Kiosk 생성자
     *
     * @param name 메뉴이름
     * @param price 가격
     * 이 생성자는 Kiosk 객체를 생성할 때 이름과 가격을 설정하고,
     * 메뉴 항목 리스트를 초기화하여 메뉴를 설정
     */
    public Kiosk(String name, double price) {
        this.name = name;
        this.price = price;
        this.menuItems = new ArrayList<>(); // 메뉴 항목 리스트 초기화
        initializeMenu(); // 메뉴 초기화
    }

    /**
     * 메뉴 항목 초기화
     * Kiosk에 사용할 기본 메뉴 항목들을 추가
     */
    private void initializeMenu() {
        // 메뉴 항목 추가 (MenuItem 객체 생성 시 price와 details 전달)
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    /**
     * 메뉴를 콘솔에 출력하는 메서드
     * 이 메서드는 각 메뉴 항목의 이름, 가격 및 세부 정보 출력
     */
    private void displayMenu() {
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i); // 특정 인덱스의 MenuItem 객체 가져오기
            System.out.println((i + 1) + "." + item.getName() + " " + item.getPrice() + " " + item.getDetails());
        }
    }

    /**
     * Kiosk의 주문 프로세스를 시작
     * 사용자가 메뉴 번호를 입력하면 해당 메뉴를 주문하고, 잘못된 번호를 입력하면 다시 시도가능
     * 사용자가 0을 입력하면 프로그램은 종료
     */
    public void Start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("[ SHAKESHACK MENU ]\n");
            displayMenu(); // 메뉴 출력
            System.out.println("메뉴 번호를 입력하세요. 0번을 누르면 프로그램이 종료됩니다.");

            try {
                int input = sc.nextInt(); // 사용자 입력 받기
                if (input == 0) {
                    System.out.println("프로그램이 종료됩니다.");
                    break; // 종료
                }
                if (input >= 1 && input <= menuItems.size()) {
                    MenuItem selectedItem = menuItems.get(input - 1); // 메뉴 항목 선택
                    System.out.println(selectedItem.getName() + "의 주문이 완료되었습니다.");
                } else {
                    System.out.println("잘못된 메뉴 번호입니다. 다시 시도해 주세요.");
                }
            } catch (InputMismatchException e) {
                // 예외 처리: 숫자가 아닌 값을 입력한 경우
                System.out.println("숫자 입력만 가능합니다. 메뉴 번호를 다시 입력하세요.");
                sc.nextLine(); // 버퍼 비우기
            }
        }
    }
}
