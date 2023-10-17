package ch09_class.homepage;

import java.util.ArrayList;

public class MemberDB {
    private ArrayList<Member> memList = new ArrayList<>();

    // 싱글톤 패턴 적용
    // 프로젝트 내에서 이 객체를 딱 하나만 생성해서 쓸때 사용
    // 1. 기본 생성자의 접근제어자를 private으로 막는다.
    private MemberDB() {
        memList.add(new Member("admin", "admin", "관리자"));
        memList.add(new Member("a0041", "123a", "호빵맨"));
    }

    // 2. 필드에 자기 자신 MemberDB 객체(instance)를 생성한다.
    // 2-1. static을 붙여서 달느곳에서 객체 생성없이 접근하도록 만
    // 2-2. 다른곳에서 .instance로 직접 접근 못하도록 private 처리
    private static MemberDB instance = new MemberDB();

    // 3. instance 에 대한 Getter 만들어주기
    public static MemberDB getInstance() {
        return instance;
    }
    // 회원가입 메소드
    // 회원가입 성공시 1을 리턴, 실패시 0을 리턴
    public int signUp(Member mem){
        for(int i = 0; i < memList.size(); i++){
            if(memList.get(i).getId().equals(mem.getId())){

                return 0;
            }
        }
        memList.add(mem);
        return 1;

    }

    // 회원목록 메소드
    public void showMemList(){
        for(int i = 0; i < memList.size(); i++){
            System.out.println(memList.get(i));
        }
    }

    // 로그인
    public Member login(String id, String pw){
//        for(int i = 0; i < memList.size(); i++){
//            if(memList.get(i).getId().equals(id) &&
//                    memList.get(i).getPw().equals(pw)){
//                return memList.get(i);
//            }
//        }
        // 위와 같지만 깔끔함
        for(Member mem : memList){
            if(mem.getId().equals(id) && mem.getPw().equals(pw)){
                return mem;
            }
        }

        return null;
    }

}
