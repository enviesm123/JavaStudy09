package taegon.submit11;

import java.util.ArrayList;
import java.util.Scanner;

public class Weapon {
    private String name;
    private int damage;
    private int price;
    private static int wpLevel;




    public Weapon(String name, int damage, int price) {
        this.name = name;
        this.damage = randDg();
        this.price = randPc();
        this.wpLevel = 0;

    }
    public Weapon(String name) {
        this.name = name;
        this.damage = randDg();
        this.price = randPc();
        this.wpLevel = 0;

    }

    public Weapon() {

    }

    public String getName() {
        return name;
    }



    public int getDamage() {
        return damage;
    }

    public int getPrice() {
        return price;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public static int getWplevel() {
        return wpLevel;
    }

    public void lvUp() {
        wpLevel++;
    }

    public int getSellPrice() {
        // 판매 가격을 강화 레벨에 따라 조정
        return price + wpLevel * 1500; // 강화 1당 1000원
    }


    public int randDg() {
        int randomValue = (int) (Math.random() * 100) + 1;
        if (randomValue <= 1) {
            return 30;
        } else if (randomValue <= 4) {
            return 20;
        } else if (randomValue <= 14) {
            return 15;
        } else if (randomValue <= 29) {
            return 10;
        } else if (randomValue <= 49) {
            return 5;
        } else {
            return 1;
        }
    }

    public int randPc() {
        int randomValue = (int) (Math.random() * 100) + 1;
        if (randomValue <= 1) {
            return 500;
        } else if (randomValue <= 4) {
            return 1000;
        } else if (randomValue <= 14) {
            return 2500;
        } else if (randomValue <= 29) {
            return 4000;
        } else if (randomValue <= 49) {
            return 5500;
        } else {
            return 8000;
        }
    }
    public static void invenList(Character character) {
        Scanner scan = new Scanner(System.in);

        System.out.println("================");
        System.out.println("인벤토리를 확인합니다.");

        ArrayList<Weapon> inventory = character.getInventory();

        if (inventory.isEmpty()) {
            System.out.println("인벤토리가 비어 있습니다.");
            System.out.println("현재 골드\uD83D\uDCB0 : " + character.getGold());

        } else {
            System.out.println("인벤토리에 있는 무기 목록:");

            for (int i = 0; i < inventory.size(); i++) {
                Weapon weapon = inventory.get(i);
                System.out.println(i + 1 + ". " + weapon.getName() + " (공격력: " +
                        weapon.getDamage() + ", 강화 레벨: " + weapon.getWplevel() + ")");
                System.out.println("현재 골드\uD83D\uDCB0 : " + character.getGold());
            }

            System.out.println("2. 돌아가기");
            System.out.print("선택 >>> ");
            int choice = scan.nextInt();

            while(true){

            if(choice == 1) {
                System.out.println("인벤토리를 나갑니다.");
                break;
            }else if(choice ==2){

                System.out.println("다시 선택 해세요.");
                break;
            }
            }
        }
    }
}
