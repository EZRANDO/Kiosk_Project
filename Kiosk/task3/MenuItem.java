package task3;

/**
 * 이 클래스는 메뉴 항목을 나타내며, 각 메뉴 항목의 이름, 가격 및 세부 설명을 포함합니다.
 * 메뉴 항목을 저장하고, 이를 출력하는 데 필요한 정보를 제공합니다.
 */
public class MenuItem {
    private String name;    // 메뉴 항목 이름
    private double price;   // 메뉴 항목 가격
    private String details; // 메뉴 항목 세부 설명

    /**
     * MenuItem 객체 생성
     *
     * @param name 메뉴 항목의 이름
     * @param price 메뉴 항목의 가격
     * @param details 메뉴 항목의 세부 설명
     */
    public MenuItem(String name, double price, String details) {
        this.name = name;
        this.price = price;
        this.details = details;
    }

    /**
     * 메뉴 항목의 이름을 반환.
     *
     * @return 메뉴 항목의 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 메뉴 항목의 가격을 반환.
     *
     * @return 메뉴 항목의 가격
     */
    public double getPrice() {
        return price;
    }

    /**
     * 메뉴 항목의 세부 설명을 반환.
     *
     * @return 메뉴 항목의 세부 설명
     */
    public String getDetails() {
        return details;
    }

    /**
     * 메뉴 항목을 출력할 때 사용되는 문자열을 반환.
     *
     * @return (이름 | 가격 | 설명)
     */
    public String toString() {
        return name + " | $" + price + " | " + details;
    }
}
