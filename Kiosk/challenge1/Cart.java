package challenge1;

import java.util.ArrayList;

public class Cart {
    private ArrayList<MenuItem> items;  // 장바구니에 담긴 메뉴 아이템들

    // 장바구니 초기화
    public Cart() {
        this.items = new ArrayList<>();
    }

    // 장바구니에 아이템 추가
    public void addItem(MenuItem item) {
        items.add(item);
    }

    // 장바구니 아이템 삭제
    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    // 장바구니 출력
    public void printCart() {
        if (items.isEmpty()) {
            System.out.println("장바구니에 아이템이 없습니다.");
        } else {
            System.out.println("[장바구니]");
            for (MenuItem item : items) {
                System.out.println(item);
            }
        }
    }

    // 장바구니에 있는 아이템 개수 반환
    public int getItemCount() {
        return items.size();
    }
}
