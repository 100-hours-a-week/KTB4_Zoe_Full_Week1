public class Malphite extends Tanker{

    @Override
    public void useUltimate() {
        System.out.println("궁극기 사용! : 박치기!!");
    }

    public Malphite() {
        super("말파이트",130,8);
    }
}
