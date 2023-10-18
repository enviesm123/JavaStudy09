package taegon.submit11;

public class Calculator {
    private int num;            /* 계산할 첫번째 숫자 */
    private String Operator;           /* 연산종류 */

    public Calculator(int num, int num2) {
        this.num = num;
        this.Operator = Operator;
    }

    public Calculator() {
    }

    @Override
    public String toString() {
        return "calculator{" +
                "num=" + num +
                ", num2=" + Operator +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getOperator() {
        return Operator;
    }

    public void setOperator(String Operator) {
        this.Operator = Operator;
    }
}


