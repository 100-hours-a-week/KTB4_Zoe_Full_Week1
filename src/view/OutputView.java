package view;

import domain.monster.Monster;

import domain.character.Character;


import java.util.List;


public class OutputView {

    public void printBattleStart(int monsterCount) {
        System.out.println("\n=== 전투 시작! 몹 " + monsterCount + "마리를 처치하세요 ===");
    }

    public void printStatus(Character player, List<Monster> monsters) {
        System.out.println("\n------------------------------");
        player.printStat();
        for (Monster m : monsters) {
            System.out.printf("[%s] %s%n",
                    m.getName(), m.isDead() ? "쓰러짐" : m.getHp() + " HP");
        }
        System.out.println("------------------------------");
    }

    public void printPlayerAttack(String playerName, String targetName, int damage) {
        System.out.printf("%s가 %s에게 %d 데미지!%n", playerName, targetName, damage);
    }

    public void printMonsterDefeated(String monsterName) {
        System.out.printf("** %s 처치! **%n", monsterName);
    }

    public void printCounterattackStart() {
        System.out.println("-- 몹들의 반격 --");
    }

    public void printResult(boolean playerDead) {
        System.out.println("\n==============================");
        System.out.println(playerDead ? "패배... 캐릭터가 쓰러졌습니다."
                : "승리! 모든 몹을 처치했습니다!");
        System.out.println("==============================");
    }
}