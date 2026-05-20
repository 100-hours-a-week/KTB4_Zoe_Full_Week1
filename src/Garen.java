public class Garen extends Tanker{
    @Override
    public void useUltimate(){
        System.out.println("궁극기 사용: ");
    }

    public Garen() {
        super("가렌", 150, 6);
    }
}

