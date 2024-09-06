package section4.item17;

import java.math.BigInteger;

public class BigIntegerUtils {
    // 불변 객체에서 상속을 허용하는 필드의 경우 다음과같은 방어적인 코드를 작성해야함.
    // 인스턴스의 실제 타입을 확인해서 상속한 타입인경우에는 BigInteger로 변경해서 사용한다.
    public static BigInteger safeInstance(BigInteger val){
        return val.getClass() == BigInteger.class ? val : new BigInteger(val.toByteArray());
    }
}
