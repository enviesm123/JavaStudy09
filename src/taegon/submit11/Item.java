package taegon.submit11;

public class Item {
    private int num;            /* 아이템 번호 */
    private String name;        /* 아이템 이름 */
    private int price;          /* 아이템 가격 */
    private static String grade;       /* 아이템 등급 */


    public Item() {

    }

    public Item(String name, int price, String grade) {
        num = num + 1;
        this.name = name;
        this.price = price;
        int randInt = (int)(Math.random() * 100) + 1;
        if(randInt <= 5){
            this.grade = "SS";
        }else if(randInt <= 15){
            this.grade = "S";
        }else if(randInt <= 40){
            this.grade = "A";
        }else if(randInt <= 70){
            this.grade = "B";
        }else{
            this.grade = "C";
        }


    }



    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", grade='" + grade + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }



}
