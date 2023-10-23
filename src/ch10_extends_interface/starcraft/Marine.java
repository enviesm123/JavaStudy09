package ch10_extends_interface.starcraft;

public class Marine extends StarUnit{


    public Marine() {
        super("마린", 6, 50, 0, 4, 1, 1, 50);
    }

    // 공격
    public void attack(StarUnit starUnit){
        // 질럿의 체력이 마린의 공격력만큼 감소
        // 부모 필드에 private인 변수나 메소드는 자식 객체에서 사용 불
        starUnit.setHp(starUnit.getHp() - this.getDamage());
    }


    // 스팀팩
    public void stimpack(){
        System.out.println("으아아아!!!");
        // 스팀팩을 쓰면 체력이 10 감소, 공격속도 두배
//        this.hp -= 10;
        this.setHp(this.getHp() - 10);
//        this.attackSpeed *= 2;
        this.setAttackSpeed(this.getAttackSpeed() * 2);
    }




    @Override
    public String toString() {
        return "Marine{" +
                "name='" + this.getName() + '\'' +
                ", damage=" + getDamage() +
                ", hp=" + super.getHp() +
                ", armor=" + getArmor() +
                ", attackRange=" + getAttackRange() +
                ", attackSpeed=" + getAttackSpeed() +
                ", moveSpeed=" + getMoveSpeed() +
                ", mineral=" + getMineral() +
                '}';
    }

}
