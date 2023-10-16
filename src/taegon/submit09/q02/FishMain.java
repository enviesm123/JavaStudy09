package taegon.submit09.q02;


import ch09_class.common.UtilClass;

import java.util.ArrayList;
import java.util.Scanner;

public class FishMain {
    public static void main(String[] args) {
        // 바다속 물고기 목록
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

        // 낚시대의 상태
        boolean isBroken = false;

        // 미끼의 개수
        int count = 10;  // 낚시를 할때마다 미끼가 1개씩 줄고, 미끼가 0개면 낚시 불가능

        while(true) {
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 낚시하기 | 2. 잡은 물고기 목록 | 3. 떠나기");
            System.out.print(">>> ");

            int select = Integer.parseInt(scan.nextLine());

            if(select == 1) {

                if(isBroken){
                    System.out.println("낚시대가 부러져 더이상 낚시를 할 수 없습니다..");
                    continue;
                }

                if(count == 0){
                    System.out.println("미끼가 부족해서 더이상 낚시를 할 수 없습니다..");
                    continue;
                }

                // TODO 낚시하기
                // 랜덤한 물고기를 낚아서 fishBag에 담기
                // fishList에서 랜덤한 인덱스에 있는 Fish 객체를 꺼내기
                // fishList 는 인덱스가 0~6, 0~6 사이의 랜덤 숫자를 획득

                // 낚시하기 선택시
                // 다금바리(6) 5% 확률
                // 능성어(5) 10% 확률
                // 돌돔(4) 12% 확률
                // 참돔(3) 13% 확률
                // 우럭(2) 15% 확률
                // 광어(1) 15% 확률
                // 고등어(0) 30% 확률 로 잡히도록 코드 수정
                int idx = 0;

                // 1~100 랜덤 정수 생성 (= 물고기 낚을 확률)
                int rand = (int)(Math.random() * 100) + 1;

                // rand -> 1~10 -> 10%
                if(rand <= 5){  // 5% 확률
                    // 다금바리
                    idx = 6;
                }else if(rand <= 15){ // 10% 확률
                    idx = 5;
                }else if(rand <= 27){ // 12% 확률
                    idx = 4;
                }else if(rand <= 40){ // 13% 확률
                    idx = 3;
                }else if(rand <= 55){ // 15% 확률
                    idx = 2;
                }else if(rand <= 70){ // 15% 확률
                    idx = 1;
                }

                // 5% 확률로 낚시대가 뿌셔질 수 있음
                // 낚시대가 뿌셔지면 더이상 낚시하기 불가능 (1번 불가 / 2,3번 가능)
                // 1~100 랜덤 숫자 생성 후 5이하인지 확인
                int randNum = UtilClass.makeRandom(1, 100);
                if(randNum <= 5){
                    // 낚시대가 부러짐
                    System.out.println("낚시대가 부러져따 ㅜㅠ");
                    // 낚시대가 부러진 상태를 저장
                    isBroken = true;
                    continue;
                }

                System.out.println(fishList.get(idx).getName() + "을 잡았다~!!");
                fishBag.add(fishList.get(idx));

                count--;
                System.out.println("남은 미끼: " + count);

            }else if(select == 2) {
                // TODO 잡은 물고기 목록 보기
                System.out.println("내 가방 ====================");
                int total = 0;
                for(int i = 0; i < fishBag.size(); i++){
                    System.out.println(fishBag.get(i));
                    total += fishBag.get(i).getPrice();
                }
                System.out.println("총 " + total + "원 =====================");

            }else if(select == 3) {
                // TODO 종료
                break;
            }
            System.out.println();
        }

}
}


