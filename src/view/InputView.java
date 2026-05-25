package view;

import constant.ChampInfo;
import domain.monster.Monster;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String askLine() {
        System.out.println("게임 시작! 가고싶은 라인을 골라주세요");
        System.out.println("1. 탱커     2. 원거리 딜러");
        return scanner.nextLine().trim();
    }

    public void showChampions(List<ChampInfo> champions) {
        System.out.println("캐릭터를 골라주세요.");
        StringBuilder sb = new StringBuilder();
        for (ChampInfo c : champions) {
            sb.append(c.getNumber()).append(". ").append(c.getKoreanName()).append("    ");
        }
        System.out.println(sb.toString().trim());
    }

    public String askChampion() {
        return scanner.nextLine().trim();
    }

    // 턴마다 행동 선택. 1=공격, 2=스킬, 3=궁극기(게이지 충전 시).
    public int askAction(boolean ultReady) {
        while (true) {
            System.out.println("\n무엇을 할까요?");
            System.out.print("1. 공격    2. 스킬");
            System.out.println(ultReady ? "    3. 궁극기 [READY]" : "    (궁극기 게이지 부족)");
            String input = scanner.nextLine().trim();
            if (input.equals("1") || input.equals("2")) return Integer.parseInt(input);
            if (input.equals("3") && ultReady) return 3;
            System.out.println("올바른 행동을 선택해주세요.");
        }
    }

    //공격할 몹 선택
    public int askAttackTarget(List<Monster> monsters) {
        while (true) {
            System.out.print("공격할 몹 번호: ");
            for (int i = 0; i < monsters.size(); i++) {
                if (!monsters.get(i).isDead()) {
                    System.out.printf("[%d:%s] ", i + 1, monsters.get(i).getName());
                }
            }
            System.out.println();
            String input = scanner.nextLine().trim();
            try {
                int idx = Integer.parseInt(input) - 1;
                if (idx >= 0 && idx < monsters.size() && !monsters.get(idx).isDead()) {
                    return idx;
                }
            } catch (NumberFormatException ignored) { }
            System.out.println("올바른 몹 번호를 입력해주세요.");
        }
    }

    public void close() {
        scanner.close();
    }
}