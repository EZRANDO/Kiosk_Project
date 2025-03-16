package task2;

import task3.MenuItem;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Shake Shack Kiosk 시스템을 구현한 클래스입니다.
 * 사용자로부터 메뉴 번호를 입력받아 주문을 처리하는 기능을 제공합니다.
 * 메뉴 항목을 표시하고 사용자의 주문을 처리하며, 프로그램 종료 기능을 포함합니다.
 *
 * @author "hyewon"
 * @version "11.0.24"
 */
public class Kiosk {
    private List<MenuItem> menuItems;  // 메뉴 항목 리스트

    /**
     * 메뉴 항목을 초기화하여 메뉴 리스트에 추가.
     */
    private void initializeMenu() {
        // 메뉴 항목 추가 (MenuItem 객체 생성 시 price와 details 전달)
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menuItems.add(new MenuItem("0. 종료", 0.0, "프로그램을 종료합니다."));  // 종료 메뉴 추가
    }

    /**
     * 각 메뉴 항목의 번호, 이름, 가격 및 세부 사항을 출력.
     */
    private void displayMenu() {
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);  // 메뉴 항목 가져오기
            System.out.println((i + 1) + ". " + item.getName() + " " + item.getPrice() + "원 - " + item.getDetails());
        }
    }

    /**
     * Kiosk 시스템을 실행하여 사용자에게 메뉴를 표시하고,
     * 메뉴 번호를 입력받아 주문을 처리. 사용자가 메뉴 번호를 입력하면
     * 해당 메뉴를 선택하고 주문을 완료
     *
     * 예외 처리:
     * 숫자가 아닌 값을 입력할 경우 InputMismatchException을 처리.
     */
    public void Start() {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("[ SHAKESHACK MENU ]\n");
            displayMenu();
            System.out.println("메뉴 번호를 입력하세요.");
            try {
                int input = sc.nextInt();
                if (input == 0) {
                    System.out.println("프로그램이 종료됩니다.");
                    isRunning = false;
                } else if (input >= 1 && input <= menuItems.size()) {
                    MenuItem selectedItem = menuItems.get(input - 1);
                    System.out.println(selectedItem.getName() + "의 주문이 완료되었습니다.");
                } else {
                    System.out.println("잘못된 메뉴 번호입니다. 다시 시도해 주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자 입력만 가능합니다. 메뉴 번호를 다시 입력하세요.");
                sc.nextLine();  // 버퍼 비우기
            }
        }
    }
}
