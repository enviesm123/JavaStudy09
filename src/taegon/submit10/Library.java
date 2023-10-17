package taegon.submit10;

import ch09_class.homepage.Board;

import java.util.ArrayList;

public class Library {
    private static ArrayList<Book> bookList = new ArrayList<>();

    private Library() {
        bookList.add(new Book(bookList.size() + 1, "반지의제왕", false));
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
