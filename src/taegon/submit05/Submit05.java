package taegon.submit05;

public class Submit05 {

    public static void main(String[] args) {

//        Q. 01
//        for문을 배울때, 트리를 참 많이 만들었죠?
//                근데 항상 5층짜리 트리여서 아쉬웠을거에요.
//                n층 짜리 트리를 출력할 수 있는 makeTree(int n) 메소드를 만들어서 실행시켜 주세요.

        makeTree(5);

//        로꾸꺼를 메소드로 만들어서
//        파라미터로 들어온 String 문자열에 대해 뒤집은 결과를 리턴하는 메소드를 만들어보세요.

        String example = "로꾸꺼 로꾸꺼";
        String result = reverseStr(example);
        System.out.println(result);

        //        십진수를 이진수(String 타입)로 리턴해주는 makeBinary(int 타입) 함수를 만들어보세요.
//        Hint
//        문자열 변수를 하나 선언해서
//        입력받은 정수를 2로 나눈 나머지를 문자열 변수에 더한다.
//        그 다음 입력받은 정수를 2로 나눈 몫을 이용하여 위 과정을 반복한다.
//        2로 나눈 몫이 1이 된다면 반복을 종료한다.
//        이진수로 만들어진 문자열 변수를 거꾸로(로꾸꺼) 뒤집은 다음 리턴한다.


        String myBinaryStr = makeBinary(23);
        System.out.println(myBinaryStr);



    }

    public static String makeBinary(int num){

        String str = "";

        //입력받은 정수를 2로 나눈 나머지를 문자열 변수에 더한다.
        //str = num % 2; 11101

        //그 다음 입력받은 정수를 2로 나눈 몫을 이용하여 위 과정을 반복한다.

        // num = 23;

        // 1. num / 2 -> 23 / 2 = 몫 11 나머지 1


        // 2. num / 2 -> 11 / 2 = 몫 5 나머지 1
        // 3. num / 2 -> 5 / 2 = 몫 2 나머지 1
        // 4. num / 2 -> 2 / 2 = 몫 1 나머지 0
        // 5. num / 2 -> 1 / 2 = 몫 0 나머지 1

//        2로 나눈 몫이 1이 된다면 반복을 종료한다.
        while(num > 0){
            str += num % 2;
            num = num / 2;
        }

//        이진수로 만들어진 문자열 변수를 거꾸로(로꾸꺼) 뒤집은 다음 리턴한다.
//         10111
        String reverse = "";
//        reverse = reverseStr(str);
        for(int i = 0; i < str.length(); i++){
            reverse += str.substring(str.length()-1-i,str.length()-i) ;
            // "" = "" + 1
            // 1 = 1 + 1
            // 11 = 11 + 1
            // 111 = 1 + ""
            // "" = 1 + ""


        }
        return reverse;





    }
    public static String reverseStr(String example) {
        // 맨뒤의 글자를 자르기
        String word = "";
        for (int i = example.length()-1; i >= 0; i--) {
            // 잘라서 새로운 문자열에 넣기
            word += example.substring(i, i+1);
        }
        // reVerse.length() // 7글자
        return word;

    }

    public static void makeTree(int n){
        for(int i = 0; i < n ; i++){
            // n 번 반복
            String blank ="";
            for(int k = 0; k < n - i; k++){
                // 빈칸먼저 그리기
                // 4
                // 3
                // 2
                // 1
                blank += " ";
            }

            // 별찍
            String stars = "";
            for(int k = 0; k < (i*2)+1; k++){
                stars += "*";
            }
            System.out.println(blank + stars);
        }

    }
}
