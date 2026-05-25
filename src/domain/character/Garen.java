package domain.character;

import domain.monster.Monster;

import java.util.List;

public class Garen extends Tanker {

    private static final int EXECUTE_DAMAGE = 35;
    private static final int SELF_HEAL = 10;

    public Garen() {
        super("가렌", 90, 8);
    }

    @Override
    public void useUltimate(List<Monster> monsters) {
        Monster target = findStrongest(monsters);
        if (target == null) return;
        System.out.printf("궁극기[데마시아의 정의]! %s에게 %d 데미지 + 체력 %d 회복!%n",
                target.getName(), EXECUTE_DAMAGE, SELF_HEAL);
        target.decreaseHp(EXECUTE_DAMAGE);
        increaseHp(SELF_HEAL);
        resetGauge();
    }

    private Monster findStrongest(List<Monster> monsters) {
        Monster strongest = null;
        for (Monster m : monsters) {
            if (!m.isDead() && (strongest == null || m.getHp() > strongest.getHp())) {
                strongest = m;
            }
        }
        return strongest;
    }
}