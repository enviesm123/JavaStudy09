package taegon.submit12.Date;

import taegon.submit09.q01.Product;
import taegon.submit12.Board.Board;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateBoardMain {

    public static void main(String[] args) throws ParseException {

        // dbList에 랜덤 날짜를 가지는 DateBoard 객체 100개 삽입
        ArrayList<DateBoard> dbList = new ArrayList<DateBoard>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        for(int i = 0; i < 100; i++) {
            int randDay = (int)(Math.random() * 365) + 1;		// 1~365
            Calendar cal = Calendar.getInstance(); // 오늘날짜
            cal.add(Calendar.DATE, randDay * -1); // 오늘날짜에서 1~365 중 랜덤한 일수를 뺀다.

            String strDate = sdf.format(cal.getTime());
            dbList.add(new DateBoard((i+1) + "번째 생성된 글", strDate));
        }

        for(int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i));
        }

        // TODO 코드작성 시작 ~!!

//        무작위 날짜로 생성된 DateBoard를 담고 있는
//        dbList를 날짜순으로 정렬 하여 출력해주세요.
            for(int i = 0; i < dbList.size()-1; i++) {
                for (int k = 0; k < dbList.size(); k++) {
                    if (sdf.parse(dbList.get(i).getDate()).getTime() >
                            sdf.parse(dbList.get(i + 1).getDate()).getTime()){
                        DateBoard temp = dbList.get(i);
                        dbList.set(i, dbList.get(i+1));
                        dbList.set(i+1, temp);
                    }
                }
            }


        System.out.println(dbList);




    }
}
