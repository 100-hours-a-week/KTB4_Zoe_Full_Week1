public abstract class Character {
    private final String name; //이름은 바뀌지 않으므로 final로 선언
    private int hp;
    private int attackDmg;


    public void attack() {
        System.out.print("평타 공격! :" +attackDmg + "의 데미지");
    }

    public void printStat() {
        System.out.println("이름:" + name);
        System.out.println("체력:" + hp);
        System.out.println("평타 데미지:" + attackDmg);
    }

    public Character() {
        hp = 70;
        attackDmg = 5;
    //getter, setter 함수들
    public void setAttackDmg(int attackDmg) {
        this.attackDmg = attackDmg;
    }

    public int getAttackDmg() {
        return attackDmg;
    }

    public String getName() {
        return name;
    }

    public void increaseHp(int num) {  // 체력 증가 메서드
        this.hp = this.hp + num;
    }

    public void decreaseHp(int num) { // 체력 감소 메서드
        this.hp = this.hp - num;
    }

    public int getHp() {
        return hp;
    }



    }
}
