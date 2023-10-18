package taegon.submit11;

import java.util.ArrayList;

public class CalculatorDB {
    private static ArrayList<Calculator> calList = new ArrayList<>();

    private static CalculatorDB instance = new CalculatorDB();

    public static CalculatorDB getInstance(){
        return instance;
    }



    // 더하기
    public static void numPlus(int num){
        ArrayList<Integer> sum = new ArrayList<>();
        int result = 0;
        result = num;
        sum.add(result);

        System.out.println(result);





    }
    public CalculatorDB(ArrayList<Calculator> calDB) {
        this.calList = calDB;
    }

    public CalculatorDB() {
    }

    @Override
    public String toString() {
        return "CalculatorDB{" +
                "calDB=" + calList +
                '}';
    }

    public ArrayList<Calculator> getCalDB() {
        return calList;
    }

    public void setCalDB(ArrayList<Calculator> calDB) {
        this.calList = calDB;
    }

    public ArrayList<Calculator> getCalList() {
        return calList;
    }

    public void setCalList(ArrayList<Calculator> calList) {
        this.calList = calList;
    }

    public static void setInstance(CalculatorDB instance) {
        CalculatorDB.instance = instance;
    }
}
