package challenge1;

import java.util.Scanner;

/**
 * 주문 메뉴를 처리하는 클래스입니다. 사용자가 장바구니를 확인하거나 주문을 제출하는 기능을 제공합니다.
 * 이 클래스는 Kiosk 객체와 Cart 객체를 사용하여, 사용자로부터 입력을 받아 주문을 처리합니다.
 *
 */
public class OrderMenu {
    private Cart cart; // 장바구니 객체
    private Kiosk kiosk; // Kiosk 객체

    /**
     * OrderMenu 객체를 생성하는 생성자. Cart와 Kiosk 객체 초기화
     *
     * @param cart 장바구니 객체
     * @param kiosk Kiosk 객체
     */
    public OrderMenu(Cart cart, Kiosk kiosk) {
        this.cart = cart;
        this.kiosk = kiosk; // 필요에 따라 kiosk 사용
    }

    /**
     * 주문을 확인하는 메서드 사용자가 주문을 확정 또는 취소 가능
     *
     * @throws Exception 잘못된 입력을 처리합니다.
     */
    public void confirmOrder() {
        System.out.println("[ORDER MENU]");
        System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.\n");
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt();
            switch (choice) {
                case 4:
                    System.out.println("아래와 같이 주문하시겠습니까?\n");
                    cart.printCart(); // 장바구니 출력
                    return; // 주문 확정
                case 5:
                    System.out.println("선택을 취소했습니다.");
                    kiosk.showMainMenu(); // 메인 메뉴로 돌아가기
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    kiosk.showMainMenu(); // 잘못된 입력 처리 후 메인 메뉴로 돌아가기
            }
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            sc.nextLine(); // 입력 버퍼 초기화
        }
    }

    /**
     * 주문을 제출하는 메서드. 사용자가 주문을 제출 또는 취소 가능.
     *
     * @throws Exception 잘못된 입력을 처리합니다.
     */
    public void submitOrder() {
        System.out.println("4. 주문");
        System.out.println("5. 메뉴판\n");
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt();
            switch (choice) {
                case 4:
                    System.out.println("주문이 완료되었습니다. 금액은 W 8.9 입니다.");
                    System.exit(0);
                    break;
                case 5:
                    System.out.println("메뉴판");
                    kiosk.showMainMenu(); // 메뉴판으로 돌아가기
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    kiosk.showMainMenu(); // 잘못된 입력 처리 후 메뉴로 돌아가기
            }
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            sc.nextLine(); // 입력 버퍼 초기화
        }
    }
}
