package section4.item16.time;

// 불변 필드를 노출한 class
public final class Time {
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;
    public final int hour;
    public final int minute;

    // 다음과같이 불변 필드는 생성자로 체크 할 순 있지만 여전히 추천하지 않음
    public Time(int hour, int minute) {
        if(hour < 0 || hour >= HOURS_PER_DAY)
            throw new IllegalArgumentException("Hour : "+hour);
        if (minute < 0 || minute >= MINUTES_PER_HOUR)
            throw new IllegalArgumentException("minute : " + minute);
        this.hour = hour;
        this.minute = minute;
    }
}
