package section4.item20.defaultmethod;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

// 다른 패키지에서도 사용을하는 인터페이스의 경우 (공개 API), 메서드를 추가 할 경우 컨트롤하지 못하는 클래스들도 문제가 생김.
public interface TimeClient {
    void setTime(int hour, int minute, int second);
    void setDate(int day, int month, int year);
    void setDateAndTime(int day, int month, int year,
                        int hour, int minute, int second);
    LocalDateTime getLocalDateTime();

    static ZoneId getZoneId(String zoneString) {
        try {
            return ZoneId.of(zoneString);
        } catch (DateTimeException e) {
            System.err.println("Invalid time zone : "+ zoneString + "; using default time zone instead");
            return ZoneId.systemDefault();
        }
    }

    // 아래와같이 default 메서드를 통해 구현체의 코드를 변경하지 않아도 된다.
    default ZonedDateTime getZoneDateTime(String zoneString) {
        return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
    }
}
