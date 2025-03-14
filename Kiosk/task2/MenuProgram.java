package task2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Shake Shack 메뉴를 출력하고 사용자로부터 입력을 받아
 * 메뉴를 선택할 수 있는 프로그램입니다.
 *
 * 사용자는 메뉴 번호를 입력해 원하는 항목을 선택할 수 있으며,
 * 0을 입력하면 프로그램이 종료됩니다.
 *
 * @author "hyewon"
 * @version  "11.0.24"
 */
public class MenuProgram {

    /**
     * 프로그램의 진입점으로, Shake Shack 메뉴를 출력하고
     * 사용자 입력을 처리합니다.
     *
     * 기능:
     * - 메뉴 출력
     * - 사용자로부터 메뉴 번호 입력받기
     * - 입력된 메뉴 번호에 따라 처리 수행
     * - 0 입력 시 프로그램 종료
     *
     * 예외 처리:
     * - 숫자가 아닌 값 입력 시 InputMismatchException 처리
     *
     * @param args 프로그램 실행 시 전달되는 인자 (사용하지 않음)
     */
    public static void main(String[] args) {
        // List 선언 및 초기화
        ArrayList<MenuItem> items = new ArrayList<>();

        // 메뉴 항목 추가
        items.add(new MenuItem("1. ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        items.add(new MenuItem("2. SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        items.add(new MenuItem("3. Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        items.add(new MenuItem("4. Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        items.add(new MenuItem("0. 종료", 0.0, "프로그램을 종료합니다."));

        // 입력을 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        // 메뉴 반복 출력 및 사용자 입력 처리
        while (isRunning) {
            try {
                System.out.println("[ SHAKESHACK MENU ]\n");

                // 메뉴 출력
                for (MenuItem e : items) {
                    System.out.println(e);
                }

                System.out.println("메뉴 번호를 입력하세요.");
                int input = sc.nextInt();

                // 종료 조건 확인
                if (input == 0) {
                    System.out.println("프로그램 종료합니다.");
                    break;
                }

                // 유효한 메뉴 번호 처리
                if (input >= 1 && input <= 4) {
                    MenuItem selectedItem = items.get(input - 1);
                    System.out.println(selectedItem.getName() + "를 구매하였습니다.");
                } else {
                    System.out.println("잘못된 메뉴 번호입니다. 다시 시도해 주세요.");
                }

            } catch (InputMismatchException e) {
                // 입력값이 숫자가 아닌 경우 예외 처리
                System.out.println("숫자 입력만 가능합니다. 메뉴 번호를 다시 입력하세요.");
                sc.nextLine(); // 입력 버퍼 비우기
            }
        }
    }
}
