package challenge1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu(); // Menu 객체 생성
        ArrayList<Menu> menus = menu.LoadMenu(); // 메뉴 로드

        // 키오스크 시작
        Kiosk kiosk = new Kiosk(menus);
        kiosk.Start();
    }

}
