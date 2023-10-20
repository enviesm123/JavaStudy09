package taegon.submit11;

import java.util.ArrayList;
import java.util.Scanner;

public class Character {

    private String name;
    private int gold;
    private ArrayList<Weapon> inventory; // 내 인벤토리

    // 생성자
    private Character() {
        this.gold = 10000; // 시작 골드
        this.inventory = new ArrayList<>(); // 인벤토리를 초기화 한다
    }



    public static Character getInstance() {
        return new Character();
    }

    // Getter 및 Setter 메서드

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public ArrayList<Weapon> getInventory() {
        return inventory;
    }

    public static void forge(Character character) {
        Scanner scan = new Scanner(System.in);

        System.out.println("================");
        System.out.println("대장간에 오신 것을 환영합니다!");
        System.out.println("1. 무기 구매");
        System.out.println("2. 무기 판매");
        System.out.println("3. 무기 강화");
        System.out.println("4. 돌아가기");
        System.out.print("선택 >>> ");
        int choice = scan.nextInt();


        boolean isBye = true;
        while (isBye) {

            if (choice == 1) {
                // 무기 구매
                buyWp(character);
                break;

            } else if (choice == 2) {
                // 무기 판매
                sellWp(character);
                break;
            } else if (choice == 3) {
                // 무기 강화
                upWp(character);
                break;
            } else if (choice == 4) {
                // 돌아가기
                System.out.println("대장간에서 빠져나갑니다.");
                isBye = false;
                break;



            } else {
                System.out.println("잘못 누르셨습니다.");
                break;
            }
        }
    }
    public static void buyWp(Character character) {

        Scanner scan = new Scanner(System.in);

        // 5가지 무기 목록
        Weapon[] weapons = new Weapon[5];
        weapons[0] = new Weapon("검");
        weapons[1] = new Weapon("활");
        weapons[2] = new Weapon("망치");
        weapons[3] = new Weapon("단검");
        weapons[4] = new Weapon("창");

        System.out.println("무기 목록:");
        for (int i = 0; i < weapons.length; i++) {
            System.out.println(i + 1 + ". " + weapons[i].getName() + " (공격력: " +
                    weapons[i].getDamage() + ", 가격: " + weapons[i].getPrice() + " 골드)");
        }
        System.out.println("현재 골드\uD83D\uDCB0 : " + character.getGold());

        System.out.print("구매할 무기 선택 0(취소) >>> ");
        int choice = scan.nextInt();

        boolean isSell = true;
        while (isSell) {

            if (choice >= 1 && choice <= weapons.length) {
                int wpIndex = choice - 1;
                Weapon select = weapons[wpIndex];

                if (character.getGold() >= select.getPrice()) {
                    character.setGold(character.getGold() - select.getPrice());
                    System.out.println("무기를 구매했습니다: " + select.getName());
                    character.getInventory().add(select); // 인벤토리에 무기 추가
                    System.out.println("현재 골드\uD83D\uDCB0 : " + character.getGold());
                    break;
                } else {
                    System.out.println("골드가 부족합니다.");
                    break;
                }
            } else if (choice == 0) {
                isSell = false;
                break;


            } else {
                System.out.println("다시 선택 해주세요.");
                break;
            }
        }
    }

    public static void sellWp(Character character) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Weapon> inventory = character.getInventory();

        System.out.println("인벤토리에 있는 무기 목록:");
        for (int i = 0; i < inventory.size(); i++) {
            Weapon weapon = inventory.get(i);
            int wpNum = inventory.size() - 1; // 선택한 웨폰의 실제 위치
            Weapon select = inventory.get(wpNum);
            System.out.println((inventory.size() + 1) + ". " + weapon.getName() + " (공격력: " +
                    weapon.getDamage() + ", 강화 레벨: " + weapon.getWplevel() + " 판매가격: " +
                    select.getSellPrice() / 2 + ")");
        }
        System.out.println("현재 골드\uD83D\uDCB0 : " + character.getGold());

