package task2;

/**
 * 메뉴 항목을 나타내는 클래스입니다.
 * 각 메뉴의 이름, 가격, 세부 정보를 저장하고 관리합니다.
 *
 * @author "hyewon"
 * @version "11.0.24"
 */
public class MenuItem {
    private String name;      // 메뉴 이름
    private double price;     // 메뉴 가격
    private String details;   // 메뉴 설명

    /**
     * 이름, 가격, 세부 정보를 받아 메뉴 항목 생성
     *
     * @param name    메뉴의 이름
     * @param price   메뉴의 가격
     * @param details 메뉴의 세부 설명
     */
    public MenuItem(String name, double price, String details) {
        this.name = name;
        this.price = price;
        this.details = details;
    }

    /**
     * 이름만 받아서 메뉴 항목을 생성.
     * 가격은 0.0, 세부 설명은 빈 문자열("")로 기본값으로 설정
     * @param name 메뉴의 이름
     */
    public MenuItem(String name) {
        this.name = name;
        this.price = 0.0;  // 기본값
        this.details = ""; // 기본값
    }

    /**
     * @return 메뉴의 이름
     */
    public String getName() {
        return name;
    }

    /**
     * @return 메뉴의 가격
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return 메뉴의 세부 정보
     */
    public String getDetails() {
        return details;
    }

    /**
     *
     * 형식: "이름 | $가격 | 세부정보"
     * @return 메뉴 항목의 문자열 표현
     */
    @Override
    public String toString() {
        return name + " | $" + price + " | " + details;
    }
}
