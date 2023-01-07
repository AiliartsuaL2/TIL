package item01.third_fourth_fifth;

public interface HelloService {

    String hello();

    static HelloService of(String lang){ // 인터페이스는 public 접근 지정자가 default
        if(lang.equals("ko")){
            return new KoreanHelloService(); // 리턴타입이 인터페이스인데. 정적 팩터리 메서드의 구현체로 하위 타입의 클래스인 KoreanHelloService() 리턴 가능
        }else{
            return new EnglishHelloService(); // 위와 마찬가지
        }
    }

}
