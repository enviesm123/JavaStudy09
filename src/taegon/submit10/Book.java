package taegon.submit10;

public class Book {
    private int no;         /* 도서 번호 */
    private String name;    /* 도서 제목*/
    private boolean isBorrow;   /* 대여여부 */

    public Book() {

    }

    public Book(int no, String name) {
        this.no = no;
        this.name = name;
        isBorrow = false;

    }

    public Book(int no, String name, boolean rent) {
        this.no = no;
        this.name = name;
        this.isBorrow = rent;

    }




    @Override
    public String toString() {

        String state = "[책번호: " + no +
                ", 책제목: " + name + ", 대여상태: : " + "입고중]";
        if(isBorrow){
            state = "[책번호: " + no +
                    ", 책제목: " + name + ", 대여상태: : " + "대여중]";
        }else{
            state = "[책번호: " + no +
                    ", 책제목: " + name + ", 대여상태: : " + "입고중]";
        }
        return state;
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

    public boolean isBorrow() {
        return isBorrow;
    }

    public void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }

   
}
