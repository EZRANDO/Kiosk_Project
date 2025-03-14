package task4;

import java.util.ArrayList;
/**
 * 이 클래스는 프로그램의 진입점으로, 메뉴를 로드하고 Kiosk 객체를 실행하여 사용자와의 상호작용을 시작합니다.
 */
public class Main {
    public static void main(String[] args) {
        Menu menuLoader = new Menu();
        ArrayList<Menu> menus = menuLoader.LoadMenu();
        // Kiosk 실행
        Kiosk kiosk = new Kiosk(menus);
        kiosk.Start();
    }
}
