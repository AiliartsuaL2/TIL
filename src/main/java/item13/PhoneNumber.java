package item13;

import java.util.HashMap;
import java.util.Map;

// PhoneNumber에 clone 메서드 추가 (79쪽)
public final class PhoneNumber implements Cloneable {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix   = rangeCheck(prefix,   999, "프리픽스");
        this.lineNum  = rangeCheck(lineNum, 9999, "가입자 번호");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    /**
     * 이 전화번호의 문자열 표현을 반환한다.
     * 이 문자열은 "XXX-YYY-ZZZZ" 형태의 12글자로 구성된다.
     * XXX는 지역 코드, YYY는 프리픽스, ZZZZ는 가입자 번호다.
     * 각각의 대문자는 10진수 숫자 하나를 나타낸다.
     *
     * 전화번호의 각 부분의 값이 너무 작아서 자릿수를 채울 수 없다면,
     * 앞에서부터 0으로 채워나간다. 예컨대 가입자 번호가 123이라면
     * 전화번호의 마지막 네 문자는 "0123"이 된다.
     */
    @Override public String toString() {
        return String.format("%03d-%03d-%04d",
                areaCode, prefix, lineNum);
    }

    // 코드 13-1 가변 상태를 참조하지 않는 클래스용 clone 메서드를 재정의한 메서드(79쪽)
    // Public으로 재정의,
    // try-catch를 통해 CloneNotSupportedException을 처리해줌, 절대 일어날 일 없는데,, 이걸 checkedException으로 빼놨음
    // typeCasting을 미리해서 클라이언트쪽에서 그냥 사용 할 수 있도록 return 타입을 설정 해줌
    // super.clone()을 사용하지않고, 생성자를 활용한다면, 해당 클래스의 하위타입 클래스에서 clone을 cloneable 규약을 따르는경우에 캐스팅이 안됨,,
    @Override public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();  // 일어날 수 없는 일이다.
        }
    }

    // 변환 생성자
    public PhoneNumber(PhoneNumber phoneNumber) {
        this(phoneNumber.areaCode,phoneNumber.prefix,phoneNumber.lineNum);
    }

    // 변환 팩터리 메서드
    public static PhoneNumber copyInstance(PhoneNumber phoneNumber){
        return new PhoneNumber(phoneNumber.areaCode,phoneNumber.prefix,phoneNumber.lineNum);
    }

    public static void main(String[] args) {
        PhoneNumber pn = new PhoneNumber(707, 867, 5309);
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(pn, "제니");
        System.out.println(m.get(pn.clone()));
    }
}
