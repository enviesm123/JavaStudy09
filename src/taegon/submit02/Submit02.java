package taegon.submit02;

import java.util.Scanner;

public class Submit02 {

    public static void main(String[] args) {

//        사용자로부터 이름, 국어 점수, 영어 점수, 수학 점수를 입력 받고,
//
//                이름, 국어 점수, 영어 점수, 수학 점수, 평균을 콘솔창에 출력해보세요.
//        실행 결과 예시
//        @ 평균이 소수 두번째자리까지만 출력될 수 있도록 코드를 작성해주세요.

        Scanner scan = new Scanner(System.in);
        System.out.println("이름을 입력해 주세요.\n");
        System.out.print(">>> ");
        String name = scan.nextLine();

        System.out.println("국어점수를 입력해 주세요.\n");
        System.out.print(">>> ");
        String scoreLang = scan.nextLine();
        int intLang = Integer.parseInt(scoreLang);


        System.out.println("영어점수를 입력해 주세요.\n");
        System.out.print(">>> ");
        String scoreEn = scan.nextLine();
        int intEn = Integer.parseInt(scoreEn);

        System.out.println("수학점수를 입력해 주세요.\n");
        System.out.print(">>> ");
        String scoreMath = scan.nextLine();
        int intMath = Integer.parseInt(scoreMath);

       double floNum = (double) (intLang + intEn +  intMath )/ 3 ;
        System.out.println(floNum);
        System.out.println("이름: " + name);
        System.out.println("국어: " + scoreLang);
        System.out.println("영어: " + scoreEn);
        System.out.println("수학: " + scoreMath);
        System.out.printf("평균: %.2f\n",  floNum  );


        System.out.println("\n=================================\n");
        //각자리수를 더한 결과 출력 2 + 7 + 8
        int example = 278;

        // 자동 형변환을 이용한 int -> String 변환
        String example1 = example + "";
        // "278"

        System.out.println(example1+example1);

        String a = example1.substring(0,1); //substring(시작,끝) 을 자른다
        System.out.println(a);
        String b = example1.substring(1,2);
        String c = example1.substring(2,3);

        int d = Integer.parseInt(a); //2
        int e = Integer.parseInt(b); //7
        int f = Integer.parseInt(c); //8

        System.out.println(d+e+f);



    }
}
