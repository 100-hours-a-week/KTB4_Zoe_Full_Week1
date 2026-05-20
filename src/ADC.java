public abstract class ADC extends Character {
    private int criticalAttack;

    public void kite() {
        System.out.println("카이팅하기!");
    };

    public int getCriticalAttack() {
        return criticalAttack;
    }


    @Override
    public void printStat() {
        super.printStat();
        System.out.println("치명타 데미지:" + criticalAttack);
    }

    public ADC() {
        super();
        attackDmg = attackDmg + 3;
        criticalAttack = 12;
    }

}
