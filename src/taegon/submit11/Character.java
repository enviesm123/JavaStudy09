package taegon.submit11;

import java.util.ArrayList;

public class Character {

    private static ArrayList<State> character = new ArrayList<>();

    private static Character instance = new Character();

    public static Character getInstance(){
        return instance;
    }



    public Character() {

    }

    public Character(ArrayList<State> character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return "Character{" +
                "character=" + character +
                '}';
    }

    public ArrayList<State> getCharacter() {
        return character;
    }

    public void setCharacter(ArrayList<State> character) {
        this.character = character;
    }

    public static void setInstance(Character instance) {
        Character.instance = instance;
    }


}
