package domain.monster;

import domain.character.Character;

public class Monster implements Runnable {

    private final String name;
    private final int attackDmg;     // 몹의 공격력: 고정 → final
    private final domain.character.Character target;   // 플레이어

    private int hp;
    private boolean dodging;


    public Monster(String name, int hp, int attackDmg, Character target) {
        this.name = name;
        this.hp = hp;
        this.attackDmg = attackDmg;
        this.target = target;
    }

    @Override
    public void run() {
        if (isDead() || isDodging()) {
            return;
        }
        target.decreaseHp(attackDmg);
        System.out.printf("  → %s(이)가 %s에게 %d 데미지로 반격!%n",
                name, target.getName(), attackDmg);
    }

    public void activateDodge() {
        this.dodging = true;
    }

    public void endTurn() {
        this.dodging = false;
    }

    public boolean isDodging() {
        return dodging;
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