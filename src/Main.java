import battle.Battle;
import constant.Line;
import domain.character.Character;
import view.InputView;
import view.OutputView;


public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        try {
            // 1. 캐릭터 선택 (1주차 기능)
            Line line = Line.from(inputView.askLine());
            inputView.showChampions(line.getChampions());
            Character selected = line.createCharacter(inputView.askChampion());

            System.out.println("\n선택한 캐릭터:");
            selected.printStat();

            // 2. 전투 시작 (2주차 비동기 기능)
            Battle battle = new Battle(selected, inputView, outputView);
            battle.start();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            inputView.close();
        }
    }
}