package taegon.submit04;

import java.util.Scanner;

public class sumit04 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int elevatorA = 10;
        int elevatorB = 4;

        outer: while(true) {
            System.out.println("==========희영빌딩 엘리베이터========");
            System.out.println("승강기 A의 현재 위치: " + elevatorA);
            System.out.println("승강기 B의 현재 위치: " + elevatorB);
            System.out.print("몇층에 계시나요? [종료 하시려면 q 또는 exit 입력] ");

            // 층을 입력받기

            // 입력받은 층에 대한 엘리베이터 A와의 차이 구하기
            // 입력받은 층에 댛나 엘리베이터 B와의 차이 구하기

            // A 위치차이와 B 위치차이의 크기를 비교해서
            // 크기가 더 작은 엘리베이터를 이동시킨다.

            String command = scan.nextLine();;

            while(true){
                if((elevatorA - Integer.parseInt(command)) > (elevatorB - Integer.parseInt(command)) ){
                    System.out.println("승강기 B가 " + command + "층으로 이동하였습니다.");
                    break;
                }
                if((elevatorA - Integer.parseInt(command)) < (elevatorB - Integer.parseInt(command)) * -1){
                    System.out.println("승강기 A가 " + command + "층으로 이동하였습니다.");
                    break;
                }

                if(command.equals("q") || command.equals("exit")){
                    System.out.println("프로그램이 종료 되었습니다.");
                    break ;
                }
            }


        }
    }
}
