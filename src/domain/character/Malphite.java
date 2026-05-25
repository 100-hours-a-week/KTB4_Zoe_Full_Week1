package domain.character;

import domain.monster.Monster;

import java.util.List;

public class Malphite extends Tanker {

    private static final int AOE_DAMAGE = 15;
    private static final int SELF_HEAL = 10;

    public Malphite() {
        super("말파이트", 100, 6);
    }

    @Override
    public void useUltimate(List<Monster> monsters) {
        System.out.printf("궁극기[지진]! 모든 적에게 %d 데미지 + 체력 %d 회복!%n",
                AOE_DAMAGE, SELF_HEAL);
        for (Monster m : monsters) {
            if (!m.isDead()) {
                m.decreaseHp(AOE_DAMAGE);
            }
        }
        increaseHp(SELF_HEAL);
        resetGauge();
    }
}