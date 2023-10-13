package taegon.submit08;


import java.util.*;

public class Submit08 {
    public static void main(String[] args) {


        ArrayList<Integer> myLotto = makeLotto();
        System.out.println(myLotto);

        System.out.println("\n======================\n");

//        Q. 02
//
//        infoMap의 Key는 사용자의 아이디, Value는 사용자의 비밀번호라고 했을 때 아래와 같이 데이터를 추가해주세요.
//
        Scanner scan = new Scanner(System.in);
        HashMap<String, String> infoMap = new HashMap<>();

        infoMap.put("a001", "1234a");
        infoMap.put("b001", "1234b");
        infoMap.put("c001", "1234c");
        infoMap.put("d001", "1234d");
        infoMap.put("e001", "1234e");
//
//
//        사용자가 아이디와 비밀번호를 파라미터로 넣었을때,
//                infoMap의 Key(아이디)와 Value(비밀번호)와 비교하여

        while (true){
            System.out.println("아이디를 입력해주세요");
            System.out.print(">>>>  ");
            String inputID = scan.nextLine();
            System.out.println("비밀번호를 입력해주세요");
            System.out.print(">>>>  ");
            String inputPw = scan.nextLine();

            // TODO 로그인 성공
            if(infoMap.containsKey(inputID)){
                if(infoMap.get(inputID).equals(inputPw)) {
                    System.out.println("로그인 성공");
                    break;
                    // TODO 비밀번호가 틀림
                }else{
                    System.out.println("비밀번호 틀렸습니다");
                }
                // TODO 로그인 아이디 없음
            }else{
                    System.out.println("아이디 없음");

            }
//                System.out.println(infoMap.get(inputID).equals(inputPw));



//        아이디와 비밀번호가 infoMap 내에 존재하는 데이터와 일치하면 로그인 성공 출력


        }


//        아이디가 존재하지 않으면, 존재하지 않는 아이디입니다. 출력

//        아이디는 존재하지만 비밀번호가 일치하지 않으면 비밀번호가 틀렸습니다. 출력



    } //메소드의끝

    public static ArrayList<Integer> makeLotto(){
        //        makeLotto를 ArrayList와 HashSet을 이용해서 만들어보세요
//                Hint
//        먼저 빈 HashSet을 하나 만들고, while문 내에서 빈 HashSet에 랜덤 로또 번호를 HashSet의 사이즈가 6개가 될 때까지 넣는다.
        HashSet<Integer> lotto = new HashSet<>();
        int randInt = 0;
        while(lotto.size() < 7){
            randInt = (int)(Math.random() * 45) + 1;
            lotto.add(randInt);
        }
//        이후 HashSet을 ArrayList로 변환한 다음, 오름차순으로 ArrayList를 정렬하여 리턴한다.
        ArrayList<Integer> makeLotto = new ArrayList();
        makeLotto.addAll(lotto);
        Collections.sort(makeLotto);
        return makeLotto;


    }
}
