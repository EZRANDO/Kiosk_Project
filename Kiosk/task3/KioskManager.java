package task3;

/**
 * 이 클래스는 Kiosk 시스템을 시작하는 역할을 합니다.
 * Kiosk 객체를 생성하고, 이를 통해 사용자가 메뉴를 선택하고 주문을 진행할 수 있는 기능을 시작합니다.
 */
public class KioskManager {

    /**
     * Kiosk 시스템을 실행하는 메인 메서드입니다.
     * Kiosk 객체를 생성 후 해당 Kiosk 시스템을 실행하는 메서드 호출
     */
    public static void main(String[] args) {
        // Kiosk 객체 생성 (이름과 기본 가격 전달)
        Kiosk kiosk = new Kiosk("ShakShak Kiosk", 0.0);
        // Kiosk 시작
        kiosk.Start();
    }
}