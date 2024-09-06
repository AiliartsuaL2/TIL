package section5.item33.type_token;

import java.util.HashMap;
import java.util.Map;

public class Favorites {

    // 이종 컨테이너를 만들어 다른 데이터도 담을 수 있도록 함
    private Map<Class, Object> map = new HashMap<>();

    public void put(Class clazz, Object value) {
        this.map.put(clazz, value);
    }

    public Object get(Class clazz) {
        return this.map.get(clazz);
    }

    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        // 안전하지 않음
        favorites.put(String.class, 1);
        favorites.put(String.class, "이주호");
    }
}