        if (inventory.isEmpty()) {
            System.out.println("판매할 무기가 없습니다.");
        } else {
            System.out.print("판매할 무기 선택, 0(취소) >>> ");
            int choice = scan.nextInt();

            if (choice == 0) {
                System.out.println("판매를 취소했습니다.");
            } else if (choice != 0 && choice <= inventory.size()) {
                int wpNum = choice - 1; // 선택한 웨폰의 실제 위치
                Weapon select = inventory.get(wpNum);
                int sell = select.getSellPrice() / 2; // 판매 가격은 가격의 절반

                character.setGold(character.getGold() + sell); // 골드 업데이트
                inventory.remove(wpNum); // 무기를 인벤토리에서 제거
                System.out.println("무기를 판매했습니다. 획득한 골드: " + sell);
            } else {
                System.out.println("다시 선택해주세요.");
            }
        }
    }
    public static void upWp(Character character) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Weapon> inventory = character.getInventory();

        System.out.println("인벤토리에 있는 무기 목록:");
        for (int i = 0; i < inventory.size(); i++) {
            Weapon weapon = inventory.get(i);
            System.out.println(i + 1 + ". " + weapon.getName() + " (공격력: " +
                    weapon.getDamage() + ", 강화 레벨: " + weapon.getWplevel() + ")");
            System.out.println("현재 골드\uD83D\uDCB0 : " + character.getGold());
        }

        if (inventory.isEmpty()) {
            System.out.println("인벤토리가 비어 있습니다. 강화할 무기가 없습니다.");
            System.out.println("현재 골드\uD83D\uDCB0 : " + character.getGold());
            return;
        }

        while (true) { // 강화 계속 시도
            System.out.print("강화할 무기 선택, 0(취소) >>> ");
            int choice = scan.nextInt();

            if (choice == 0) {
                System.out.println("강화를 종료했습니다.");
                break;
            } else if (choice >= 1 && choice <= inventory.size()) {
                int wpNum = choice - 1; // 실제 인덱스
                Weapon select = inventory.get(wpNum); // 인벤토리에 있는 무기 인덱스 번호

                System.out.println("강화 레벨: " + select.getWplevel());

                double random = Math.random();
                if (random < 0.5) { // 50% 확률로 강화 성공
                    Weapon weapon = new Weapon();
                    int newDamage = select.getDamage() + 5; // 공격력 5 증가
                    select.setDamage(newDamage);
                    select.lvUp();
                    character.setGold(character.getGold() - 100); // 골드 100 소모
                    System.out.println("\uD83C\uDF89 무기 강화에 성공했습니다. 새로운 공격력: " + newDamage +
                            ", 강화 레벨: " + select.getWplevel() + ", 판매가격 :" + (weapon.getSellPrice() / 2) );
                    System.out.println("소모한 골드: 100");
                    System.out.println("현재 골드\uD83D\uDCB0 : " + character.getGold());

                } else if (random < 0.96) { // 46% 확률로 유지
                    System.out.println(" \uD83D\uDE02 무기 강화에 실패했습니다. 강화 레벨: " + select.getWplevel());
                    character.setGold(character.getGold() - 100); // 강화 실패 시에도 골드 100 소모
                    System.out.println("소모한 골드: 100");
                    System.out.println("현재 골드\uD83D\uDCB0 : " + character.getGold());
                } else { // 나머지 확률로 파괴
                    inventory.remove(wpNum); // 강화 실패
                    character.setGold(character.getGold() - 100); // 무기 파괴 시에도 골드 100 소모
                    System.out.println("무기 강화에 실패하여 무기가 파괴되었습니다.");
                    System.out.println("소모한 골드: 100");
                    System.out.println("현재 골드\uD83D\uDCB0 : " + character.getGold());
                }
            } else {
                System.out.println("다시 선택 해주세요.");
            }
        }

    }
}
