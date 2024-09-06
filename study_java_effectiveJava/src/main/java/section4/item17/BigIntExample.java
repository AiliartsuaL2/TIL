package section4.item17;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import section3.item10.Point;

public class BigIntExample {
    public static void main(String[] args) {
        BigInteger ten = BigInteger.TEN;
        // 크기는 그대로 가되, 음수 -> 양수로, 양수 -> 음수로 변경
        BigInteger minusTen = ten.negate();


        final Set<Point> points  = new HashSet<>();
        Point firstPoint = new Point(1, 2);
        points.add(firstPoint);
        // Set 내부의 값인 firstPoint의 필드를 바꾸면 points Set은 불변이 아니게됨..!!
//        firstPoint.x = 10;


    }
}
