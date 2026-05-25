package domain.character;

import domain.monster.Monster;

import java.util.List;

public class Caitlyn extends ADC {

    private static final int ULT_MULTIPLIER = 3;   // 평타의 3배

    public Caitlyn() {
        super("케이틀린", 95, 10);
    }

    @Override
    public void useUltimate(List<Monster> monsters) {
        Monster target = findFirstAlive(monsters);
        if (target == null) return;
        int damage = getAttackDmg() * ULT_MULTIPLIER + getCriticalAttack();
        target.decreaseHp(damage);
        System.out.printf("궁극기[헤드샷]! %s에게 %d 데미지!%n", target.getName(), damage);
        resetGauge();
    }

    private Monster findFirstAlive(List<Monster> monsters) {
        for (Monster m : monsters) {
            if (!m.isDead()) return m;
        }
        return null;
    }
}