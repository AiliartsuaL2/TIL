package section2.item03.staticfactory;

import java.util.function.Supplier;

public class Concert {
    public void start(Supplier<Singer> singerSupplier){ //공급자,,Supplier 자바8에서 추가된 펑셔널 인터페이스
        Singer singer = singerSupplier.get();
        singer.sing(); // implements한 클래스가 아니더라도, Singer 인터페이스의 메서드를 사용 할 수 있음
    }

    public static void main(String[] args) {
        Concert concert = new Concert();
        concert.start(() -> Elvis.getInstance());
    }
}
