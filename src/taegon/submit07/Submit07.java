package taegon.submit07;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Submit07 {
    public static void main(String[] args) {

//        Q. 01
//       1. 정수를 담을 수 있는 ArrayList 객체를 생성하고, 10부터 20 사이의 랜덤 숫자를 10개 담으시오. (10도 나오고 20도 나올 수 있어야 함)
        ArrayList<Integer> num = new ArrayList<>();
        int randInt = 0;
//
//        10번 반복하는 for문에서 매번 10부터 20 사이의 랜덤 숫자를 얻어서(randInt) 해당
//        ArrayList 객체에 add
        for(int i = 0 ; i < 10; i++){
            randInt = (int)(Math.random() * 11) + 10;
            num.add(randInt);
        }
        System.out.println(num);


//       2. 해당 정수형 리스트에서 중복된 숫자들을 제거한 후 출력하시오.
//        새로운 빈 리스트 만드시고, 거기에 중복되지 않게끔 값들을 옮기세요.
        ArrayList<Integer> newNum = new ArrayList<>();
        for(int i = 0; i < num.size(); i++){
            // 랜덤 번호와 for문 요소 들을 비교한후 똑같으면
            if(!newNum.contains(num.get(i))){
                newNum.add(num.get(i));
                // 담지 않는다

            }
        }
        System.out.println(newNum);







//       3. 중복을 제거한 정수형 리스트를 오름차순으로 정렬하여 출력하시오.

        Collections.sort(newNum);
        System.out.println(newNum);
//       4. 중복을 제거한 정수형 리스트를 내림차순으로 정렬하여 출력하시오.


        System.out.println("\n========================\n");


//        Q. 02
//        아내가 사고 싶은 물건  ["냉장고", "로봇청소기", "세탁기", "에어컨"] 을 리스트에 담아주세요.

        ArrayList<String> wifeList = new ArrayList<>();
        wifeList.add("냉장고");
        wifeList.add("로봇청소기");
        wifeList.add("세탁기");
        wifeList.add("에어컨");


//      남편이 사고 싶은 물건 ["노트북", "TV", "에어컨", "플레이스테이션", "로봇청소기"] 을 다른 리스트에 담아주세요.
        ArrayList<String> husList = new ArrayList<>();
        husList.add("노트북");
        husList.add("TV");
        husList.add("에어컨");
        husList.add("플레이스테이션");
        husList.add("로봇청소기");

//        1. 서로 사고 싶은 물건 목록을 새로운 리스트에 담아 콘솔에 출력해주세요(교집합)
//                Hint
//        빈 리스트를 하나 만들고, 아내의 구매목록 리스트를 for문을 이용하여 순회하고,
        ArrayList<String> wishList = new ArrayList<>();
        for(int i = 0; i < wifeList.size(); i++){
//                각 구매 물품이 남편의 구매목록 리스트에 존재하는지 체크한다.
            if(husList.contains(wifeList.get(i))) {
                // 포함하고 있냐??
//                만약 존재한다면 빈 리스트에 해당 물품을 저장한다.
                wishList.add(wifeList.get(i));
            }
        }
        System.out.println(wishList);



        //        2. 사고 싶은걸 다 산다고 했을때의 구매 목록을 새로운 리스트에 담아 콘솔에 출력해주세요(합집합)
//        빈 리스트를 하나 만들고, 아내의 구매목록을 전부 담는다.
        wishList = new ArrayList<>();
        wishList = wifeList;
//                이후 남편의 구매목록 리스트를 for문을 이용하여 순회하고,
        for(int i = 0; i < husList.size(); i++){
//        남편의 구매 물품이 빈 리스트에 존재하지 않는다면 빈 리스트에 해당 물품을 추가한다.
            if(wishList.contains(husList.get(i))){
            }else{
                wishList.add(husList.get(i));
            }

        }
        System.out.println(wishList);



















    }
}
