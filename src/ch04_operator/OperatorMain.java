package ch04_operator;

public class OperatorMain {

    public static void main(String[] args) {

        // 산술 연산자(Operator)
        int numA = 10;
        int numB = 3;

        // numA 에 1 더하기
        numA = numA + 1;
        System.out.println(numA);

        // numA 에 20 더하기
        numA = numA + 20;
        System.out.println(numA);

        // numA 에 21 빼기
        numA = numA - 21;
        System.out.println(numA);

        //연산 우선순위가 있다 괄호를 이용하면 신경안써도된다(!!!)
        //우선순위 때문에 "더하기" + numA가 먼저진행[문자열+숫자] "더하기 10"
        System.out.println("더하기 " + numA + numB);
        System.out.println("더하기 " + (numA + numB));
        System.out.println("빼기 " + (numA - numB));
        System.out.println("곱하기 " + (numA * numB));
        System.out.println("나누기 " + (numA / numB));
        System.out.println("나머지 " + (numA % numB));

        System.out.println("\n============증감연산자===============\n");

        // 증감 연산자
        numA++; // 1 증가
        System.out.println(numA);

        numA--; // 1 감소
        System.out.println(numA);

        ++numA; // 1 증가
        System.out.println(numA); // 11

        System.out.println(numA++); // 11 numA 프린트가 실행후 ++ 실행
        System.out.println(numA); // 12

        // ++의 위치에 따라 실행 순서가 달라진다.
        System.out.println(++numA); // 13 1이 더해진 후에 numA 프린트

        System.out.println("\n=========대입연산자================\n");

        // 대입 연산자
        numA = numA + 20; // 산술
        numA++; // 증감
        numA += 20; // 대입 numA+=20 = (numA = numA + 20)

        System.out.println(numA);

        numA -= 30;

        numA *=3;
        System.out.println(numA);

        // 72 / 5 = 14
        numA /= 5;
        System.out.println(numA);

        // 14(numA) % 5 = 4
        numA %= 5;
        System.out.println(numA);

        System.out.println("\n=============문자열 더하기===========\n");

        //문자열 더하기
        String subway = "반석역";

        subway = subway + " 지족역";
        System.out.println(subway);

        //대입 연산자 사용 가능 (뒤에만 추가 된다)
        subway += " 노은역";
        System.out.println(subway);

        subway = "대전지하철 " + subway + " 월드컵경기장역";
        System.out.println(subway);

        System.out.println("\n==========형변환========\n");

        // 형(Tybe) 변환 - Casting
        // 형변환이 가능한 경우에 대해 형변환을 통해 상황에 맞게 적절히 사용할 수 있다.
        int intNum = 15;
        double doubNum = 1.23;

        System.out.println(intNum * doubNum); // 18.45

        // int 곱하기, 나누기 double은 double 타입이 된다. (자동 형변환)
        double mulResult = intNum * doubNum;

        // int 곱하기, 나누기  float은 float 타입이 된다. (자동 형변환)
        float floatMul = intNum * 2.34f;
        System.out.println(floatMul);

        // 정수와 소수를 곱하거나 나누면 결과는 소수가 나온다.

        // 같은 정수타입, 같은 소수타입의 경우 메모리 크기만 허용된다면
        // 형 변환이 가능하다.
        long longNum = 4564;
//        int castLong = 4564L; // 메모리 크기가 더 큰 long 에서 int 로는 자동 형변환 X
        int castLong = (int)45640000000L; // (타입)값을 이용하여 강제 형변환이 가능하다.
        System.out.println(castLong); // 크기가 넘어가는 경우 제대로 된 값이 담기지 않는다.

        // 숫자와 문자열을 더하면
        // 숫자가 문자열로 자동형변환이 되어 문자열 이어붙이기가 된다.
        String month = "이번달 " + 9;

        // 강제 형변환
        int intCast = (int)3.376;
        System.out.println(intCast); // 정수인 3만 담긴다.

        // 10 * 3.333 = 33.33
        // 정수인 33만 intMul 에 담기
        int intMul = (int)(10 * 3.333);
        System.out.println(intMul); // 33

        // 가장 많이 하는 실수
        System.out.println(10/3);
        // 10 / 3  -> 3.33333
        // 연산 값이 소수 일지라도, 정수 타입이 유지되므로 정수만 출력

//        double result = 10 / 3;
//        System.out.println(result); // 3.3333 로 출력되도록 형변환을 적용해보기

        double result = (double)10 / 3;
        System.out.println(result);

        // 프로그래밍에서 소수 연산에 정확도는 떨어진다.
        // 하지만 대부분 소수 둘째, 셋째 자리까지만 사용을 하기 때문에 상관하지 않아도 된다.
        // 정확한 소수 연산이 꼭 필요하다면 다른 사람들이 만들어 놓은 라이브러리를 가져다 쓰면된다.

        // 숫자형 문자열을 정수로 형변환
        String strNum = "123";
        System.out.println(strNum + 2);

        int num = Integer.parseInt(strNum);
        System.out.println(num + 2);

        // 소수형 문자열을 소수 타입으로 형변환
        strNum = "23.45";
        double dnum = Double.parseDouble(strNum);
        System.out.println(dnum + 1.23);

        System.out.println("\n==================\n");


    }
}
