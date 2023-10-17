package taegon.submit10;

import java.util.ArrayList;

public class Library {
    private static ArrayList<Book> bookList = new ArrayList<>();

    private Library() {
        String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수," +
                "해리포터와 불사조 기사단, 해리포터와 혼혈왕자, 해리포터와 죽음의 성물,어린왕자, 나의 라임 오렌지나무, " +
                "이것이 자바다, 좋은생각, 반지의 제왕: 반지 원정대, 반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, 토익보카, 개미";
        String[] splitBk = strBooks.split(", ");
        for(int i = 0 ; i < splitBk.length; i++){
            System.out.println(splitBk[i]);
            bookList.add(new Book(bookList.size() + 1, splitBk[i], false));
        }
    }

    public Library(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }
    private static Book instance = new Book();

    public static Book getInstance(){
        return instance;
    }

    public static void showList(){
        for(Book boList : bookList){
            System.out.println(boList);
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
