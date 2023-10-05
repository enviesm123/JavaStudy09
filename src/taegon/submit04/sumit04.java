package taegon.submit04;

import ch06_method.MethodMain;

import java.util.Scanner;

public class sumit04 {

    public static void main(String[] args) {


//        Q. 01
//
//        엘리베이터가 두 대 있는 빌딩에서 엘리베이터 버튼을 눌렀을 때, 한 대의 엘리베이터만 이동하는 프로그램을 구현해 봅시다.
//
//        1. 사용자가 현재 위치를 입력하면 사용자의 위치와 가까운 엘리베이터가 이동한다.
//
//        2. 사용자의 위치와 두 엘리베이터의 위치 차이가 동일하다면 위 층 엘리베이터가 내려온다.
//                ex) 엘리베이터 A는 1층, B는 7층일때 사용자의 위치가 4층이면 엘리베이터 B가 내려온다.
//
//        3. 사용자의 위치로 엘리베이터의 위치를 바꿔준다.
//
//        4. (엘리베이터 프로그램을 종료하려면 q, exit 중 하나를 입력한다.)

        Scanner scan = new Scanner(System.in);

        // 엘리베이터 A의 층
        int elevatorA = 10;
        // 엘리베이터 B의 층
        int elevatorB = 4;

        while (true) {
            System.out.println("==========희영빌딩 엘리베이터========");
            System.out.println("승강기 A의 현재 위치: " + elevatorA);
            System.out.println("승강기 B의 현재 위치: " + elevatorB);
            System.out.print("몇층에 계시나요? [종료 하시려면 q 또는 exit 입력] ");

            // 층을 입력받기
            String command = scan.nextLine(); // "4", "q"
            // 입력받은 층에 대한 엘리베이터 A와의 차이 구하기
            // 입력받은 층에 대한 엘리베이터 B와의 차이 구하기

            // A 위치차이와 B 위치차이의 크기를 비교해서
            // 크기가 더 작은 엘리베이터를 이동시킨다.


            if (command.equals("q") || command.equals("exit")) {
                System.out.println("프로그램이 종료 되었습니다.");
                break;
            }

            // command가 "4"인 경우
            int floor = Integer.parseInt(command);

            // 입력받은 층에 대한 엘리베이터 A와의 차이 구하기
            int diffA = Math.abs(elevatorA - floor); // 10 - 8 = 2

            // 입력받은 층에 대한 엘리베이터 B와의 차이 구하기
            int diffB = MethodMain.myAbs(elevatorB - floor); // 4 - 8 = 4

            // A 위치차이와 B 위치차이의 크기를 비교해서
            // 크기가 더 작은 엘리베이터를 이동시킨다.

            if (Math.abs(diffA) < diffB) {
                System.out.println("승강기 A가 " + floor + "층으로 이동하였습니다.");
                elevatorA = floor;

            } else if (diffA > diffB) {
                System.out.println("승강기 B가 " + floor + "층으로 이동하였습니다.");
                elevatorB = floor;
            } else {
                // 층수 차이가 같으면 더 위층에 있는 엘리베이터가 이동
                if (elevatorA > elevatorB) {
                    System.out.println("승강기 A가 " + floor + "층으로 이동하였습니다.");
                    elevatorA = floor;
                } else {
                    System.out.println("승강기 B가 " + floor + "층으로 이동하였습니다.");
                    elevatorB = floor;
                }
            }

        }
    }
}
