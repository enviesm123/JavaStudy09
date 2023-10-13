package taegon.submit09.q01;

import java.util.ArrayList;
import java.util.Collections;

public class ProductMain {
    public static void main(String[] args) {
//        Q. 01

//        하이마트에 놀러갔더니 전자제품들이 정말 많이 있군요. 전자제품들은 각각 제품명과 가격이 함께 전시되어있습니다. 이를 코드로 구현하기 위해, 필드 변수에 제품명과 가격을 포함하는 전자제품 클래스(Product)를 만들어보세요.

//                Product 클래스를 이용하여
//        제품명: 냉장고, 가격: 2000000
//        제품명: TV, 가격: 1000000
//        제품명: 에어컨, 가격: 800000
//        제품명: 컴퓨터, 가격: 1300000
//        제품명: 선풍기, 가격: 100000
//        객체들을 만들어주세요.
        Product iceBox = new Product("냉장고", 2000000);
        Product tv = new Product("TV", 1000000);
        Product airCon = new Product("에어컨", 800000);
        Product com = new Product("컴퓨터", 1300000);
        Product fan = new Product("선풍기", 100000);

//        전자제품들을 ArrayList 객체에 담은 후 가격별로 정렬하여 출력해주세요.
        ArrayList<Product> elect = new ArrayList<>();
        elect.add(iceBox);
        elect.add(tv);
        elect.add(airCon);
        elect.add(com);
        elect.add(fan);

        for(int k = 0; k < elect.size() - 1; k++){
            for(int i = 0; i < elect.size() - 1; i++){
               if(elect.get(i).getPrice() > elect.get(i+1).getPrice()){
                  Product temp = elect.get(i);
                   elect.set(i, elect.get(i+1));
                   elect.set((i+1), temp);
               }
            }
        }
        for(int i = 0; i < elect.size(); i++) {
            System.out.println(elect.get(i));
        }

        for(int i = 0; i < elect.size(); i++){
            System.out.println(elect.get(i));
            if("TV".equals(elect.get(i))){
                System.out.println(("TV".equals(elect.get(i))));
            }
        }

    }
}
