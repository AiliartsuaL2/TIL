package section4.item16.field;

// package-private 이나 inner class의 경우에는 필드를 public으로 열어도 괜찮다. >> 백기선 선생님은 메서드로 접근하는게 좋다고 하심.(부가작업 등 관련해서)
class Point {
    // Public class의 필드는 반드시 public이 아닌 getter을 사용해라!!
    public double x;
    public double y;

    public static void main(String[] args) {
        Point point = new Point();
        // 필드에 직접 할당공
        //   - 캡슐화의 장점을 제공하지 못한다.
        point.x = 10;
        point.y = 20;

        // 이런식으로 메서드를 만들어서 체크하는 로직이 필요하긴 함
        doSomething(point);

        System.out.println(point.x);
        System.out.println(point.y);
    }
    private static void doSomething(Point point){
        Point localPoint = new Point();
        localPoint.x = point.x;
        localPoint.y = point.y;
    }
}
