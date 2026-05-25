package battle;

import domain.monster.Monster;
import domain.character.Character;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class Battle {

    private static final int MONSTER_COUNT = 2;
    private static final int MONSTER_HP = 40;
    private static final int MONSTER_ATTACK = 8;
    private static final long COUNTER_TIMEOUT_MS = 2000L;

    private final Character player;
    private final List<Monster> monsters;
    private final InputView inputView;
    private final OutputView outputView;

    public Battle(Character player, InputView inputView, OutputView outputView) {
        this.player = player;
        this.inputView = inputView;
        this.outputView = outputView;
        this.monsters = createMonsters(player);
    }

    private List<Monster> createMonsters(Character target) {
        List<Monster> result = new ArrayList<>();
        for (int i = 1; i <= MONSTER_COUNT; i++) {
            result.add(new Monster("몹" + i, MONSTER_HP, MONSTER_ATTACK, target));
        }
        return result;
    }

    public void start() {
        outputView.printBattleStart(MONSTER_COUNT);
        while (!isGameOver()) {
            outputView.printStatus(player, monsters);
            boolean acted = playerTurn();
            if (acted && !allMonstersDead()) {
                counterattack();
            }
        }
        outputView.printResult(player.isDead());
    }

    private boolean playerTurn() {
        int action = inputView.askAction(player.canUseUltimate());
        switch (action) {
            case 1:
                int idx = inputView.askAttackTarget(monsters);
                attackMonster(idx);
                player.chargeGauge();
                return true;
            case 2:
                player.useSkill(monsters);
                return true;
            case 3:
                player.useUltimate(monsters);
                reportMonsterDeaths();
                return true;
            default:
                return false;
        }
    }

    private void attackMonster(int idx) {
        Monster target = monsters.get(idx);
        target.decreaseHp(player.getAttackDmg());
        outputView.printPlayerAttack(player.getName(), target.getName(), player.getAttackDmg());
        if (target.isDead()) {
            outputView.printMonsterDefeated(target.getName());
        }
    }

    private void reportMonsterDeaths() {
        for (Monster m : monsters) {
            if (m.isDead()) {
                outputView.printMonsterDefeated(m.getName());
            }
        }
    }

    private void counterattack() {
        outputView.printCounterattackStart();
        List<Thread> threads = new ArrayList<>();
        for (Monster m : monsters) {
            if (!m.isDead()) {
                Thread t = new Thread(m);
                threads.add(t);
                t.start();
            }
        }
        for (Thread t : threads) {
            try {
                t.join(COUNTER_TIMEOUT_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        player.endTurn();
        for (Monster m : monsters) {
            m.endTurn();
        }
    }

    private boolean isGameOver() {
        return player.isDead() || allMonstersDead();
    }

    private boolean allMonstersDead() {
        return monsters.stream().allMatch(Monster::isDead);
    }
}