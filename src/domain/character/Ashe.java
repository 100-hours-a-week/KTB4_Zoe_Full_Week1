package domain.character;

import domain.monster.Monster;

import java.util.List;

public class Ashe extends ADC {

    private static final int ULT_MULTIPLIER = 2;

    public Ashe() {
        super("애쉬", 90, 11);
    }

    @Override
    public void useUltimate(List<Monster> monsters) {
        int damage = getAttackDmg() * ULT_MULTIPLIER;
        System.out.printf("궁극기[마법의 수정 화살]! 모든 적에게 %d 데미지!%n", damage);
        for (Monster m : monsters) {
            if (!m.isDead()) {
                m.decreaseHp(damage);
            }
        }
        resetGauge();
    }
}