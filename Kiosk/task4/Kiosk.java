package task4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 이 클래스는 사용자가 메뉴를 선택하고, 각 카테고리에서 메뉴 항목을 선택할 수 있도록 하는 인터페이스를 제공합니다.
 * 메뉴 항목들은 여러 카테고리로 나누어져 있으며, 사용자는 카테고리와 항목을 선택하여 주문을 할 수 있습니다.
 */
public class Kiosk {
    private final ArrayList<Menu> menu; // 메뉴 리스트

    /**
     * Kiosk 객체를 생성.
     * @param menu 메뉴 카테고리 리스트
     */
    public Kiosk(ArrayList<Menu> menu) {
        this.menu = menu;
    }

    /**
     * Kiosk를 실행하면 사용자가 메뉴 선택가능
     * 사용자가 메뉴 번호를 입력하면 해당 카테고리로 이동하고,
     * 선택된 메뉴 항목을 주문.
     */
    public void Start() {
        Scanner sc = new Scanner(System.in); // 스캐너 선언
        boolean isRunning = true;

        while (isRunning) { // 반복문 시작
            System.out.println("[ MAIN MENU ]");
            System.out.println("메뉴 번호를 입력하세요. 0번을 누르면 프로그램이 종료됩니다.");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i).getCategoryName());
            }
            System.out.println("0. 종료");
            try {
                int input = sc.nextInt(); // 숫자 입력 받기

                if (input == 0) {
                    System.out.println("프로그램이 종료됩니다.");
                    isRunning = false;
                    break; // 종료
                }

                if (input >= 1 && input <= menu.size()) {
                    Menu selectedMenu = menu.get(input - 1); // 선택된 메뉴
                    Category(sc, selectedMenu); // 선택된 메뉴의 카테고리로 이동
                } else {
                    System.out.println("잘못된 메뉴 번호입니다. 다시 시도해 주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자 입력만 가능합니다. 메뉴 번호를 다시 입력하세요.");
                sc.nextLine();  // 버퍼를 비워주기 위해 nextLine() 호출
            }
        }
    }

    /**
     * 카테고리를 선택하고 해당 카테고리의 메뉴 항목을 출력.
     * 사용자는 항목 번호를 입력하여 주문 가능.
     *
     * @param sc Scanner 객체
     * @param selectedMenu 선택된 메뉴 카테고리
     */
    private void Category(Scanner sc, Menu selectedMenu) {
        while (true) {
            System.out.println("[ " + selectedMenu.getCategoryName() + " MENU ]");
            selectedMenu.printMenuItems(); // 메뉴 항목 출력
            System.out.println("0. 뒤로가기");

            try {
                int input = sc.nextInt(); // 카테고리 메뉴 선택

                if (input == 0) {
                    System.out.println("이전 화면으로 돌아갑니다.");
                    break; // 뒤로가기
                }

                ArrayList<MenuItem> items = selectedMenu.getItems(); // 선택된 카테고리의 메뉴 항목들

                if (input >= 1 && input <= items.size()) {
                    MenuItem selectedItem = items.get(input - 1); // 선택된 메뉴 항목
                    System.out.println("선택한 메뉴: " + selectedItem.getName());
                } else {
                    System.out.println("잘못된 번호입니다. 다시 입력하세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력하세요.");
                sc.nextLine(); // 잘못된 입력 처리
            }
        }
    }
}
