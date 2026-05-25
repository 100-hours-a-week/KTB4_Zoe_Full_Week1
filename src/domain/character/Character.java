package domain.character;

import domain.monster.Monster;

import java.util.List;


public abstract class Character {

    private final String name;        // 이름: 불변 → final
    private final int maxHp;          // 최대 체력: 불변 → final
    private final int attackDmg;      // 공격력: 불변 → final

    private int hp;                   // 현재 체력: 변동
    private int ultGauge;             // 궁극기 게이지(0~100): 변동
    private boolean dodging;          // 회피 상태: 카이팅 또는 도발 시 true

    private static final int ULT_MAX = 100;       // 게이지 최대치
    private static final int GAUGE_PER_ATTACK = 25;  // 공격당 충전량

    protected Character(String name, int hp, int attackDmg) {
        this.name = name;
        this.maxHp = hp;
        this.attackDmg = attackDmg;
        this.hp = hp;
        this.ultGauge = 0;
        this.dodging = false;
    }


    public abstract void useUltimate(List<Monster> monsters);

    public abstract boolean useSkill();

    public void attack() {
        System.out.printf("%s의 평타 공격! %d 데미지%n", name, attackDmg);
    }

    /* ---------- 궁극기 게이지 ---------- */

    /** 공격 시 게이지 충전. (단일 스레드=사용자만 호출 → 동기화 불필요) */
    public void chargeGauge() {
        ultGauge = Math.min(ultGauge + GAUGE_PER_ATTACK, ULT_MAX);
    }

    public boolean canUseUltimate() {
        return ultGauge >= ULT_MAX;
    }

    /** 궁극기 사용 후 게이지 소모. */
    protected void resetGauge() {
        ultGauge = 0;
    }

    public int getUltGauge() {
        return ultGauge;
    }

    /* ---------- 체력 (동기화 대상) ---------- */


     // 몹 두 개의 스레드가 동시에 호출하고 경쟁 상태가 일어나기 때문에 임계영억으로 묶음
     public synchronized void decreaseHp(int damage) {
         if (hp <= 0) return;
         if (dodging) {
             // "다음 한 턴의 반격 전체 회피" → 플래그를 끄지 않고 데미지만 무효화.
             System.out.printf("  → %s 회피! %d 데미지를 막았다%n", name, damage);
             return;
         }
         hp = Math.max(hp - damage, 0);
     }

    /** 카이팅 등으로 회피 상태를 켠다. */
    public synchronized void activateDodge() {
        dodging = true;
    }

    /** 턴 종료 시 회피 상태를 해제한다. (다음 턴엔 다시 맞음) */
    public synchronized void endTurn() {
        dodging = false;
    }

    public synchronized boolean isDodging() {
        return dodging;
    }


    //궁극기 회복도 hp를 건드리므로 동일 락으로 보호.
    public synchronized void increaseHp(int amount) {
        hp = Math.min(hp + amount, maxHp);
    }

    public synchronized int getHp() {
        return hp;
    }

    public boolean isDead() {
        return getHp() <= 0;
    }

    /* ---------- getter ---------- */

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getAttackDmg() {
        return attackDmg;
    }

    public void printStat() {
        System.out.printf("[%s] 체력: %d/%d, 공격력: %d, 궁극기: %d%%%n",
                name, getHp(), maxHp, attackDmg, ultGauge);
    }
}