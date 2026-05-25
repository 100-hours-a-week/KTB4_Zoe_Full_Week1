package domain.character;

import domain.monster.Monster;

import java.util.List;

public abstract class Tanker extends Character {

    private final int shield;   // 쉴드: 탱커 고유 스탯

    protected Tanker(String name, int hp, int attackDmg) {
        super(name, hp + 60, attackDmg + 3);
        this.shield = 30;
    }


    @Override
    public void useSkill(List<Monster> monsters) {
        System.out.printf("%s 스턴 스킬 사용! 적을 잠시 기절시킨다%n", getName());
        for (Monster m : monsters) {
            if (!m.isDead()) {
                m.activateDodge();
            }
        }
    }

    public int getShield() {
        return shield;
    }

    @Override
    public void printStat() {
        super.printStat();                      // 부모의 공통 스탯 먼저 출력
        System.out.println("  쉴드: " + shield); // 탱커 고유 스탯 추가
    }
}