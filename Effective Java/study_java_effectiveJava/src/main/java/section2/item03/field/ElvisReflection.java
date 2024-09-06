package section2.item03.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ElvisReflection {
    public static void main(String[] args) {
        try {
            Constructor<Elvis> defaultConstructor = Elvis.class.getDeclaredConstructor();
            defaultConstructor.setAccessible(true); // private 생성자이므로 접근하기위해 setAccessible 설정,,
            Elvis elvis1 = defaultConstructor.newInstance();
            Elvis elvis2 = defaultConstructor.newInstance();
            System.out.println(elvis1 == elvis2); // false가 나옴 ,, 싱글톤으로 생성했는데 Reflection 사용시 둘이 다른 인스턴스임
        }catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalArgumentException  | IllegalAccessException e){
            e.printStackTrace();
        }

    }
}
