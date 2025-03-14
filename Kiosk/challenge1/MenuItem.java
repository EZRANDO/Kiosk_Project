package challenge1;

import java.util.ArrayList;

public class MenuItem {
    //일단 하위 메뉴를 갖기 위해 만듦.
    private ArrayList<MenuItem> menuItems;
    private String name;
    private double price;
    private String details;
    private String categoryName;

    public MenuItem(String name, double price, String details) {
        this.name = name;
        this.price =price;
        this.details = details;
    }
    public MenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name; // 메뉴 이름 반환
    }
    //    public String getdetails() {
//        return details;
//    }
//    public double getPrice() {
//        return price;
//    }
    public String toString() {
        // name과 price를 포함한 정보 출력
        return name + " - " + price + "원 - " + details;
    }

}