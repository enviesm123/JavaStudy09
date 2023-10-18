package taegon.submit10;



import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private static ArrayList<Book> bookList = new ArrayList<>();


    private static Library instance = new Library();

    public static Library getInstance(){
        return instance;
    }


    private Library() {
        String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,해리포터와 불사조 기사단, " +
                "해리포터와 혼혈왕자, 해리포터와 죽음의 성물, 어린왕자, 나의 라임 오렌지나무, 이것이 자바다, 좋은생각, 반지의 제왕: 반지 원정대, " +
                "반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, 토익보카, 개미";
        String[] strSpl = strBooks.split(",");
        for(int i = 0 ; i < strSpl.length; i++){
            strSpl[i] = strSpl[i].trim();
        }
        for(int i = 0 ; i < strSpl.length; i++){
            bookList.add(new Book(bookList.size(), strSpl[i]));
        }
        for(int i = 0; i < bookList.size(); i++){
            System.out.println(bookList.get(i));
        }
    }

    // 책 대여 메소드
    public void bookRent(int num) {
        // bookList에 담긴 Book 객체 중에 필드변수 num 값이
        // 파라미터로 들어온 num값과 같은 녀석을 찾고,
        // 해당 Book 객체의 isBorrow 값을 true로 바꾼다.
        for(Book bk : bookList){
            if(bk.getNo() == num ){
                bk.setBorrow(true);
                System.out.println(bk.getName() + "을(를) 대여하셨습니다.");
                return;

            }
        }

        System.out.println("해당 책이 존재하지 않습니다.");
    }

    // 책 반납(입고)
    public void returnBook(int num){
        for(Book bk : bookList){
            if(bk.getNo() == num ){
                bk.setBorrow(false);
                System.out.println(bk.getName() + "가 입고 되었습니다.");
                return;
            }
        }

    }

    public Library(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public void searchAndRent(String keyword, Scanner scan){
        ArrayList<Book> matchingBooks = new ArrayList<>();
        int index = 0;

        for (Book bk : bookList) {
            if (bk.getName().contains(keyword) && !bk.isBorrow()) {
                matchingBooks.add(bk);
            }

        }

       if(matchingBooks.size() == 1) {
            matchingBooks.get(0).setBorrow(true);
            System.out.println(matchingBooks.get(0).getName() + "을(를) 대여하셨습니다.");
        } else {
            System.out.print("대여할 책의 번호를 입력해주세요: ");
            int choice = Integer.parseInt(scan.nextLine());
            if (choice >= 1 && choice <= matchingBooks.size()) {
                matchingBooks.get(choice - 1).setBorrow(true);
                System.out.println(matchingBooks.get(choice - 1).getName() + "을(를) 대여하셨습니다.");
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }
    }


    // 책목록조회 메소드
    public void printBook(){
        for(Book boList : bookList){
            System.out.println(boList);
        }
    }

    // 책추가 메소드
    public void addBook(String book){
        bookList.add(new Book(bookList.size()+1, book));
        System.out.println("새로운 책 " + book + "이 등록 되었습니다.");
    }



    // 책 검색
    public void searchBook(String keyword) {
        for (Book book : bookList) {
            if (book.getName().indexOf(keyword) != -1) {
                System.out.println(book);
            }
        }
    }



    @Override
    public String toString() {
        return "Library{" +
                "bookList=" + bookList +
                '}';
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }


}
