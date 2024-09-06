package section4.item23.taggedclass;

class Figure {
    enum Shape { RECTANGLE, CIRCLE};

    final Shape shape;

    // 해당 필드들은 모양이 사각형(RECTANGLE) 일때만 쓰임
    double length;
    double width;

    // 해당 필드들은 모양이 원일때만 쓰임
    double radius;

    // 원 용 생성자
    public Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // 사각형용 생성자
    public Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE :
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}
