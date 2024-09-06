package section4.item19;

public class ExtendableClass {
    /**
     * @implSpec
     * 재정의 매서드
     */
    // 재정의를 허용 시킬 메서드는 protected로 지정
    protected void overridableMethod() {
        System.out.println("재정의 가능 메서드");
    }
    private void noneOverridableMethod() {
        System.out.println("재정의 불가능 메서드");
    }


    public ExtendableClass() {
        // 다음과 같이 재정의 가능한 메서드를
        // 생성자 레벨에서 호출하면 안된다.
        // >> 하위 클래스에서 생성자 사용시 부모의 생성자가 자동으로 생성되기 때문에, 재정의된 메소드가 호출 될 가능성 있음
//         overridableMethod();
    }
}
