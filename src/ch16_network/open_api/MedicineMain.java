package ch16_network.open_api;

import ch16_network.open_api.dto.MedicineDTO;
import ch16_network.open_api.service.MedicineService;

import java.util.ArrayList;
import java.util.Scanner;

public class MedicineMain {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        MedicineService medicineService = MedicineService.getInstance();


        while (true) {
            System.out.println("증상을 이야기 해주세요 [종료: q]");
            System.out.print(">>> ");

            String select = scan.nextLine();

            if (select.equals("q") || select.equals("ㅂ")) {
                System.out.println("종료 합니다");
                break;
            }
            // 사용자에 맞는 약 추천한 리스트 보여주기
            ArrayList<MedicineDTO> recoList = medicineService.recommend(select);
            if (recoList.size() == 0) {
                System.out.println("해당 증상에 대한 약이 없습니다.");
                continue;
            } else {
                System.out.println("약국에 가서 아래의 약들을 요청하세요.");
                for (int i = 0; i < recoList.size(); i++) {
                    System.out.println(recoList.get(i).getItemName());
                }

            }
        }
    }
}
