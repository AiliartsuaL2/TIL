package item14.inheritance;

import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 상위 클래스가 Comparable<T>를 구현했는데 하위 클래스의 추가된 필드도 같이 비교하고싶은 경우 1.
 * - Client측에서 new Compartor 사용 -> 비추천
 *
 */
public class NamedPoint extends Point {
    private final String name;

    public NamedPoint(int x, int y,String name) {
        super(x,y);
        this.name = name;
    }

    @Override
    public String toString() {
        return "NamedPoint{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        NamedPoint p1 = new NamedPoint(1, 0, "juho");
        NamedPoint p2 = new NamedPoint(1, 0, "ailiartsua");

        TreeSet<NamedPoint> points = new TreeSet<>(new Comparator<NamedPoint>() {
            @Override
            public int compare(NamedPoint p1, NamedPoint p2) {
                int result = Integer.compare(p1.getX(), p2.getX());
                if(result == 0)
                    result = Integer.compare(p1.getY(),p2.getY());
                if(result == 0)
                    result = p1.name.compareTo(p2.name);
                return result;
            }
        });

        points.add(p1);
        points.add(p2);

        System.out.println(points);
    }
}
