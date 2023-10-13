package taegon.submit09.q02;

import java.util.ArrayList;

public class Fish {
    String name;
    int price;

    @Override
    public String toString() {
        return
                name +
                ", 가치: " + price;
    }

    public Fish() {
    }

    public Fish(String name, int price) {
        this.name = name;
        this.price = price;
    }

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

    public ArrayList<Fish> fishing(){
        ArrayList<Fish> fish = new ArrayList<>();
        boolean isRun = true;


        while(isRun){
            int randInt = (int) (Math.random() * 6) + 1;
            if (randInt == 1) {
                fish.add(new Fish("고등어", 5000));
                System.out.println("고등어를 잡았다!!");
            } else if (randInt == 2) {
                fish.add(new Fish("광어", 25000));
                System.out.println("광어를 잡았다!!");
            } else if (randInt == 3) {
                fish.add(new Fish("우럭", 27000));
                System.out.println("우럭을 잡았다!!");
            } else if (randInt == 4) {
                fish.add(new Fish("참돔", 30000));
                System.out.println("참돔을 잡았다!!");
            } else if (randInt == 5) {
                fish.add(new Fish("돌돔", 35000));
                System.out.println("돌돔을 잡았다!!");
            } else if (randInt == 6) {
                fish.add(new Fish("능성어", 70000));
                System.out.println("능성어를 잡았다!!");
            } else if (randInt == 7) {
                fish.add(new Fish("다금바리", 120000));
                System.out.println("다금바를 잡았다!!");
            }
            isRun = false;
        }

            return fish;

    }
}
