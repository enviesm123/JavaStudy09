package taegon;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class SubmitHV {

    public static void main(String[] args) throws ParseException, org.json.simple.parser.ParseException {

        //        Q.01
//
//
//        다음의 JSON String을 Json-simple 라이브러리를 이용하여

        String response = "{ \"city\" : [\"서울\", \"광주\", \"대구\", \"대전\", \"부산\", \"울산\", \"인천\"], " +
                "\"fields\": [{\"id\": \"자장면\"},{\"id\": \"냉면\"}, {\"id\": \"김밥\"}, {\"id\": \"칼국수\"}], " +
                "\"records\": [{\"시도명\": \"서울\", \"자장면\": 7069, \"냉면\": 11308, \"김밥\": 3215, \"칼국수\": 8962}, " +
                "{\"시도명\": \"광주\", \"자장면\": 6800, \"냉면\": 9400, \"김밥\": 3160, \"칼국수\": 8400}, " +
                "{\"시도명\": \"대구\", \"자장면\": 6250, \"냉면\": 10417, \"김밥\": 2750, \"칼국수\": 6750}, " +
                "{ \"시도명\": \"대전\", \"자장면\": 6700, \"냉면\": 10400, \"김밥\": 3000, \"칼국수\": 7800}, " +
                "{\"시도명\": \"부산\", \"자장면\": 6143, \"냉면\": 10857, \"김밥\": 2786, \"칼국수\": 6986}, " +
                "{ \"시도명\": \"울산\", \"자장면\": 6500, \"냉면\": 9900, \"김밥\": 3300, \"칼국수\": 8400}, " +
                "{\"시도명\": \"인천\", \"자장면\": 6500, \"냉면\": 10667, \"김밥\": 3050, \"칼국수\": 8000}]}";


//        7개 도시 중 가장 냉면 값이 저렴한 도시와 그 가격을 찾아 출력해보세요.
        // records 값에 접근해서 배열로 만든 다음에 냉면에 들어있는 밸류를 비교해서 가장 높은값을 구한다

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObj = (JSONObject) jsonParser.parse(response);
        System.out.println(jsonObj);
        JSONArray records = (JSONArray) jsonObj.get("records");
        System.out.println(jsonObj.get("records"));
        String city = "";
        JSONObject price =(JSONObject)records.get(0);
        for(int i = 0; i < records.size() -1; i++){
            JSONObject nm = (JSONObject)records.get(i);
            if((long)price.get("냉면") > (long) nm.get("냉면")){
                    price.put("냉면", (long) nm.get("냉면"));
                    city = (String)nm.get("시도명");
                System.out.println(city + ", "+ "냉면가격: " + price.get("냉면"));
            }
        }


//        7개 도시의 자장면 평균 가격을 계산하여 출력해보세요.

        System.out.println("\n===============================\n");

        int sum = 0;
        double avg = 0;
        for(int i = 0 ; i < records.size(); i++){
            JSONObject jja = (JSONObject)records.get(i);
            System.out.println(jja);
            sum += Double.parseDouble(String.valueOf(jja.get("자장면")));
            avg = sum / records.size();
        }
        System.out.println(records.size() + "개 도시 자장면 평균 가격: " + avg + "원");

//        Q.02
//
//        가끔 우리가 데이터베이스에 데이터를 추가할때, 유니크한 아이디를 넣어서 추가해야하는 경우가 많다.
//        그때 사용하는게 UUID.randomUUID().toString() 인데, 우리가 따로 유니크한 아이디를 만드는 메소드를 만들어보자.
//
//        메소드 실행시 현재 날짜에 대한 yyMMddHHmmssSSS 포맷의 문자열과
//        이후 랜덤한 숫자 6자리를 뒤에 덧붙인 문자열이 리턴된다. (실제로 이 방법도 쓰임)

        String uniqueId = makeUniqueId();
        System.out.println(uniqueId);

//        Q.03
//
//        오늘 점심은 대체 뭘 먹을까요.. 점심메뉴 이상형 월드컵을 만들어봅시다~!!
//
//                아래의 실행 예시를 참고하여 자유롭게 만들어보세요.

        Scanner scan = new Scanner(System.in);
        ArrayList<String> menu = new ArrayList<>();
        menu.add("짜장면");
        menu.add("짬뽕");
        menu.add("김치찌개");
        menu.add("제육볶음");
        menu.add("돈까스");
        menu.add("카레");
        menu.add("김밥/라면");
        menu.add("순대국밥");
        menu.add("냉면");
        menu.add("삼겹살");
        menu.add("생선구이");
        menu.add("햄버거");
        menu.add("떡볶이");
        menu.add("소고기국밥");
        menu.add("시래기");

        System.out.println(menu);

//        while(true){
//            System.out.println("16강");
//            System.out.println("메뉴를 선택해주세요");
//            System.out.print(">>> ");
//            int command = Integer.parseInt(scan.nextLine());
//
//            // 랜덤으로 선택지 2개 출
//            if(command == 1){
//                System.out.println(); // 메뉴는 랜덤한것이뜬다.
//                // 목록두개를 빼고 선택된것은 다른 리스트에 추가
//
//            }else if(command ==2){
//
//            }
//        }





    }
    public static String makeUniqueId() throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
        String strDate = sdf.format(date);
        String strRand = "";
        for(int i = 0; i < 6; i++ ){
            int randInt = (int)(Math.random() * 10);
            strRand += randInt;
            System.out.println(strRand);
        }
        String uniqueId = strDate + strRand;

        return uniqueId; //231027123857589639323
    }
}

