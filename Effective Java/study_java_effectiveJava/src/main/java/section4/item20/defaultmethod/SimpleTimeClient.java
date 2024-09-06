package section4.item20.defaultmethod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import section4.item16.time.Time;

// 인터페이스의 경우 믹스인 가능
public class SimpleTimeClient implements TimeClient, AutoCloseable {
    private LocalDateTime dateAndTime;

    public SimpleTimeClient() {
        this.dateAndTime = LocalDateTime.now();
    }

    @Override
    public void setTime(int hour, int minute, int second) {
        LocalDate currentDate = LocalDate.from(dateAndTime);
        LocalTime timeToSet = LocalTime.of(hour, minute, second);
        dateAndTime = LocalDateTime.of(currentDate, timeToSet);
    }

    @Override
    public void setDate(int day, int month, int year) {
        LocalDate dateToSet = LocalDate.of(day, month, year);
        LocalTime currentTime = LocalTime.from(dateAndTime);
        dateAndTime = LocalDateTime.of(dateToSet, currentTime);

    }

    @Override
    public void setDateAndTime(int day, int month, int year, int hour, int minute, int second) {
        LocalDate dateToSet = LocalDate.of(day, month, year);
        LocalTime timeToSet = LocalTime.of(hour, minute, second);
        dateAndTime = LocalDateTime.of(dateToSet, timeToSet);
    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return dateAndTime;
    }
    public String toString() {
        return dateAndTime.toString();
    }

    public static void main(String[] args) {
        TimeClient myTimeClient = new SimpleTimeClient();

        System.out.println(myTimeClient);
        System.out.println(myTimeClient.getZoneDateTime("Asia/Seoul2"));
        System.out.println(myTimeClient.getZoneDateTime("Asia/Seoul"));
    }

    @Override
    public void close() throws Exception {

    }
}
