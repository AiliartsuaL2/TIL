package section5.item33.super_type_token;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTypeInfer {
    static class Super<T> {
        T value;
    }

    // 상속을 사용하면 하위 타입 클래스로 조회가 가능하다.
//    static class Sub extends Super<String> {
//
//    }

    public static void main(String[] args) throws NoSuchFieldException {
        Super<String> stringSuper = new Super<>();
        stringSuper.value = "ailiartsua";
        // Runtime에는 제네릭 클래스를 알 수 없음.
        Class<?> value = stringSuper.getClass().getDeclaredField("value").getType();
        System.out.println(value);

//        Sub sub = new Sub();
//        Type genericSuperclass = Sub.class.getGenericSuperclass();

        // 굳이 클래스를 정의하지않고 익명 클래스를 통해서 사용 가능
        Type genericSuperclass = (new Super<String>(){}).getClass().getGenericSuperclass();

        ParameterizedType pType = (ParameterizedType) genericSuperclass;
        // 제네릭에 선언되어있는 클래스 type Arguments(배열)
        Type actualTypeArgument = pType.getActualTypeArguments()[0];
        System.out.println(actualTypeArgument);
    }
}
