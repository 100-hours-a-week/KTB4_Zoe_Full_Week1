package constant;

import domain.character.Character;

import java.util.function.Supplier;

/**
 * 캐릭터 한 종류의 메타정보(선택지 번호, 이름, 생성 방법).
 */
public class ChampInfo {

    private final String number;
    private final String koreanName;
    private final Supplier<Character> creator;   // () -> new domain.character.Malphite() 같은 "생성 레시피"

    public ChampInfo(String number, String koreanName, Supplier<domain.character.Character> creator) {
        this.number = number;
        this.koreanName = koreanName;
        this.creator = creator;
    }

    public boolean matches(String input) {
        return number.equals(input) || koreanName.equals(input);
    }

    public domain.character.Character create() {
        return creator.get();   // 이 시점에 비로소 객체 생성
    }

    public String getNumber() {
        return number;
    }

    public String getKoreanName() {
        return koreanName;
    }
}