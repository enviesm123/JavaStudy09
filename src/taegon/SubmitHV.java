package taegon;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


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
        JSONArray records = (JSONArray) jsonObj.get("records");
        System.out.println(records);

        long minPrice = (long)((JSONObject)records.get(0)).get("냉면");
        for(int i = 0; i < records.size(); i++){
            JSONObject city = (JSONObject)records.get(i);
            if(minPrice > (long)city.get("냉면")){
                minPrice = (long)city.get("냉면");
            }
        }
        System.out.println("냉면 최소값: " + minPrice);

        for(int i = 0; i < records.size(); i++){
            JSONObject city = (JSONObject)records.get(i);
            if((long)city.get("냉면") == minPrice){
                System.out.println("냉면이 제일 싼 도시: " + city.get("시도명"));
            }
        }

        // 자장면 평균 가격 구하기

        long totalPrice = 0;
        for(int i = 0; i < records.size(); i++){
            JSONObject city = (JSONObject)records.get(i);
            totalPrice += (long) city.get("자장면");
        }

        double avgPrice = totalPrice / records.size();

        System.out.println("7개도시 자장면 평균값: " + avgPrice);



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
        menu.add("볶음밥");
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
        menu.add("육개");

        System.out.println(menu);

        // menu를 랜덤하게 섞기
        Collections.shuffle(menu);

        worldCup(menu);





    }
    public static void worldCup(ArrayList<String> menu){
        Scanner scan = new Scanner(System.in);
        ArrayList<String> selectList = new ArrayList<>();

        for(int i = 0; i < menu.size(); i += 2){
            if(menu.size() == 2){
                System.out.println("결승=====================");
            }else{
                System.out.println(menu.size() + "강 ===================");
            }
                System.out.println("메뉴를 선택해 주세요");
                System.out.println("1. " + menu.get(i));
                System.out.println("2. " + menu.get(i + 1));
                System.out.print(">>> ");

            int select = Integer.parseInt(scan.nextLine());
            if(select == 1){
                selectList.add(menu.get(i));
            }else{
                selectList.add(menu.get(i+1));
            }
        }

        menu = selectList;
        if(menu.size() == 1){
            System.out.println(menu.get(0) + " 우승!!!");
        }else{
            // 재귀함수
            worldCup(menu);
        }

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

