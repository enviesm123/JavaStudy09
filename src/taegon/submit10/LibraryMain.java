package taegon.submit10;

import ch09_class.homepage.MemberDB;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
//        Q. 01

//        아주아주 간단한 도서관 시스템을 만들어봅시다.
//                도서 번호와 도서 제목, 그리고 대여 여부를 필드변수로 포함하는 Book 클래스를 만들어주세요. 대여 여부의 기본값(디폴트값)은 false로 해주세요

//        Book 객체들을 보관하는 Library 클래스를 만들어주세요. 싱글턴 패턴을 적용해주세요.

//                Library 클래스에 bookList를 만드셨겠죠? 도서 목록은 자유롭게 하셔도 되고, 제가 제공해드리는 도서 목록을 사용하셔도 됩니다.
//                String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,해리포터와 불사조 기사단,
//                해리포터와 혼혈왕자, 해리포터와 죽음의 성물,어린왕자, 나의 라임 오렌지나무, 이것이 자바다, 좋은생각,
//                반지의 제왕: 반지 원정대, 반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, 토익보카, 개미";
//※ strBooks 문자열을 하나하나 쪼개서 Book객체를 만들고 bookList에 담아주세요.
//
//        책 입고, 책 대여, 책 목록조회, 책 검색을 할 수 있도록 프로그램을 만들어주세요.

        // 싱글톤
        Library library = Library.getInstance();
        Scanner scan = new Scanner(System.in);




        while(true){
            System.out.println("행동을 입력해 주세요");
            System.out.println("1. 책 입고 | 2. 책 대여 | 3. 책 목록조회 | 4. 책검색");
            System.out.print(">>>");

            int command = Integer.parseInt(scan.nextLine());


            if(command == 1){
                // 책 입고
                System.out.println("입고할 책의 이름을 입력해주세요.");
                System.out.print(">>> ");

                String addBook = scan.nextLine();
                library.addBook(addBook);


            }else if(command == 2){
                // 책 대여
                library.showList();
                System.out.println("대여할 책의 번호를 입력해주세요.");
                System.out.print(">>> ");

                int inputRent = Integer.parseInt(scan.nextLine());

                library.bookRent(inputRent);

            }else if(command == 3){
                // 책 목록조회

                library.showList();


            }else if(command == 4){
                // 책 검색

            }else{
                System.out.println("잘못 입력하셨습니다");
                return;
            }




        }



        }
}
