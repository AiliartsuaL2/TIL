package section4.item21;

public class SubClass extends SuperClass implements MarkerInterface{
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        // SuperClass에 hello가 있는데, private 제어자로 되어있고, MarkerInterface에는 default 메서드로 선언되어있음
        // 이러면 MarkerInterface의 hello만 호출되어야하나, class > interface 규칙 때문에 버그적으로 호출이 된다.
        // 만약 default method가 없었다면 compile error가 발생했었겠지만, default method가 동일한 시그니쳐로 있기 때문에 Runtime error가 발생
        subClass.hello();
    }
}
