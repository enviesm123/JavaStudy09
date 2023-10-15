package taegon.submit09.q02;
import java.util.ArrayList;
import java.util.Scanner;

public class FishMain {
    public static void main(String[] args) {

//      Q. 02
//물반 고기반 낚시대를 던지면 물고기가 잡히는 낚시 게임을 만들어봅시다.
//      물고기는 이름과 가격 속성을 가집니다.
//아래의 코드와 실행 예시를 참고하여, 물고기 객체에 대한 Fish 클래스를 생성해주세요.
//      FishMain 클래스도 함께 만들어 아래의 코드를 옮겨적고 while문 내부를 완성시켜주세요.
//
//바다속 물고기 목록
		ArrayList<Fish> fishList = new ArrayList<>();
		Fish oneFishing = new Fish(); // 이걸 못해서 몇시간 멍때렸다 메서드 불러오기 선언을 해서 불러와야된다 스캐너처럼 ㅠㅠ

		fishList.add(new Fish("고등어", 5000));
		fishList.add(new Fish("광어", 25000));
		fishList.add(new Fish("우럭", 27000));
		fishList.add(new Fish("참돔", 30000));
		fishList.add(new Fish("돌돔", 35000));
		fishList.add(new Fish("능성어", 70000));
		fishList.add(new Fish("다금바리", 120000));

		Scanner scan = new Scanner(System.in);

//잡은 물고기를 담을 가방
		ArrayList<Fish> fishBag = new ArrayList<>();

		while (true) {
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 낚시하기 | 2. 잡은 물고기 목록 | 3. 떠나기");
			System.out.print(">>> ");

			int select = Integer.parseInt(scan.nextLine());
			int sum = 0;
			// 낚시하기를 누르면 1번 낚시(0~7까지 랜덤으로 나온숫자에 해당하는 물고기)한 물고기 출력까지
			if (select == 1) {
				// 낚시한 물고기 리스트를 새로운 ArrayList에 담는다
				fishList = oneFishing.fishing();
				// 낚시해서 저장해놓은 모든 물고기 요소를 fishBag에 추가한다
				for (int i = 0; i < fishList.size(); i++) {
					fishBag.add(fishList.get(i));
				}

				// TODO 낚시하기
			} else if (select == 2) {
				// TODO 잡은 물고기 목록 보기
				// fishBag에 담아놓은 모든 물고기를 출력한다
				System.out.println("내 가방 ==================");
				for (int i = 0; i < fishBag.size(); i++) {

					System.out.println(fishBag.get(i));
					// fishBag에 잡힌 물고기 값을 다 합친다
					sum += (fishBag.get(i).getPrice());
				}
				System.out.println("총 " + sum + "원 " + "=================");
			} else if (select == 3) {
				// TODO 종료
				System.out.println("가지마세요ㅠㅠ");
				break;
			}

		}

        ArrayList<Fish> fishList1 = new ArrayList<>();
        Fish oneFishing1 = new Fish(); // 이걸 못해서 몇시간 멍때렸다 메서드 불러오기 선언을 해서 불러와야된다 스캐너처럼 ㅠㅠ


        fishList1.add(new Fish("고등어", 5000));
        fishList1.add(new Fish("광어", 25000));
        fishList1.add(new Fish("우럭", 27000));
        fishList1.add(new Fish("참돔", 30000));
        fishList1.add(new Fish("돌돔", 35000));
        fishList1.add(new Fish("능성어", 70000));
        fishList1.add(new Fish("다금바리", 120000));



//잡은 물고기를 담을 가방
        ArrayList<Fish> fishBag1 = new ArrayList<>();

        while (true) {
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 낚시하기 | 2. 잡은 물고기 목록 | 3. 떠나기");
            System.out.print(">>> ");

            int select = Integer.parseInt(scan.nextLine());
            int sum = 0;
            // 낚시하기를 누르면 1번 낚시(0~7까지 랜덤으로 나온숫자에 해당하는 물고기)한 물고기 출력까지
            if (select == 1) {
                // 낚시한 물고기 리스트를 새로운 ArrayList에 담는다
                fishList1 = oneFishing1.fishing2();
                // 낚시해서 저장해놓은 모든 물고기 요소를 fishBag에 추가한다
                for (int i = 0; i < fishList1.size(); i++) {
                    fishBag1.add(fishList1.get(i));
                }

                // TODO 낚시하기
            } else if (select == 2) {
                // TODO 잡은 물고기 목록 보기
                // fishBag에 담아놓은 모든 물고기를 출력한다
                System.out.println("내 가방 ==================");
                for (int i = 0; i < fishBag1.size(); i++) {

                    System.out.println(fishBag1.get(i));
                    // fishBag에 잡힌 물고기 값을 다 합친다
                    sum += (fishBag1.get(i).getPrice());
                }
                System.out.println("총 " + sum + "원 " + "=================");
            } else if (select == 3) {
                // TODO 종료
                System.out.println("가지마세요ㅠㅠ");
                break;
            }

        }
    }

}
