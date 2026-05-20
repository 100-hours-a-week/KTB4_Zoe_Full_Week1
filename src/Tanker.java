public abstract class Tanker extends Character{
    private int shield;

    public void stun() {
        System.out.println("스턴 스킬 사용!");
    }

    @Override
    public void printStat() {
        super.printStat();
        System.out.println("쉴드:" + shield);
    }

    public Tanker(String name, int hp, int attackDmg) {
        super(name,hp,attackDmg); // 부모생성자호출
        shield = 30;
    }
}
