package domain.monster;

import domain.character.Character;

public class Monster implements Runnable {

    private final String name;
    private final int attackDmg;     // 몹의 공격력: 고정 → final
    private final domain.character.Character target;   // 플레이어

    private int hp;                   // 몹의 체력: 변함 → final 아님
    private boolean stunned;          // 기절 상태: 스턴 시 , 그 턴 반격 못 함


    public Monster(String name, int hp, int attackDmg, Character target) {
        this.name = name;
        this.hp = hp;
        this.attackDmg = attackDmg;
        this.target = target;
    }

    @Override
    public void run() {
        if (isDead()) {
            return;   // 죽은 몹은 반격하지 않음
        }
        target.decreaseHp(attackDmg);
        System.out.printf("  → %s(이)가 %s에게 %d 데미지로 반격!%n",
                name, target.getName(), attackDmg);
    }

    // 기절 상태로 만든다.
    public void stun() {
        this.stunned = true;
    }

    // 턴 종료 시 기절 해제
    public void wakeUp() {
        this.stunned = false;
    }

    public void decreaseHp(int damage) {
        hp = Math.max(hp - damage, 0);
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackDmg() {
        return attackDmg;
    }
}