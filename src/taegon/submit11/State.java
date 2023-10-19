package taegon.submit11;

public class State {
    private String name;                /* 캐릭터이름 */
    private String job;                 /* 캐릭터직업 */
    private int level;                  /* 캐릭터레벨 */
    private int exp;                    /* 캐릭터경험치 */
    private int attack;                 /* 공격력 */
    private int hp;                     /* 체력 */
    private boolean isLive;             /* 사망여부 */
    private  int gold;                  /* 보유 골드 */

    public State() {
    }

    public State(String name, String job) {
        this.name = name;
        level = 1;
        exp = 0;
        attack = 10;
        hp = 100;
        isLive = false;
        gold = 100;
        if(job.equals("1")){
            this.job = "전사";
        }else if(job.equals("2")){
            this.job = "궁수";
        }else if(job.equals("3")){
            this.job = "마법사";
        }else{
            System.out.println("잘못 입력 하셨습니다.");
        }
    }

    public State(String name, String job, int level, int exp, int attack, int hp, boolean isLive) {
        this.name = name;
        this.job = job;
        this.level = level;
        this.exp = exp;
        this.attack = attack;
        this.hp = hp;
        this.isLive = isLive;
        this.gold = gold;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", level=" + level +
                ", exp=" + exp +
                ", attack=" + attack +
                ", hp=" + hp +
                ", isLive=" + isLive +
                ", gold=" + gold +
                '}';
    }

    public boolean isLive() {
        return isLive;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
