package taegon.submit12.board;

import java.util.ArrayList;

public class Board extends BoardParent {

    ArrayList<Board> boardList = new ArrayList<>();
    private static Board instance = new Board();

    public Board() {

    }

    public static Board getInstance(){
        return instance;
    }
    public ArrayList<Board> getBoardList() {
        return boardList;
    }

    public Board(int number, String title, String date, String content) {
        super(number, title, date, content);
    }



    public Board(int number, String title, String content) {
        super(number, title, content);
    }

    public void write(String title, String content){
        boardList.add(new Board(boardList.size() + 1, title, content));
        for(int i = 0; i < boardList.size(); i++) {
            System.out.println(i + 1 + ". | " + boardList.get(i).getTitle()
                    + " | " + boardList.get(i).getDate());
        }

    }
    public void bList(){
        for(int i = 0; i < boardList.size(); i++){
            System.out.println(i+1 + ". | " + boardList.get(i).getTitle()
                    + " | " + boardList.get(i).getDate());
        }
    }

}

