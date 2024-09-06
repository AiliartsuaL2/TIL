package section5.item27.unchecked;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        // 로타입 사용시, unchecked Warnings 발생
        Set names = new HashSet();
        Set<String> strings = new HashSet();

    }
}
