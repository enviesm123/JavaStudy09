package taegon.submit12.Board;

import java.util.Scanner;

public class BoardMain {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Board board = Board.getInstance();


        while (true){
            System.out.println("행동을 선택해 주세요");
            System.out.println("1. 글목록 | 2. 글쓰기 | 3. 종료");
            System.out.print(">>> ");
            int command = Integer.parseInt(scan.nextLine());
            if(command == 1){
                // 글목록
                board.bList();

            }else if(command ==2){
                // 글 쓰기
                System.out.print("글 제목을 입력해주세요: ");
                String title = scan.nextLine();
                System.out.print("글 내용을 입력해주세요: ");
                String content = scan.nextLine();
                board.write(title, content);


            }else{
                // 종료
                System.out.println("종료합니다");
                break;
            }
        }




    }

}
