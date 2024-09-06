package section5.item33.type_token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SafetyFavorites {
    // 이종 컨테이너를 만들어 다른 데이터도 담을 수 있도록 함
    private Map<Class<?>, Object> map = new HashMap<>();

    // 메서드 레벨에서 제네릭으로 정의
    public <T> void put(Class<T> clazz, T value) {
        this.map.put(Objects.requireNonNull(clazz), clazz.cast(value));
    }

    // 검사를 하지않고 형변환을 했기 때문에 unchecked Warning이 뜸
//    @SuppressWarnings("unchecked")
//    public <T> T get(Class<T> clazz) {
//        return (T) this.map.get(clazz);
//    }

    // 이러면 검사를 하고 Warning 미발생 -> 타입 안정
    public <T> T get(Class<T> clazz) {
        return clazz.cast(this.map.get(clazz));
    }

    public static void main(String[] args) {
        SafetyFavorites favorites = new SafetyFavorites();

        // 단점 1. 사용하는쪽에서 Raw Type으로 변경해버리면 문자열이 아님에도 넣을 수 있음
        // -> put 메서드에 검증을 추가한다. (컴파일 단계에서는 찾을 순 없지만, 더 빠르게 예외를 추가 할 순 있음)
        // favorites.put((Class)String.class, 1);

        // 단점 2. 제네릭 클래스를 꺼내오는 방법이 없다.
        // -> super 타입 토큰 이용
//        favorites.put(List<Integer>.class, List.of(1, 2, 3));
//        favorites.put(List<String>.class, List.of("a", "b", "c"));

        List list = favorites.get(List.class);
        list.forEach(System.out::println);

        favorites.put(String.class, "이주호");
        String s = favorites.get(String.class);
        System.out.println(s);
    }
}
