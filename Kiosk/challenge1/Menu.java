package challenge1;

import java.util.ArrayList;

public class Menu {
    private String categoryName; // 카테고리 이름 (Burgers, Drinks, Desserts 등)
    private ArrayList<MenuItem> items; // 메뉴 항목 리스트

    private Cart cart;

    // category 인자를 제대로 받는 생성자
    public Menu(String category) {
        this.categoryName = category; // category 인자를 categoryName에 할당
        this.items = new ArrayList<>();
        this.cart = new Cart();
    }

    // 기본 생성자
    public Menu() {
        this.items = new ArrayList<>();

    }

    public ArrayList<Menu> LoadMenu() {
        ArrayList<Menu> menus = new ArrayList<>();

        Menu menu1 = new Menu("Burgers");
        menu1.addItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menu1.addItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menu1.addItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menu1.addItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu menu2 = new Menu("Drinks");
        menu2.addItem(new MenuItem("Coke", 2.5, "시원한 코카콜라"));
        menu2.addItem(new MenuItem("Lemonade", 3.0, "상큼한 레몬에이드"));

        Menu menu3 = new Menu("Desserts");
        menu3.addItem(new MenuItem("French Fries", 3.5, "바삭한 프렌치 프라이"));
        menu3.addItem(new MenuItem("Chicken Nugget", 4.0, "치킨 너겟"));

        // 메뉴 리스트에 추가
        menus.add(menu1);
        menus.add(menu2);
        menus.add(menu3);
        return menus;
    }

    // List에 포함된 MenuItem을 순차적으로 보여주는 함수
    public void printMenuItems() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    public Cart getCart() {
        return cart;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void addItem(MenuItem item) {
        items.add(item);
    }
    public ArrayList<MenuItem> getItems() {
        return items; //메뉴항목 반환
    }
    public String toString() {
        return categoryName; // 카테고리 이름만 반환
    }
}