package challenge1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Cart 클래스는 사용자가 선택한 메뉴 항목을 저장하고 관리하는 장바구니 역할을 합니다.
 * 장바구니에 아이템을 추가하고, 장바구니에 있는 아이템을 출력하며, 총 가격을 계산하는 기능을 제공합니다.
 * 사용자가 메뉴 항목을 추가하거나 취소하는 기능을 포함하고 있습니다.
 *
 */
public class Cart {

    /** Kiosk 객체. Cart와 상호작용하는 Kiosk 인스턴스를 가리킴. */
    Kiosk kiosk;

    /** 장바구니에 담긴 메뉴 항목들을 저장하는 리스트. */
    private ArrayList<MenuItem> menulist;

    /**
     * Cart 객체를 생성하고, Kiosk 객체를 초기화.
     *
     * @param kiosk Kiosk 객체, 이 Cart 객체가 상호작용하는 Kiosk 인스턴스
     */
    public Cart(Kiosk kiosk) {
        this.kiosk = kiosk; // Kiosk 객체를 전달받아 연결
        this.menulist = new ArrayList<>();
    }

    /**
     * 사용자가 메뉴 항목을 확인하고 선택 후 추가가능.
     *
     * @param selectedItem 추가할 메뉴 항목
     */
    public void addItemToCart(MenuItem selectedItem) {
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt(); // 사용자의 선택을 받음
            switch (choice) {
                case 1:
                    menulist.add(selectedItem); // 메뉴 항목 추가
                    break;
                case 2:
                    System.out.println("선택을 취소했습니다.\n");
                    kiosk.showMainMenu(); // 취소시 메인 메뉴로 돌아가기
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    kiosk.showMainMenu(); // 잘못된 입력시 다시 메인 메뉴로 돌아가기
            }
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            sc.nextLine(); // 입력 버퍼 초기화
        }
    }

    /**
     * 장바구니가 비어있으면 "장바구니에 아이템이 없습니다."라는 메시지를 출력.
     */
    public void printCart() {
        if (menulist == null || menulist.isEmpty()) {
            System.out.println("장바구니에 아이템이 없습니다.");
        } else {
            System.out.println("[Orders]");
            for (MenuItem item : menulist) {
                System.out.println(item); // 각 메뉴 항목 출력
            }
        }
    }

    /**
     * 장바구니에 담긴 아이템들의 총 가격을 계산하여 반환.
     *
     * @return 장바구니에 담긴 아이템들의 총 가격
     */
    public double getTotalPrice() {
        double total = 0;
        for(MenuItem item: menulist) {
            total += item.getPrice(); // 가격 합산
        }
        return total;
    }
}
