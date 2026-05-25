package domain.character;

public abstract class ADC extends Character {

    private final int criticalAttack;   // 치명타 데미지: 불변 → final

    protected ADC(String name, int hp, int attackDmg) {
        super(name, hp, attackDmg);
        this.criticalAttack = 12;
    }

    @Override
    public boolean useSkill() {
        activateDodge();
        System.out.printf("%s 카이팅! 다음 반격 회피 태세%n", getName());
        return false;
    }

    public int getCriticalAttack() {
        return criticalAttack;
    }

    @Override
    public void printStat() {
        super.printStat();
        System.out.println("  치명타 데미지: " + criticalAttack);
    }
}