package ch01_start;

import java.sql.SQLOutput;

public class HelloWorld {
    //main 메소드 (main 치고 자동완성)
    public static void main(String[] args) {
        // 코드 실행 [쉬프트 +F10]
        //main 메소드 내에 존재하는 코드가 실행이 된다.

        //코드 라인 복사 [Ctrl + D]
        System.out.println("Hello World!!");
        System.out.println("Hello World!!");

        // 코드 라인 삭제 [Ctrl +Y]
        // 실행 취소 [Ctrl + Z]
        // 실행 취소의 취소 [Ctrl + Shift + Z ]

        // 자동완성 [Ctrl + Space]
        System.out.println();
        //so 입력 후 엔터
        System.out.println();


        for (int i = 0; i < 5; i++) {
            // n 번 반복
            String blank = "";
            for (int k = 0; k < 5 - i; k++) {
                // 빈칸먼저 그리기
                // 4
                // 3
                // 2
                // 1
                blank += " ";
            }

            // 별찍
            String stars = "";
            for (int k = 0; k < (i * 2) + 1; k++) {
                stars += "*";

                System.out.println(blank + stars);

            }
        }


    }
}
