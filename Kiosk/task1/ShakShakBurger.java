package task1;

import java.util.Scanner;

/**
 * ShakShakBurger 프로그램을 간단하게 구현한 클래스입니다.
 * 이 클래스는 사용자가 메뉴 항목을 선택하여 주문을 확인할 수 있는 간단한 메뉴 기반 키오스크 시스템을 구현한 프로그램입니다.
 * 사용자는 여러 가지 버거 옵션 중에서 선택할 수 있으며, 선택한 항목에 대해 주문이 완료되었음을 확인할 수 있습니다.
 * 사용자가 종료 옵션(0)을 선택하면 프로그램이 종료됩니다.
 *
 * @author "hyewon"
 * @version "11.0.24"
 */
public class ShakShakBurger {

    /**
     * 이 메서드는 키오스크 주문 시스템을 실행합니다.
     * 사용자는 메뉴 항목을 선택하고, 선택된 항목에 대한 주문이 완료되었음을 확인할 수 있습니다.
     * 사용자가 종료(0) 옵션을 선택하면 프로그램이 종료됩니다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {  // 사용자가 종료를 선택할 때까지 반복
            System.out.println("[ SHAKESHACK MENU ]\n");
            System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
                    "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                    "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
                    "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n" +
                    "0. 종료      | 종료");

            System.out.println("메뉴를 입력하세요.");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.println("ShackBurger 주문이 완료되었습니다!");
                    break;
                case 2:
                    System.out.println("SmokeShack 주문이 완료되었습니다!");
                    break;
                case 3:
                    System.out.println("Cheeseburger 주문이 완료되었습니다!");
                    break;
                case 4:
                    System.out.println("Hamburger 주문이 완료되었습니다!");
                    break;
                case 0:
                    System.out.println("종료되었습니다.");
                    return; // 사용자가 0을 입력하면 프로그램 종료
                default: // 잘못된 입력 처리
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}
