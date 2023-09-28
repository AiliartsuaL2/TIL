package item14.inheritance;

/**
 * equals규약 > 상속을 하여 필드가 추가되는 경우 equals 규약이 깨지기 때문에
 * Composition (상속을 하지 않고 상위 클래스를 필드에 담아줌)
 */
public class ThreeGraphPoint implements Comparable<ThreeGraphPoint>{
    private final Point point;
    private final int z;

    public ThreeGraphPoint(Point point, int z) {
        this.point = point;
        this.z = z;
    }

    // Composition의 View 제공
    public Point getPoint(){
        return this.point;
    }

    @Override
    public int compareTo(ThreeGraphPoint threeGraphPoint) {
        int result = this.point.compareTo(threeGraphPoint.point);
        if(result == 0)
            result = Integer.compare(this.z,threeGraphPoint.z);
        return result;
    }
}
