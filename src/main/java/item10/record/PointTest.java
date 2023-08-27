package item10.record;

public class PointTest {
    public static void main(String[] args) {
        Point p1 = new Point(1, 0);
        // 해당 p1,p2 객체는 record를 통해서 생성된 인스턴스로, 파라미터로 변수들만 설정해두면 equals , toString 등을 알아서 재정의해준다.
        // java 17버전에서 Value Based Class를 만든다면 record를 만들면 됨.
        Point p2 = new Point(1, 0);
        System.out.println(p1.equals(p2));
        System.out.println("p1 = " + p1);


        // setter가 없고, getter는 간단하게 하기와 같다.
        System.out.println(p1.x());
    }
}
