package section2.item01.strategy;

public interface Service {
    String hello();

    static public String hi(){  // 정적 메서드
        prepareMessage();  //공통 메서드
        return "hi";
    }
    static public String hi2(){  // 정적 메서드
        prepareMessage(); // 공통 메서드
        return "hi";
    }
    static private void prepareMessage(){ // java9 이후부터 private static 메서드 가능

    }

    default String bye(){ // 기본 메서드
        return "bye";
    }
}
