package item10.record;

// 이렇게 설정만 해놓으면 필드에 자동으로 equals, hashCode, toString 등을 자동 구현
// java17 버전에서 Value Based Class를 만들기에 적절함.
public record Point(int x, int y) {
    public void hello(){
        System.out.println("hello");
    }
}
