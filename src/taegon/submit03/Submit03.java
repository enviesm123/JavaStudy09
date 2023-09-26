package taegon.submit03;

public class Submit03 {

    public static void main(String[] args) {
//        팩토리얼 다들 기억하시나요?
//                수학기호로 4! 는 4 팩토리얼을 의미하며,
//        그 값은 4x3x2x1 = 24 입니다.
//                for문을 사용해서 10팩토리얼의 값을 출력해주세요.

        int gop = 1;
        // 10! 팩토리얼 구하기  10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
        for(int i = 10; i > 1; i--){
            gop *= i; // gop = gop * i
        }
        System.out.println(gop);

        System.out.println("\n========================\n");

        gop = 1;
        long gop1 = 1L;
        for(int g = 15; g > 1; g--){
          gop1 = gop1 * g; // gop = gop * i
        }
        System.out.println(gop1);
//        월리를 찾아라!!
//                아래의 문자열 변수 findWally 중에 월리가 몇개 들어있는지 콘솔에 출력해주세요.
                String findWally = "윌리울리일리울리울리일리월리일리윌리월리울리일리일리월리일리윌리일리윌리일" +
                        "리월리월리윌리울리윌리울리일리울리울리윌리일리";
//        Hint
//        수업시간에 해보았던 "슈"는 문자열을 한글자씩 잘라서 "슈"가 맞는지 비교하였다면,
//                이번에는 두글자씩 잘라서 "월리"가 맞는지 비교하시면 됩니다.
//
//
//        결과: 5
        int cntWally = 0;
        for(int i = 0; i < findWally.length()-1; i++){
            // 두글자씩 자르기 (0,2)(2,4)(4,6)
            System.out.println(findWally.substring(i, i+2));
            //월리가 있는지 체크
            if(findWally.substring(i, i+2).equals("월리")){
                // 월리가 있으면 숫자올리기
                cntWally++;
            }
        }
        System.out.println(cntWally);


//        Q. 03 거꾸로 트리를 5층 만들어주세요.

//        for문을 5번 반복하면서 stars를 아래와 같이 나오도록 잘라서 출력해보세요

//        Hint
//        for문 내에서 .substring() 사용
        String stars = "*****"; //
        // 5, 4, 3, 2, 1 나오게 하기
        for(int i = 5; i > 0; i--){

            // 별을 한개씩 줄여본다
            System.out.println(stars.substring(0, i));

//            System.out.println(stars.substring(0, i));

            }

//        Q. 04
//        로꾸꺼 로꾸꺼
//        사용자에게 문자열을 입력받으시고, 입력받은 문자열의 순서를 뒤집어서 출력해보세요.
//        Hint
//        for문 바깥에 문자열 변수 선언
//        for문 내부가 반복될때마다 입력받은 문자열을 한글자씩 잘라 문자열 변수에 더한다.


        String reVerse = "로꾸꺼 로꾸꺼";
        // 맨뒤의 글자를 자르기
        // 잘라서 새로운 문자열에 넣기
        String name ="";
        for(int i = 7; i > 0; i--){
            name += reVerse.substring(i-1, i);
        }
        System.out.println("거꾸로 뒤집을 문자열: " + reVerse);
        System.out.println("뒤집은 결과: " + name);









    }
}
