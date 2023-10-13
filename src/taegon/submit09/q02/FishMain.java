package taegon.submit09.q02;

import java.util.ArrayList;
import java.util.Scanner;

public class FishMain {
    public static void main(String[] args) {

//                Q. 02
//        물반 고기반 낚시대를 던지면 물고기가 잡히는 낚시 게임을 만들어봅시다.
//                물고기는 이름과 가격 속성을 가집니다.
//        아래의 코드와 실행 예시를 참고하여, 물고기 객체에 대한 Fish 클래스를 생성해주세요.
//                FishMain 클래스도 함께 만들어 아래의 코드를 옮겨적고 while문 내부를 완성시켜주세요.
//
//         바다속 물고기 목록
        ArrayList<Fish> fishList = new ArrayList<>();

        fishList.add(new Fish("고등어", 5000));
        fishList.add(new Fish("광어", 25000));
        fishList.add(new Fish("우럭", 27000));
        fishList.add(new Fish("참돔", 30000));
        fishList.add(new Fish("돌돔", 35000));
        fishList.add(new Fish("능성어", 70000));
        fishList.add(new Fish("다금바리", 120000));

        Scanner scan = new Scanner(System.in);

// 잡은 물고기를 담을 가방
        ArrayList<Fish> fishBag = new ArrayList<>();

        while(true) {
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 낚시하기 | 2. 잡은 물고기 목록 | 3. 떠나기");
            System.out.print(">>> ");
            

            int select = Integer.parseInt(scan.nextLine());

            if(select == 1) {
                fishing();
                // TODO 낚시하기
            }else if(select == 2) {
                // TODO 잡은 물고기 목록 보기
            }else if(select == 3) {
                // TODO 종료
                break;
            }
            System.out.println();
        }

    }
}
