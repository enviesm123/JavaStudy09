package taegon.submit12.Board;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardParent {
    Date dateToday = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
    private int number;
    private String title;
    private String date = sdf.format(dateToday) ;
    private String content;

    public BoardParent() {
        Date dateToday = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        this.number = getNumber();
        this.title = title;
        this.date = date = sdf.format(dateToday) ;


    }



    public BoardParent(int number, String title, String content) {
        this.number = number;
        this.title = title;
        this.date = date;
    }

    public BoardParent(int number, String title, String date, String content) {
        this.number = number;
        this.title = title;
        this.date = date;
        this.content = content;
    }




    @Override
    public String toString() {
        return "BoardParent{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

