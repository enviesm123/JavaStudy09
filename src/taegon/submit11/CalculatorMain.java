package taegon.submit11;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator calculator = new Calculator();


        System.out.println("=======================");
        System.out.println("======== 계산기 ========");
        System.out.println("=======================");

        while(true){
            System.out.println("[1] || 계   산   기 ====");
            System.out.println("=======================");
            System.out.println("[2] || 종       료 =====");
            System.out.println("=======================");
            System.out.print(">>> ");

            double command = Double.parseDouble(scan.nextLine());



            if(command == 1){
                System.out.print("첫번째 번호 : ");

                double firstNum = Double.parseDouble(scan.nextLine());
                double result = 0.0;
                while (true) {
                    // 계산기
                    System.out.print("연산자 입력(+,-,/,*) : ");
                    String operator = scan.nextLine();

                    System.out.print("두번째 번호 : ");
                    double secondNum = Double.parseDouble(scan.nextLine());


                    if (operator.equals("+") && result == 0) {
                        // 더하기

                        result =  Calculator.add(firstNum, secondNum);
                        System.out.println("출력 결과: " + result);
                        continue;

                    } else if (operator.equals("+")&& result != 0) {

                        result += secondNum;
                        System.out.println("출력 결과: " + result);
                        continue;


                    }
                    if (operator.equals("-") && result == 0) {
                        // 빼기
                        result = Calculator.minus(firstNum, secondNum);
                        System.out.println("출력 결과: " + result);
                        continue;
                    } else if (operator.equals("-") && result != 0) {

                        result -= secondNum;
                        System.out.println("출력 결과: " + result);
                        continue;
                    }
                    if (operator.equals("/")&& result == 0) {
                        // 나누기
                        result = Calculator.division(firstNum, secondNum);
                        System.out.println("출력 결과: " + result);
                        continue;
                    }else if(operator.equals("/")&& result != 0){

                        result /= secondNum;
                        System.out.println("출력 결과: " + result);
                        continue;
                    }

                    if (operator.equals("*") && result == 0 && secondNum != 0) {
                        // 곱하기
                        result = Calculator.multiple(firstNum, secondNum);
                        System.out.println("출력 결과: " + result);
                        continue;
                    } else if (operator.equals("*") && result != 0 && secondNum != 0) {

                        result *= secondNum;
                        System.out.println("출력 결과: " + result);
                        continue;
                    } else {
                        System.out.println("잘못된 연산자를 입력 하셨습니다.");
                        continue;
                    }
                }

            }else if(command == 2){
                // 종료
                System.out.println("종료 되었습니다.");
                break;

            }





        }






    }

}
