package section4.item25;

// 톱 레벨 클래스들을 정적 멤버 클래스로 변경한 모습
// -> 가독성 증가, private 접근 지시자를 통해 해당 클래스에 접근 범위도 제한 할 수 있음
public class Exchange {
    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
    }

    private static class Utensil {
        static final String NAME = "pan";
    }

    private static class Dessert {
        static final String NAME = "cake";
    }
}
