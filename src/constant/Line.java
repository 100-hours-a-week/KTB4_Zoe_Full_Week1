package constant;

import domain.character.*;
import domain.character.Character;

import java.util.List;

/**
 * 라인(탱커/원딜) 종류와, 각 라인에 속한 캐릭터 목록을 정의
 */
public enum Line {

    TANKER("1", "탱커", List.of(
            new ChampInfo("1", "말파이트", Malphite::new),
            new ChampInfo("2", "가렌", Garen::new)
    )),
    ADC("2", "원거리 딜러", List.of(
            new ChampInfo("1", "애쉬", Ashe::new),
            new ChampInfo("2", "케이틀린", Caitlyn::new)
    ));

    // Enum 필드는 모두 불변 → final
    private final String number;
    private final String koreanName;
    private final List<ChampInfo> champions;

    Line(String number, String koreanName, List<ChampInfo> champions) {
        this.number = number;
        this.koreanName = koreanName;
        this.champions = champions;
    }

    // 입력값 → constant.Line 변환
    public static Line from(String input) {
        for (Line line : values()) {
            if (line.number.equals(input) || line.koreanName.equals(input)) {
                return line;
            }
        }
        throw new IllegalArgumentException("숫자 또는 선택지 글자만 입력해주세요.");
    }

    // 이 라인 안에서 입력에 맞는 캐릭터를 생성해 반환.
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

    public String getKoreanName() {
        return koreanName;
    }
}