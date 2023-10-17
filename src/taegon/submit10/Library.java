package taegon.submit10;

import ch09_class.homepage.Board;

import java.util.ArrayList;

public class Library {
    private static ArrayList<Book> bookList = new ArrayList<>();

    String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,해리포터와 불사조 기사단, " +
            "해리포터와 혼혈왕자, 해리포터와 죽음의 성물, 어린왕자, 나의 라임 오렌지나무, 이것이 자바다, 좋은생각, 반지의 제왕: 반지 원정대, " +
            "반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, 토익보카, 개미";





    private Library() {
        String[] strSpl = strBooks.split(", ");
        for(int i = 0 ; i < strSpl.length; i++){
            bookList.add(new Book((i+1), strSpl[i]));
            System.out.println(bookList.get(i));
        }
    }

    public void bookRent(int num) {
        boolean isRent = false;
        for (int i = 0; i < bookList.size(); i++) {

            if (bookList.get(i).getNo() == num) {
                isRent = true;
                bookList.set(bookList.get(num), bookList.get(num).isRent() );
                System.out.println(bookList.get(i).getName() + "를 대여하셨습니다.");
            }
        }

    }

    public Library(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }
    private static Library instance = new Library();

    public static Library getInstance(){
        return instance;
    }

    public static void showList(){
        for(Book boList : bookList){
            System.out.println(boList);
        }
    }

    public void addBook(String book){
        bookList.add(new Book(bookList.size()+1, book));
        System.out.println("새로운 책 " + book + "이 등록 되었습니다.");
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
