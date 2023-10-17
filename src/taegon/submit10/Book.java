package taegon.submit10;

public class Book {
    private int no;         /* 도서 번호 */
    private String name;    /* 도서 제목*/
    private boolean rent;   /* 대여여부 */

    public Book() {

    }

    public Book(int no, String name, boolean rent) {
        this.no = no;
        this.name = name;
        this.rent = false;
    }


    @Override
    public String toString() {
        return "Book{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", rent=" + rent +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }
}
