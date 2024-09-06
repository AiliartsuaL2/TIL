package section2.item06;

import java.util.regex.Pattern;

public class RegularExpression {
    // Pattern을 정적 초기화 과정에서 만들어 캐싱해서 사용한다.
    private static final Pattern SPLIT_PATTERN = Pattern.compile(";;;");

    public static void main(String[] args) {
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            String name = "lee;;;juho";
            // split은 내부적으로 1개 인 경우에는 그냥 사용하는게 더 빠르지만, 아닌경우 정적 초기화 과정에서 초기화 후 캐싱해서 사용해주는게 좋다.
            name.split(";;;");
//            SPLIT_PATTERN.split(name);
        }
        System.out.println(System.nanoTime()-start);
    }
}
