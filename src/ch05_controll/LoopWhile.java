package ch05_controll;

import java.util.Scanner;

public class LoopWhile {

    public static void main(String[] args) {
        // while 문
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
        }
        // while 문은 소괄호 내 조건이 true 이면
        // 조건이 false가 될때까지 중괄호 내부 코드를 반복 실행
        int i = 1; // 초기화식
        while(i <= 10){ // 조건식
            System.out.println(i);
            i++; // 증감식

        }


        // while문으로 구구단 2단 출력

        int k = 1;
        while(k <= 9){
            System.out.println("2 x " + k + " = " + (2 * k));
            k++;
        }

        // 둘다 반복문일 뿐이지만
        // for문은 반복횟수가 정해진, 뚜렷한 경우에 사용하면 좋음
        // while 문은 반복횟수가 애매한 경우에 사용하면 좋음

        System.out.println("\n==================\n");

        Scanner scan = new Scanner(System.in);

        boolean isRun = true;

//        // 사용자가 q를 입력하면 종료하게 만들기
//        while(isRun){
//            System.out.print("채팅입력: ");
//            String inputText = scan.nextLine();
//
//            if(inputText.equals("q")){
//                isRun = false;
//            }
//            System.out.println(inputText);
//        }

//        while(true){
//            System.out.print("채팅입력: ");
//            String inputText = scan.nextLine();
//
//            if(inputText.equals("q")){
//                // while 문 또한 break 실행시 바로 종료가 된다.
//                break;
//            }
//
//            System.out.println(inputText);
//        }

        // do-while문
        // 반복해야할 내용이 최소 한번은 무조건 실행되게끔 하고 싶을때 사용
        // (굳이 몰라도된다)
        isRun = false;
        do{
            System.out.println("반복될 내용");
        }while(isRun);

        System.out.println("\n==================\n");

        // while문 또한 다중으로 사용 가능
        // 포켓몬스터
        int hp = 100;
        // 이 while문의 이름이 outer가 됨
        outer: while(true){
            System.out.println("야생의 피카츄를 만났습니다.");
            System.out.println("행동을 선택해주세요");
            System.out.println("1. 공격 | 2. 도망");
            System.out.print(">>> ");

           int command = Integer.parseInt(scan.nextLine());

           if(command == 1){
               // TODO 공격
               while(true){
                   System.out.println("공격 방법 선택");
                   System.out.println("1. 몸통박치기 | 2. 하이드로펌프 | 3. 취소");
                   System.out.print(">>> ");

                   int attack = Integer.parseInt(scan.nextLine());

                   if(attack == 1){
                       System.out.println("몸통박치기 시전");
                       hp -= 20;
                   }else if(attack == 2){
                       System.out.println("하이드로펌프 시전");
                       hp -= 40;
                   }else if(attack == 3){
                       // 취소
                       // 가까운 반복문 1개를 즉시 종료
                       // 내부 while문만 종료된다.
                       break;
                   }

                   if(hp <= 0){
                       System.out.println("피카츄를 잡았다~!!");
                       // 외부 while문을 종료 시키려면??
                       // System.exit(0); // 프로그램 종료
                       // 외부 while문에 네임태그 설정
                        break outer; //해당 이름을 가진 while문 종료
                   }
               }
           }else if(command == 2){
               System.out.println("메다닥 도망갔습니다.");
               break;
           }else{
               System.out.println("잘못 입력하셨습니다.");
           }

        }



    }
}
