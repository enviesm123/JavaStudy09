package taegon.submit11;

import taegon.submit10.Library;

import java.util.Scanner;

public class ProjectMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CalculatorDB calDB = CalculatorDB.getInstance();


    while (true){
        System.out.println("행동을 입력해 주세요.");
        System.out.println("1. 더하기 | 2. 빼기 | 3. 곱하기 | 4.나누기 | 5.종료");
        System.out.print(">>> ");

        int command = Integer.parseInt(scan.nextLine());

        if(command == 1){
            // 더하기
            while (true){
                System.out.println("숫자를 입력 해 주세요");
                System.out.print(">>> ");

                int num = Integer.parseInt(scan.nextLine());
                CalculatorDB.numPlus(num);
            }


        }else if(command == 2){
            // 빼기
        }else if(command == 3){
            // 곱하기
        }else if(command == 4){
            // 나누기
        }else{
            //종료
            System.out.println("종료 되었습니다.");
            break;
        }
    }






    }

}
