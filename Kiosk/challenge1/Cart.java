package challenge1;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    Kiosk kiosk;
    private ArrayList<MenuItem> menulist;

    public Cart(Kiosk kiosk) {
        this.kiosk = kiosk; // Kiosk 객체를 전달받아 연결
        this.menulist = new ArrayList<>();
    }

    public void addItemToCart(MenuItem selectedItem) {
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    menulist.add(selectedItem);
                    break;
                case 2:
                    System.out.println("선택을 취소했습니다.\n");
                    kiosk.showMainMenu();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    kiosk.showMainMenu();
            }
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            sc.nextLine(); // 입력 버퍼 초기화
        }
    }
    public void printCart() {
        if (menulist == null || menulist.isEmpty()) {
            System.out.println("장바구니에 아이템이 없습니다.");
        } else {
            System.out.println("[Orders]");
            for (MenuItem item : menulist) {
                System.out.println(item);

            }
        }
    }
    public double getTotalPrice() {
        double total = 0;
        for(MenuItem item: menulist) {
            total += item.getPrice();
        }
        return total;
    }

}

