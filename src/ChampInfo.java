import java.util.function.Supplier;

public class ChampInfo {
    private final String number;
    private final String koreanName;
    private final Supplier<Character> creator;  // 생성 함수를 들고 있음

    public ChampInfo(String number, String koreanName, Supplier<Character> creator) {
        this.number = number;
        this.koreanName = koreanName;
        this.creator = creator;
    }

    public boolean matches(String input) {
        return number.equals(input) || koreanName.equals(input);
    }

    public Character create() {
        return creator.get();  // 저장해둔 생성 함수 실행
    }

    public String getKoreanName() {
        return koreanName;
    }
}