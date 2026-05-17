public class ADC extends Character {
    protected int criticalAttack;

    public void kite() {
        System.out.println("카이팅하기!");
    };

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
