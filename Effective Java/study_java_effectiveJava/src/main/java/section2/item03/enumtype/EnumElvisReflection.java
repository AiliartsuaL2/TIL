package section2.item03.enumtype;


import java.lang.reflect.Constructor;

public class EnumElvisReflection {
    public static void main(String[] args) {
        try{
            Constructor<Elvis> defaultConstructor = Elvis.class.getDeclaredConstructor(); // 생성자가 자동으로 없다고 나옴,, Enum이 막아놔서
            System.out.println("defualt!~" + defaultConstructor);
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }
    }
}
