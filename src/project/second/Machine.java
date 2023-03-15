package project.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Machine {
    public static void main(String[] args) throws IOException {
        /**
         *  변수 추가
         *  1. 메뉴 선택
         *  2. 사용자 자산 금액
         *  3.
         *
         * */

        /**
         * 메뉴
         * 1. 현재 자산 확인
         *   1-2. 자산 추가, 차감
         * 2. 자판기 확인
         *   2-1. 자판기 메뉴, 금액
         *   2-2. 자산 > 상품액: 구매 가능
         *   2-3. 자산 < 상품액: 구매 불가능 (3-1로 돌아가기)
         *   2-4. 본 메뉴로 나가기
         * 3. 프로그램 종료하기
         * */

        int money = 0;
        int add_money = 0;
        int withdraw_money = 0;

        // 상품 변수
        String[] product = new String[]{"콜라", "사이다", "커피", "파워에이드", "하늘보리"};
        int[] price = new int[]{1000, 1000, 1000, 1500, 1500};

        // 3자리마다 콤마
        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        while(true) {
            // 인사말
            System.out.println("========== START ==========");
            System.out.println("안녕하세요, 저는 자판기 입니다.");
            System.out.println("메뉴를 선택해주세요!\n");
            System.out.println("------ 메뉴 ------");
            System.out.println("1) 자산 확인");
            System.out.println("2) 자판기 확인");
            System.out.println("3) 프로그램 종료");

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("번호 선택 >> ");
            int m_number = Integer.parseInt(bf.readLine());
            System.out.println(m_number + "번을 선택하셨습니다.");

            if (m_number == 1) { // money check
                System.out.println("\n-->현재 자산은 " + money + "원 입니다.");
                System.out.println("------ 자산 메뉴 ------");
                System.out.println("1) 자산 추가");
                System.out.println("2) 자산 차감");
                System.out.println("3) 이전으로");

                System.out.print("번호 선택 >> ");
                m_number = Integer.parseInt(bf.readLine());

                if (m_number == 1) { // add money
                    System.out.print("추가 금액 입력: ");
                    add_money = Integer.parseInt(bf.readLine());

                    if (add_money >= 0) {
                        System.out.println(add_money + "원이 정상적으로 추가되었습니다.");
                        money += add_money;
                    }else {
                        System.out.println("올바르게 입력해주세요.");
                    }
                }else if(m_number == 2){ // withdraw money
                    if(money <= 0){
                        System.out.println("\n인출 가능한 금액이 없습니다.");
                    }else{
                        System.out.print("인출할 금액 입력: ");
                        withdraw_money = Integer.parseInt(bf.readLine());

                        if(money >= withdraw_money){
                            System.out.println(withdraw_money + "원이 정상적으로 인출되었습니다.");
                            money -= withdraw_money;
                        }else{
                            System.out.println("인출 가능한 금액이 부족하여, 이전 메뉴로 되돌아갑니다.");
                        }
                    }
                }else if(m_number == 3){ // back
                    System.out.println("이전 메뉴로 되돌아갑니다.");
                    continue;
                }else{
                    System.out.println("올바르게 입력해주세요.");
                }

                System.out.println("총 자산은 " + money + "원 입니다.");

            } else if (m_number == 2) { // vending machine menu
                System.out.println("\n------ 자판기 메뉴 ------");
                for(int i = 0; i < product.length; i++){
                    System.out.println(i + 1 + ") " + product[i] + " (" + decimalFormat.format(price[i]) + "원)");
                }
                System.out.println(product.length + 1 + ") 이전으로");
                System.out.print("메뉴 선택 >> ");
                m_number = Integer.parseInt(bf.readLine());

                if(m_number > 0 && m_number <= product.length){ // menu select
                    System.out.println(product[m_number - 1] + "(" + decimalFormat.format(price[m_number - 1]) + "원)를 선택하셨습니다.");

                    if(money >= price[m_number- 1]){ // money >= price
                        System.out.println(product[m_number - 1] + " 구매가 완료되었습니다.");
                        money -= price[m_number - 1];
                        System.out.println("최종 자산은 " + money + "원 입니다.");
                    }else{ // money < price
                        System.out.println("자산이 부족하여, 상품 구매에 실패하였습니다.");
                    }

                }else if(m_number == product.length + 1){ // back
                    System.out.println("이전 메뉴로 되돌아갑니다.");
                    continue;
                }else{
                    System.out.println("올바른 메뉴를 선택해주세요.");
                }

            } else if (m_number == 3) { // program exit
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            } else {
                System.out.println("올바른 번호를 입력해주세요.");
            }

        }

    }
}
