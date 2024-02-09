package section5.item28.erasure;

import java.util.ArrayList;
import java.util.List;

public class MyGeneric {
    public static void main(String[] args) {
        // 실체화 x 컴파일 이후 -> Type이 사라진다
//        List<String> names = new ArrayList<>();
//        names.add("ailiartsua");
//        String name = names.get(0);
//        System.out.println(name);

        // 제네릭은 출시 기준 하위 버전과의 호환성 때문에 실체화 되지 않는다.
        // 제네릭은 실체화되지 않기 때문에 위 코드가 런타임 시점에서 아래와 같이 변한다.
        List names = new ArrayList();
        names.add("ailiartsua");
        Object o = names.get(0);
        String name = (String) o;
        System.out.println(name);
    }
}
