package item03;

import item03.field.Concert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcertTest {
    @Test
    void perform(){
        Concert concert = new Concert(new MockElvis()); // 테스트를 위해서 가짜 객체를 생성,, 해당 객체는 IElvis의 구현체이기 때문에 사용 가능
        concert.perform();

        assertTrue(concert.isLightsOn());
        assertTrue(concert.isMainStateOpen());
    }

}