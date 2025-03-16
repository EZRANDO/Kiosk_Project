package challenge1;

import java.util.ArrayList;

/**
 * 이 클래스는 특정 카테고리에 해당하는 메뉴 항목들을 관리합니다. 메뉴 항목은 `MenuItem` 객체로 구성되어 있으며,
 * 각 카테고리마다 여러 메뉴 항목을 추가할 수 있습니다.
 */
public class Menu {
    private String name;
    private String categoryName; // 카테고리 이름 (Burgers, Drinks, Desserts 등)
    private ArrayList<MenuItem> items; // 메뉴 항목 리스트

    /**
     * 카테고리 이름을 받아서 `Menu` 객체를 생성
     *
     * @param category 카테고리 이름
     */
    public Menu(String category) {
        this.categoryName = category; // category 인자를 categoryName에 할당
        this.items = new ArrayList<>();
    }

    /**
     * 기본 생성자
     */
    public Menu() {
        this.items = new ArrayList<>();
    }

    /**
     * 메뉴를 로드하는 메서드
     *
     * @return 메뉴 카테고리와 항목이 포함된 리스트
     */
    public ArrayList<Menu> LoadMenu() {
        ArrayList<Menu> menus = new ArrayList<>();

        // 각 카테고리에 해당하는 메뉴 생성
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

    /**
     * 카테고리 이름을 반환하는 메서드
     *
     * @return 카테고리 이름
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 메뉴 항목을 추가하는 메서드
     *
     * @param item 추가할 `MenuItem` 객체
     */
    public void addItem(MenuItem item) {
        items.add(item);
    }

    /**
     * 메뉴 항목 리스트를 순차적으로 출력하는 메서드
     */
    public void printMenuItems() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    /**
     * 메뉴 항목 리스트를 반환하는 메서드
     *
     * @return 메뉴 항목 리스트
     */
    public ArrayList<MenuItem> getItems() {
        return items;
    }

    /**
     * 메뉴의 카테고리 이름을 반환하는 메서드
     *
     * @return 카테고리 이름
     */
    public String toString() {
        return categoryName;
    }

    public String getName() {
        return name;
    }

}
