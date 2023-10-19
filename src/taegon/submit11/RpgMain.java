package taegon.submit11;

import java.util.ArrayList;
import java.util.Scanner;

public class RpgMain {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Character character = Character.getInstance();
        ArrayList<State> user = new ArrayList<>();
        ArrayList<Item> inventory = new ArrayList<>();
        inventory.add(new Item("단검", 500, Item.getGrade()));

        System.out.println("RPG에 오신걸 환영합니다!!");


            System.out.println("================");
            System.out.println("캐릭터를 생성해 주세요");
            System.out.print("이름 >>> ");

            String name = scan.nextLine();

            System.out.println("직업 >>> 1. 전사 | 2. 궁수 | 3. 마법사 ");
            System.out.print(">>> ");

            String job = scan.nextLine();

            user.add(new State(name, job));
            System.out.println(name + "님 가입을 환영합니다!!");

            for(int i = 0; i < user.size(); i++){
                System.out.println(user.get(i));
        while(true) {
            System.out.println("이동하기");
            System.out.println("1. 마을 | 2. 종료");
            System.out.print(">>> ");

            int command = Integer.parseInt(scan.next());

            if (command == 1) {
                // 마을  휴식,상점
                System.out.println("==마을==");
                System.out.println("1. 휴식 | 2. 상점 | 3. 떠나기");

                int command2 = Integer.parseInt(scan.next());

                if (command2 == 1) {
                    // 휴식
                    for(State stat : user){
                        stat.setHp(100);
                        System.out.println("체력이 모두 회복되었습니다");
                        System.out.println("HP: " + stat.getHp());
                    }
                } else if (command2 == 2) {
                    // 상점 목록보여주고 1.팔기 2.떠나기
                    System.out.println("==상점==");
                    System.out.println("1. 팔기 | 2.떠나기");
                    System.out.print(">>> ");

                    int commandShop = Integer.parseInt(scan.next());

                    if(commandShop == 1){
                        // 아이템 팔기
                        for(int k = 0 ; k < inventory.size(); k++){

                            System.out.println("내인벤토리 목록");
                            System.out.println("[" + (i+1) + "] " + inventory.get(i));
                        }
                        System.out.print(">>> ");

                        int itemList = Integer.parseInt(scan.nextLine());

                        for(int j = 0; j < inventory.size();j++){
                            if(itemList == inventory.get(i).getNum()){



                            }

                        }
                    }


                } else {
                    continue;
                }

            } else if (command == 2) {

                System.out.println("다음에 또봐요");
                break;
            }

        }

        }




    }
}
