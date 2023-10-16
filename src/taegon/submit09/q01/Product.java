package taegon.submit09.q01;

import taegon.submit09.q02.Fish;

import java.util.ArrayList;

public class Product {
    private String name; /* 제품명 */
    private int price;  /* 제품가격 */


    @Override
    public String toString() {
        return "제품명: " + name +
                ", 가격: " + price;
    }

    public Product() {
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
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




    }


