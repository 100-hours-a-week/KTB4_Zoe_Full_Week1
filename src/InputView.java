import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String askLine() {
        System.out.println("게임 시작! 가고싶은 라인을 골라주세요");
        System.out.println("1. 탱커     2. 원거리 딜러");
        return scanner.nextLine();
    }

    // 캐릭터 목록을 받아서 동적으로 출력
    public void showChampions(List<ChampInfo> champions) {
        System.out.println("캐릭터를 골라주세요.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < champions.size(); i++) {
            sb.append(i + 1).append(". ").append(champions.get(i).getKoreanName()).append("    ");
        }
        System.out.println(sb.toString().trim());
    }

    public String askChampion() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}