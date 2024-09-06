package section4.item20.multipleinheritance;

public class MyCat extends AbstractCat implements Flyable{

    private MyFlyAble myFlyAble = new MyFlyAble();

    @Override
    protected String sound() {
        return "인싸 고양이 두마리가 나가신다!.";
    }

    @Override
    protected String name() {
        return "유미";
    }

    public static void main(String[] args) {
        MyCat myCat = new MyCat();
        System.out.println(myCat.name());
        System.out.println(myCat.sound());
    }

    @Override
    public void fly() {
        // 컴포지션으로 상속 흉내를 낸 인스턴스에 위임
        this.myFlyAble.fly();
    }

    // 다중 상속처럼 활용 가능
    private class MyFlyAble extends AbstractFlyable {
        @Override
        public void fly() {
            System.out.println("날아라");
        }
    }
}
