package taegon.submit11;

import java.util.ArrayList;
import java.util.Scanner;

public class RpgMain {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Character character = Character.getInstance();



        System.out.println("                                                                                                 \n" +
                "                                                                                                 \n" +
                "||   / |  / /                                                              //   / /     //   ) ) \n" +
                "||  /  | / /      ___        ___        ___        ___         __         //   / /     //___/ /  \n" +
                "|| / /||/ /     //___) )   //   ) )   //   ) )   //   ) )   //   ) )     //   / /     / ____ /   \n" +
                "||/ / |  /     //         //   / /   //___/ /   //   / /   //   / /     //   / /     //          \n" +
                "|  /  | /     ((____     ((___( (   //         ((___/ /   //   / /     ((___/ /     //           \n");

        System.out.println("                                                             \n" +
                "                                                             \n" +
                "                          //   ) )     //   ) )     //   ) ) \n" +
                "                         //___/ /     //___/ /     //        \n" +
                "                        / ___ (      / ____ /     //  ____   \n" +
                "                       //   | |     //           //    / /   \n" +
                "                      //    | |    //           ((____/ /    \n");
        System.out.println("================");
        System.out.println("캐릭터를 생성해 주세요");
        System.out.print("닉네임 >>> ");
        String name = scan.nextLine();

        // 캐릭터 생성
        character.setName(name);
        System.out.println(name + "님 환영합니다!!!");
        System.out.println("_____________________________________________________________________________________________\n" +
                "  _      _                                                                          /      / \n" +
                "  |  |  /                    /                                                     /      /  \n" +
                "--|-/|-/----------__--------/---------__---------__--------_--_---------__--------/------/---\n" +
                "  |/ |/         /___)      /        /   '      /   )      / /  )      /___)      /      /    \n" +
                "__/__|_________(___ ______/________(___ ______(___/______/_/__/______(___ ______o______o_____\n" +
                "                                                                                             \n" +
                "                                                                                             \n");


        System.out.println("=============게임 설명=============");
        System.out.println("=================================");
        System.out.println("대장간에서 무기를 구매 해보세요");
        System.out.println("강화를 하고 팔아서 골드를 획득 해보세요.");


        // 게임 루프
        boolean isRun = true;
        while (isRun) {
            System.out.println("================");
            System.out.println("1. 대장간");
            System.out.println("2. 인벤토리");
            System.out.println("3. 종료");
            System.out.print("선택 >>> ");
            int choice = scan.nextInt();


            while (isRun) {


                if (choice == 1) {
                    // 대장간 (무기 구매, 무기 판매 등)
                    Character.forge(character);


                } else if (choice == 2) {
                    // 인벤토리 목록
                    Weapon.invenList(character);
                    break;
                } else if (choice == 3) {

                    System.out.println("게임을 종료합니다.");

                    isRun = false;
                    break;
                } else {
                    System.out.println("다시 선택 해주세요.");
                    break;
                }
            }
        }

    }






}
