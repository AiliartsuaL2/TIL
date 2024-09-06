package section3.item13;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("ailiartsua");
        hashSet.add("LeeJuho");
        System.out.println("hashSet = " + hashSet);

        // TreeSet의 생성자 구현을 보면, Collection으로 받기 때문에, 구현체가 달라도 변환 생성자의 파라미터로 사용이 가능하다.
        // 변환 생성자, 변환 팩토리 메서드 사용시 인터페이스 타입으로 받을 수 있다.
        Set<String> treeSet = new TreeSet<>(hashSet);
        System.out.println("treeSet = " + treeSet);
    }
}
