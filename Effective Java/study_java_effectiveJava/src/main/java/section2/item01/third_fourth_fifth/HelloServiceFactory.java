package section2.item01.third_fourth_fifth;

import java.util.Optional;
import java.util.ServiceLoader;

public class HelloServiceFactory {
    public static void main(String[] args) {
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class); // HelloService.class의 모든 구현체를 가져와서 ServiceLoader에 넣음(iterator).
        Optional<HelloService> helloServiceOptional = loader.findFirst(); // nullable한 Optional 타입에 받음
        helloServiceOptional.ifPresent(h -> {
            System.out.println(h.hello());
        }); // 구현체가 어떤게 올 지 모르지만, 해당 구현체가 따르는 인터페이스 기반의 코딩을 한 것. (굉장한 유연함을 제공,, 구현체에대한 의존성이 생기지 않으니까)



    }

}
