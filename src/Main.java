import java.util.Objects;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static String ERROR_MESSAGE = "숫자 또는 선택지 글자만 입력해주세요.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 게임 시작
        System.out.println("게임 시작! 가고싶은 라인을 골라주세요");
        System.out.println("1. 탱커     2. 원거리 딜러");
        String line = scanner.nextLine();

        // 2. 캐릭터 선택
        Character selected = selectCharacter(line, scanner);

        // 3. 스탯 출력
        if (selected != null) {
            selected.printStat();
        } else {
            System.out.println(ERROR_MESSAGE);
        }

        scanner.close();
    }

    // 라인별 캐릭터 선택 메서드
    static Character selectCharacter(String line, Scanner scanner) {
        if (line.equals("1") || line.equals("탱커")) {
            System.out.println("캐릭터를 골라주세요.");
            System.out.println("1. 말파이트    2. 가렌");
            String champ = scanner.nextLine();

            if (champ.equals("1")) return new Malphite();
            if (champ.equals("2")) return new Garen();

        } else if (line.equals("2") || line.equals("원거리 딜러")) {
            System.out.println("캐릭터를 골라주세요.");
            System.out.println("1. 애쉬    2. 케이틀린");
            String champ = scanner.nextLine();

            if (champ.equals("1")) return new Ashe();
            if (champ.equals("2")) return new Caitlyn();
        } else {
            System.out.println(ERROR_MESSAGE);
        }

        return null;
    }
}