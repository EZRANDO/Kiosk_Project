package challenge1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {
    private final ArrayList<Menu> menu;
    private final ArrayList<MenuItem> cart;

    public Kiosk(ArrayList<Menu> menu) {
        this.menu = menu;
        this.cart = new ArrayList<>();
    }

    public void Start() {
        Scanner sc = new Scanner(System.in);// 스캐너 선언

        while (true) {// 반복문 시작
            System.out.println("[ MAIN MENU ]");
            System.out.println("메뉴 번호를 입력하세요. 0번을 누르면 프로그램이 종료됩니다.");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i).getCategoryName());
            }
            System.out.println("0. 종료");
            try {
                int input = sc.nextInt();// 숫자 입력 받기

                if (input == 0) {
                    System.out.println("프로그램이 종료됩니다.");
                    break;
                }

                if (input >= 1 && input <= menu.size()) {
                    Menu selectedMenu = menu.get(input - 1);
                    Category(sc, selectedMenu);
                } else {
                    System.out.println("잘못된 메뉴 번호입니다. 다시 시도해 주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자 입력만 가능합니다. 메뉴 번호를 다시 입력하세요.");
                sc.nextLine();  // 버퍼를 비워주기 위해 nextLine() 호출 (콘솔에 계속 반복 출력되는 문제를 해결 숫자가 아닌 글자를 입력하면 잘못된 입력을 처리하기 위해 nextInt()를 계속 호출함. ->무한루프)
            }

        }
    }

    private void Category(Scanner sc, Menu selectedMenu) {
        while (true) {
            System.out.println("[ " + selectedMenu.getCategoryName() + " MENU ]");
            selectedMenu.printMenuItems();
            System.out.println("0. 뒤로가기");

            try {
                int input = sc.nextInt();
                if(input ==0) {
                    System.out.println("이전 화면으로 돌아갑니다.");
                    break;//메뉴 선택안하고 뒤로감
                }
                ArrayList<MenuItem> items = selectedMenu.getItems();
                //System.out.println("디버깅: input = " + input + ", items.size() = " + items.size());

                if (input >= 1 && input <= items.size()) {
                    MenuItem selectedItem = items.get(input-1); // items에서 선택한 항목을 가져옴
                    System.out.println("선택한 메뉴: " + selectedItem.getName());
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인        2. 취소 ");

                    int input2 = sc.nextInt();
                    if(input2 == 1) {
                        selectedMenu.getCart().addItem(selectedItem);
                        System.out.println(selectedItem.getName() + "이 장바구니에 추가되었습니다.");
                    }else if(input2 == 2){
                        System.out.println("취소하였습니다.");
                        break;
                    }
                } else {
                    System.out.println("잘못된 번호입니다. 다시 입력하세요.");
                }
            }catch (InputMismatchException e) {
                System.out.println("숫자만 입력하세요.");
                sc.nextLine();
            }
        }
    }
}
