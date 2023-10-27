package taegon.submit12.dateboard;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateBoardMain {

    public static void main(String[] args) throws ParseException, org.json.simple.parser.ParseException {

        // dbList에 랜덤 날짜를 가지는 DateBoard 객체 100개 삽입
        ArrayList<DateBoard> dbList = new ArrayList<DateBoard>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        for (int i = 0; i < 100; i++) {
            int randDay = (int) (Math.random() * 365) + 1;        // 1~365
            Calendar cal = Calendar.getInstance(); // 오늘날짜
            cal.add(Calendar.DATE, randDay * -1); // 오늘날짜에서 1~365 중 랜덤한 일수를 뺀다.

            String strDate = sdf.format(cal.getTime());
            dbList.add(new DateBoard((i + 1) + "번째 생성된 글", strDate));
        }

        for (int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i));
        }

        // TODO 코드작성 시작 ~!!

//        무작위 날짜로 생성된 DateBoard를 담고 있는
//        dbList를 날짜순으로 정렬 하여 출력해주세요.
//           for(int i = 0; i < dbList.size(); i++){
//               for(int k = 0; i < dbList.size(); k++){
//                  Date fDate = sdf.parse(dbList.get(i).getDate());
//                  Date sDate = sdf.parse(dbList.get(i+1).getDate());
//                  if(fDate.getTime() - sDate.getTime() < 0){
//
//                  }
//               }

        System.out.println("\n=========== 과거순 정렬 =============\n");

        Collections.sort(dbList, (boardA, boardB) -> {
            try {
                Date dateA = sdf.parse(boardA.getDate());
                Date dateB = sdf.parse(boardB.getDate());

                long diff = dateA.getTime() - dateB.getTime();
                return (diff < 0) ? -1 : 1;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });

        for (int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i));
        }


        System.out.println("\n=========== 최신순 정렬 =============\n");

        for (int i = 0; i < dbList.size() - 1; i++) {
            for (int k = 0; k < dbList.size() - i - 1; k++) {
                Date dateA = sdf.parse(dbList.get(k).getDate());
                Date dateB = sdf.parse(dbList.get(k + 1).getDate());

                // 내림차순
                if (dateA.getTime() < dateB.getTime()) {
                    DateBoard temp = dbList.get(k);
                    dbList.set(k, dbList.get(k + 1));
                    dbList.set(k + 1, temp);
                }
            }
        }

        for (int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i));
        }

        System.out.println("\n============ 최근 한달 내 ==============\n");

        // 30일 전 -> 11.27 이면 10.28
        // 오늘 날짜에 대한 그 long 타입 숫자에 대해 30일치 만큼의 밀리초를 뺀다
        // = 오늘로부터 30일 전에 해당하는 long 타입 날짜
        // 30일 전 날짜보다 long 타입 숫자 크기가 큰 애들만 출력

        long before30 = System.currentTimeMillis() - (30 * 24 * 60 * 60 * 1000L);
        System.out.println(before30);

        for(int i = 0; i < dbList.size(); i++){
            Date temp = sdf.parse(dbList.get(i).getDate());
            if(before30 <= temp.getTime()){
                System.out.println(dbList.get(i));
            }
        }

        // 오늘이 10.27이면 9.27 국룰
        // 오늘 날짜 기준인 Calendar로 부터 한달을 빼고
        // 한달 뺀 Calendar로 부터 그 long 타입 날짜를 구한뒤
        // = 한달 전 long 타입 날짜
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);

        System.out.println(sdf.format(cal.getTime()));

        for(int i = 0; i < dbList.size(); i++){
            Date temp = sdf.parse(dbList.get(i).getDate());
            if(cal.getTime().getTime() <= temp.getTime()){
                System.out.println(dbList.get(i));
            }
        }

        System.out.println("\n============ 6 월만 출력 ==============\n");

        for(int i = 0; i < dbList.size(); i++){
            Date temp = sdf.parse(dbList.get(i).getDate());

            Calendar tempCal = Calendar.getInstance();
            tempCal.setTime(temp);

            if(tempCal.get(Calendar.MONTH) + 1 == 6
                && tempCal.get(Calendar.YEAR) == 2023){
                System.out.println(dbList.get(i));
            }
        }

        System.out.println("\n==========================\n");

        String left = "2023.07.14 00:00:00";
        String right = "2023.08.21 23:59:59";

        Date leftDate = sdf.parse(left);
        Date rightDate = sdf.parse(right);

        // leftDate 의 long 타입 날짜 => 16000
        // rightDate 의 long 타입 날짜 => 19000
        // dbList.get(i).getDate() 날짜의 long 타입 날짜가
        // 16000 < x < 19000 에 해당하는 객체만 출력
        for(int i = 0 ; i < dbList.size(); i++){
            Date temp = sdf.parse(dbList.get(i).getDate());
            if(leftDate.getTime() <= temp.getTime()
                && temp.getTime() <= rightDate.getTime()){
                System.out.println(dbList.get(i));
            }
        }

        System.out.println("\n==========================\n");

//        2020년 8월 2일의 한국 환율(KRW) 값을 꺼내보세요

        String resp = "{\"success\": true, \"timeseries\": true, \"base\": \"USD\", " +
                "\"start_date\": \"2020-08-01\", \"end_date\": \"2022-08-01\", " +
                "\"rates\": {\"2020-08-01\": {\"JPY\": 105.65, \"KES\": 107.57, " +
                "\"KGS\": 76.52, \"KHR\": 4092.64, \"KMF\": 417.5, \"KPW\": 898.38, " +
                "\"KRW\": 1192.25}, \"2020-08-02\": {\"JPY\": 105.74, \"KES\": 107.69, " +
                "\"KGS\": 76.62, \"KHR\": 4100, \"KMF\": 418.06, \"KPW\": 899.58, \"KRW\": 1193.46}}}";

        System.out.println(resp);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObj = (JSONObject) jsonParser.parse(resp);

        JSONObject rates = (JSONObject)jsonObj.get("rates");

        JSONObject target = (JSONObject)rates.get("2020-08-02");

        System.out.println(target.get("KRW"));

        double tt = (double)target.get("KRW");
        System.out.println(tt);









    }
}
