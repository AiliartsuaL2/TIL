package section4.item16.method;

// 접근자와 변경자(mutator) 메서드를 활용해 데이터를 캡슐화 한다.
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        // 부가 작업(데이터 가공 등 ..)
        return x;
    }

    public void setX(double x) {
        // 부가 작업(데이터 검증 등 ..)
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
