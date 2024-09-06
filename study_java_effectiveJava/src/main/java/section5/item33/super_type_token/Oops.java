package section5.item33.super_type_token;

import java.util.ArrayList;
import java.util.List;

public class Oops {
    static Favorite2 f = new Favorite2();

    static <T> List<T> favoirteList() {
        TypeRef<List<T>> ref = new TypeRef<>() {};

        List<T> result = f.get(ref);

        if (result == null) {
            result = new ArrayList<T>();
            f.put(ref, result);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = favoirteList();
        List<Integer> li = favoirteList();
        li.add(1);

        for (String s : ls) {
            System.out.println(s);
        }
    }
}
