import java.util.List;
import java.util.function.Supplier;

public enum Line {
    TANKER("1", "탱커", List.of(
            new ChampInfo("1", "말파이트", Malphite::new),
            new ChampInfo("2", "가렌", Garen::new)
    )),
    ADC("2", "원거리 딜러", List.of(
            new ChampInfo("1", "애쉬", Ashe::new),
            new ChampInfo("2", "케이틀린", Caitlyn::new)
    ));

    private final String number;
    private final String koreanName;
    private final List<ChampInfo> champions;  // 라인이 자기 캐릭터 목록을 가짐

    Line(String number, String koreanName, List<ChampInfo> champions) {
        this.number = number;
        this.koreanName = koreanName;
        this.champions = champions;
    }

    public static Line from(String input) {
        for (Line line : values()) { //enum 배열을 돌면서 일치하는게 있는지 확인
            if (line.number.equals(input) || line.koreanName.equals(input)) {
                return line;
            }
        }
        throw new IllegalArgumentException("숫자 또는 선택지 글자만 입력해주세요.");
    }

    // 이 라인 안에서 캐릭터 찾아서 생성
    public Character createCharacter(String input) {
        for (ChampInfo champion : champions) {
            if (champion.matches(input)) {
                return champion.create();
            }
        }
        throw new IllegalArgumentException("없는 캐릭터입니다.");
    }

    public List<ChampInfo> getChampions() {
        return champions;
    }
}