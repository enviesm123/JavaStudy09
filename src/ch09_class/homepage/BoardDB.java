package ch09_class.homepage;

import java.util.ArrayList;

public class BoardDB {
    private ArrayList<Board> boardList = new ArrayList<>(); /*게시판 리스트*/

    private BoardDB() {
        boardList.add(new Board(boardList.size() + 1, "첫 번째 게시글 제목", "오늘하루", "호빵맨"));
        boardList.add(new Board(boardList.size() + 1, "두 번째 게시글 제목", "내일하루", "식빵맨"));
        boardList.add(new Board(boardList.size() + 1, "세 번째 게시글 제목", "모레하루", "찐빵맨"));

    }

    // 싱글톤 패턴
    private static BoardDB instance = new BoardDB();

    public static BoardDB getInstance() {
        return instance;
    }

    public void printBoard(){
        for(Board bo : boardList){
            System.out.println("[" + bo.getNo() + " | "
                    + bo.getTitle() + " | " + bo.getName() + "]");
        }
    }

    // 게시글 등록 메소드
    public void writeBoard(String title, String content, String name){
        boardList.add(new Board(boardList.size() + 1, title, content, name));
    }

    // 게시글 보기 메소드
    public void readBoard(int no){
        for(Board bo : boardList){
           if(bo.getNo() == no){
               System.out.println("================");
               System.out.println("제목: " + bo.getTitle());
               System.out.println("작성자: " + bo.getName());
               System.out.println("----------------");
               System.out.println(bo.getContent());
               System.out.println("================");
               return;

           }
        }


    }
}
