package taegon.submit11;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventory = new ArrayList<>();

    private static Inventory instance = new Inventory();

    public static Inventory getInstance(){
        return instance;
    }

    public Inventory() {
    }

    public Inventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory=" + inventory +
                '}';
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public static void setInstance(Inventory instance) {
        Inventory.instance = instance;
    }
}
