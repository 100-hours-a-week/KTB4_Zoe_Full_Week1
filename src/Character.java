public class Character {
    protected String name;
    protected int hp;
    protected int attackDmg;

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
    }
}
