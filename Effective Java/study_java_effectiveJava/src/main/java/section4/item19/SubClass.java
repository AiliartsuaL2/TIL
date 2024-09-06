package section4.item19;

public final class SubClass extends ExtendableClass{
    @Override
    public void overridableMethod() {
        System.out.println("재정의 완료 !");
    }

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        // 만약 상위 클래스에서 생성자에 재정의한 메서드가 있다면
        // 이렇게 객체 생성만 해도 override된 메서드가 호출됨
    }
}
