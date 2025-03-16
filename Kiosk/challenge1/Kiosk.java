package challenge1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Kiosk 클래스는 사용자가 메뉴를 선택하고, 카테고리별로 메뉴 항목을 주문할 수 있는 기능을 제공합니다.
 * 사용자가 메뉴 번호를 입력하여 카테고리를 선택하고, 각 카테고리에서 메뉴 항목을 선택하여 장바구니에 추가할 수 있습니다.
 * 이 클래스는 장바구니(cart)와 주문(currentOrder)을 관리하고, 메뉴를 화면에 출력하는 역할을 합니다.
 */
public class Kiosk {
    private final ArrayList<Menu> menu; // 메뉴 카테고리 리스트
    private Cart cart; // 장바구니 객체
    private OrderMenu currentOrder; // 주문 객체

    /**
     * Kiosk 객체를 생성
     *
     * @param menu 메뉴 카테고리 리스트
     */
    public Kiosk(ArrayList<Menu> menu) {
        this.menu = menu;
        this.cart = new Cart(this); // 장바구니 객체 생성, Kiosk 객체를 전달
        this.currentOrder = new OrderMenu(cart, this); // OrderMenu 객체 생성, 장바구니 및 Kiosk 객체를 전달
    }

    /**
     * Kiosk 시스템을 실행합니다. 사용자가 메뉴 번호를 입력하면 해당 카테고리로 이동하고,
     * 카테고리에서 메뉴 항목을 선택하여 주문가능.
     * 사용자가 0을 입력하면 프로그램이 종료.
     */
    public void Start() {
        Scanner sc = new Scanner(System.in); // 사용자 입력을 받을 스캐너 객체
        boolean isRunning = true; // 프로그램이 실행되는 동안 반복

        while (isRunning) { // 메뉴 선택 반복
            System.out.println("[ MAIN MENU ]");
            System.out.println("메뉴 번호를 입력하세요. 0번을 누르면 프로그램이 종료됩니다.");
            // 메뉴 카테고리 출력
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i).getCategoryName());
            }
            System.out.println("0. 종료");

            try {
                int input = sc.nextInt(); // 사용자 입력 받기

                if (input == 0) {
                    System.out.println("프로그램이 종료됩니다.");
                    isRunning = false; // 종료
                    break;
                }
                if (input >= 1 && input <= menu.size()) {
                    Menu selectedMenu = menu.get(input - 1); // 선택된 메뉴 카테고리
                    Category(sc, selectedMenu); // 카테고리 화면으로 이동
                } else {
                    System.out.println("잘못된 메뉴 번호입니다. 다시 시도해 주세요.");
                }

            } catch (InputMismatchException e) {
                System.out.println("숫자 입력만 가능합니다. 메뉴 번호를 다시 입력하세요.");
                sc.nextLine();  // 잘못된 입력 처리
            }
        }
    }

    /**
     * 선택된 카테고리에서 해당 메뉴 항목을 출력하고, 사용자가 번호를 선택하면 장바구니에 추가되어 주문을 확인
     *
     * @param sc Scanner 객체
     * @param selectedMenu 선택된 메뉴 카테고리
     */
    private void Category(Scanner sc, Menu selectedMenu) {
        boolean isRunning = true;
        while (isRunning) {
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
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");
                    cart.addItemToCart(selectedItem); // 장바구니에 메뉴 항목 추가
                    currentOrder.confirmOrder(); // 주문 확인
                    System.out.println("\n[ Total ]");
                    System.out.println("W " + cart.getTotalPrice() + "\n");
                    currentOrder.submitOrder();
                    isRunning = false;
                } else {
                    System.out.println("잘못된 메뉴 번호입니다. 다시 시도해 주세요.");
                }

            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력하세요.");
                sc.nextLine(); // 잘못된 입력 처리
            }
        }
    }

    /**
     * 메인 메뉴로 돌아가는 메서드.
     * Kiosk의 Start() 메서드 다시 호출 후 메인 메뉴 표시.
     */
    public void showMainMenu() {
        Start(); // 메인 메뉴로 돌아가려면 Start()를 호출
    }
}
