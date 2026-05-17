public class Tanker extends Character{
    protected int shield;

    public void stun() {
        System.out.println("스턴 스킬 사용!");
    }

    @Override
    public void printStat() {
        super.printStat();
        System.out.println("쉴드:" + shield);
    }

    public Tanker() {
        super(); // 부모생성자호출
        hp = hp + 60; //탱커는 기본 스탯보다 체력이 높음
        shield = 30;
    }
}
