package task4;

import java.util.ArrayList;

/**
 * 이 클래스는 각 메뉴 항목을 나타내며, 메뉴 항목은 이름, 가격, 상세 정보 등을 포함하고 있습니다.
 * 하위 메뉴 항목을 관리할 수 있는 `menuItems` 리스트를 포함하고 있습니다.
 */
public class MenuItem {

    private ArrayList<MenuItem> menuItems; // 하위 메뉴 항목 리스트
    private String name; // 메뉴 이름
    private double price; // 메뉴 가격
    private String details; // 메뉴 상세 설명
    private String categoryName; // 메뉴 카테고리 이름

    /**
     * 메뉴 항목을 생성하는 생성자.
     *
     * @param name 메뉴 이름
     * @param price 메뉴 가격
     * @param details 메뉴의 상세 설명
     */
    public MenuItem(String name, double price, String details) {
        this.name = name;
        this.price = price;
        this.details = details;
    }

    /**
     * 메뉴 이름을 반환하는 메서드.
     *
     * @return 메뉴 이름
     */
    public String getName() {
        return name; // 메뉴 이름 반환
    }

    /**
     * 메뉴 항목의 정보를 출력하는 메서드.
     *
     * @return 메뉴 이름, 가격, 상세 설명을 포함한 문자열
     */
    public String toString() {
        return name + " - " + price + " - " + details;
    }
}
