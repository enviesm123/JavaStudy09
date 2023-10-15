package taegon.submit09.q02;

import java.util.ArrayList;
import java.util.HashMap;

public class Fish {
    String name;
    int price;
    // toString 오버라이드 필수 그래야 출력된다
    @Override
    public String toString() {
        return
                name +
                        ", 가격: " + price;
    }

    // 빈생성자 생성 그래야 빈 클래스를 만들수잇음
    public Fish() {

    }
    // 생성할때 fish(String name(스트링타입의 변수명 name, int 타입의 변수명 price)로 쓰면 바로 추가가 가능
    // fish.add(new Fish("장어", 100000));
    public Fish(String name, int price) {
        this.name = name;
        this.price = price;
    }
    // getting setting 세트 모르면 걍 추가하셈 불러오고 변경할수있게 해준다
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // 1번 낚시를 하게 해주는 메서드
    public ArrayList<Fish> fishing() {
        ArrayList<Fish> oneFishing = new ArrayList<>();
        // 경우의 수가 0부터 6까지 0 1 2 3 4 5 6 7가지
        int randInt = (int) (Math.random() * 7);
        // 랜덤 주사위를 굴려서 0이 나오면 고등어가 잡힘
        // 랜덤 주사위를 굴려서 1이 나오면 광어가 잡힘
        // 랜덤 주사위를 굴려서 2이 나오면 우럭이 잡힘
        // 랜덤 주사위를 굴려서 3이 나오면 참돔이 잡힘
        // 단 한번만 낚시 하므로 7개 중에 하나만 oneFishing에 추가된다
        if (randInt == 0) {
            oneFishing.add(new Fish("고등어", 5000));
            System.out.println("고등어를 잡았다!!");
        } else if (randInt == 1) {
            oneFishing.add(new Fish("광어", 25000));
            System.out.println("광어를 잡았다!!");
        } else if (randInt == 2) {
            oneFishing.add(new Fish("우럭", 27000));
            System.out.println("우럭을 잡았다!!");
        } else if (randInt == 3) {
            oneFishing.add(new Fish("참돔", 30000));
            System.out.println("참돔을 잡았다!!");
        } else if (randInt == 4) {
            oneFishing.add(new Fish("돌돔", 35000));
            System.out.println("돌돔을 잡았다!!");
        } else if (randInt == 5) {
            oneFishing.add(new Fish("능성어", 70000));
            System.out.println("능성어를 잡았다!!");
        } else if (randInt == 6) {
            oneFishing.add(new Fish("다금바리", 120000));
            System.out.println("다금바리를 잡았다!!");
        }

        return oneFishing;
    }

    // 1번 낚시를 하게 해주는 메서드
    public ArrayList<Fish> fishing2() {
        ArrayList<Fish> oneFishing = new ArrayList<>();
        // 경우의 수가 0부터 6까지 0 1 2 3 4 5 6 7가지
        int randInt = (int) (Math.random() * 3);
        // 랜덤 주사위를 굴려서 0이 나오면 고등어가 잡힘
        // 랜덤 주사위를 굴려서 1이 나오면 광어가 잡힘
        // 랜덤 주사위를 굴려서 2이 나오면 우럭이 잡힘
        // 랜덤 주사위를 굴려서 3이 나오면 참돔이 잡힘
        // 단 한번만 낚시 하므로 7개 중에 하나만 oneFishing에 추가된다

        String[] fishs = {"고등어","광어","우럭","참돔","돌돔","능성어","다금바리"};
        HashMap<String, Integer> fishPrice = new HashMap();
        fishPrice.put("고등어", 5000);
        fishPrice.put("광어", 25000);
        fishPrice.put("우럭", 27000);
        fishPrice.put("참돔", 30000);
        fishPrice.put("돌돔", 35000);
        fishPrice.put("능성어", 70000);
        fishPrice.put("다금바리", 120000);
        String fishName = fishs[randInt];
        int fp =(int) fishPrice.get(fishs[randInt]);

        oneFishing.add(new Fish(fishName,fp));
        System.out.println(fishName +"를 잡았다!");

        return oneFishing;
    }
}
