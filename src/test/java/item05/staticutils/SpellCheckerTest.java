package item05.staticutils;
import org.junit.jupiter.api.Test;
import section2.item05.staticutils.SpellChecker;

import static org.junit.jupiter.api.Assertions.*;


class SpellCheckerTest {
    @Test
    void isValid(){
        assertTrue(SpellChecker.isValid("test")); // 테스트용 객체를 생성 불가능,, 사전에 의존적이게
    }

}
