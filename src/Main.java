public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        try {
            Line line = Line.from(inputView.askLine());

            // 선택한 라인의 캐릭터 목록을 보여주고
            inputView.showChampions(line.getChampions());
            String championInput = inputView.askChampion();

            // 그 라인 안에서 캐릭터 생성
            Character selected = line.createCharacter(championInput);

            selected.printStat();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            inputView.close();
        }
    }
}