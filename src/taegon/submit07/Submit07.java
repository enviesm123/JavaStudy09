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
        System.out.println("\n=======10~20까지 랜덤숫자 10개=========\n");
        System.out.println(num);


//       2. 해당 정수형 리스트에서 중복된 숫자들을 제거한 후 출력하시오.
//        새로운 빈 리스트 만드시고,
        ArrayList<Integer> newNum = new ArrayList<>();
        // intList를 순회하는 for문
        for(int i = 0; i < num.size(); i++){
//        거기에 중복되지 않게끔
        // 값을 옮길 때 newNum 안에 num.get(i)의 값이 존재하는지 ㅔ크
        // 존재 하지 않을때만 옮긴다.
            if(newNum.contains(num.get(i)) == false){
//        값들을 옮기세요.
                newNum.add(num.get(i));

            }
        }
        System.out.println("\n=======중복된숫자 제거=========\n");
        System.out.println(newNum);

        // 새로운 리스트 생성 없이 remove로 중복 제거
        for(int i = 0; i < num.size(); i++){
            // i가 0일때 num.get(0) 과 index 9,8,7,6,5,4,3,2,1와 비교
            // i가 1일때 num.get(0) 과 index 9,8,7,6,5,4,3,2와 비교
            // i가 2일때 num.get(0) 과 index 9,8,7,6,5,4,3와 비교
            for(int k = num.size() - 1; k > i; k--){
                if(num.get(i) == num.get(k)){
                    num.remove(k);
                }
            }
        }

        System.out.println("\n=======.remove를 이용한 중복된 숫자를 제거=========\n");
        System.out.println(num);






//       3. 중복을 제거한 정수형 리스트를 오름차순으로 정렬하여 출력하시오.

        System.out.println("\n=======오름차순=========\n");
        Collections.sort(newNum);
        System.out.println(newNum);
//       4. 중복을 제거한 정수형 리스트를 내림차순으로 정렬하여 출력하시오.
        System.out.println("\n=======내림차순=========\n");
        Collections.sort(newNum, Collections.reverseOrder());
        System.out.println(newNum);


        System.out.println("\n========================\n");


//        Q. 02
//        아내가 사고 싶은 물건  ["냉장고", "로봇청소기", "세탁기", "에어컨", "식기세척기"] 을 리스트에 담아주세요.
        ArrayList<String> wifeList = new ArrayList<>();
        wifeList.add("냉장고");
        wifeList.add("로봇청소기");
        wifeList.add("세탁기");
        wifeList.add("에어컨");
        wifeList.add("식기세척기");

//      남편이 사고 싶은 물건 ["노트북", "TV", "에어컨", "플레이스테이션", "로봇청소기"] 을 다른 리스트에 담아주세요.
        ArrayList<String> husList = new ArrayList<>();
        husList.add("노트북");
        husList.add("TV");
        husList.add("에어컨");
        husList.add("플레이스테이션");
        husList.add("로봇청소기");

//        1. 서로 사고 싶은 물건 목록을 새로운 리스트에 담아 콘솔에 출력해주세요(교집합)
//        빈 리스트를 하나 만들고, 아내의 구매목록 리스트를 for문을 이용하여 순회하고,
        ArrayList<String> wishList = new ArrayList<>();
        for(int i = 0; i < wifeList.size(); i++){
//                각 구매 물품이 남편의 구매목록 리스트에 존재하는지 체크한다.
            // for문으로 husList를 순회해서
            // wifeList.get(i)와 같은게 존재하는지 비교
            for(int k = 0; k < husList.size(); k++){
                if(wifeList.get(i).equals(husList.get(k))){
                    wishList.add(wifeList.get(i));
                }
            }
        }
        System.out.println(wishList);
        for(int i = 0; i < wifeList.size(); i++){
//                각 구매 물품이 남편의 구매목록 리스트에 존재하는지 체크한다.

            if(husList.contains(wifeList.get(i))) {
                // 포함하고 있냐??
//                만약 존재한다면 빈 리스트에 해당 물품을 저장한다.
                wishList.add(wifeList.get(i));
            }
        }


        //        2. 사고 싶은걸 다 산다고 했을때의 구매 목록을 새로운 리스트에 담아 콘솔에 출력해주세요(합집합)
//        빈 리스트를 하나 만들고, 아내의 구매목록을 전부 담는다.
        wishList = new ArrayList<>();
        wishList.addAll(wifeList);  // wishList = wifeList;
//
//                이후 남편의 구매목록 리스트를 for문을 이용하여 순회하고,
        // ["냉장고", "로봇청소기", "세탁기", "에어컨", "식기세척기"]
        // ["노트북", "TV", "에어컨", "플레이스테이션", "로봇청소기"]
        for(int i = 0; i < husList.size(); i++){
//        남편의 구매 물품이 빈 리스트에 존재하지 않는다면 빈 리스트에 해당 물품을 추가한다.
//            husList.get(i) 의 값이 wantAll 안에 없어야 추가
            boolean isContain = false;
            for(int k = 0; k < wishList.size(); k++){
                if(wishList.get(k).equals(husList.get(i)) == true){
                    isContain = true;
                }
            }

            // isContain 값이 false 일때 husList.get(i)를 wishList에 추가
            if(isContain == false){
                wishList.add(husList.get(i));
            }
        }
        System.out.println(wishList);



















    }
}
