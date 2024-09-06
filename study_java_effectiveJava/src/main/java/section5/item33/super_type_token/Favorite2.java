package section5.item33.super_type_token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Favorite2 {
    private final Map<TypeRef<?>, Object> favorites = new HashMap<>();

    public <T> void put(TypeRef<T> typeRef, T thing) {
        favorites.put(typeRef, thing);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(TypeRef<T> typeRef) {
        // unchecked exception 발생
        return (T)(favorites.get(typeRef));
    }

    public static void main(String[] args) {
        Favorite2 favorite2 = new Favorite2();
        favorite2.put(new TypeRef<List<String>>() {}, List.of("a","b","c"));
        favorite2.put(new TypeRef<List<Integer>>() {}, List.of(1,2,3));
        favorite2.get(new TypeRef<List<String>>() {}).forEach(System.out::println);
        favorite2.get(new TypeRef<List<Integer>>() {}).forEach(System.out::println);
    }
}
