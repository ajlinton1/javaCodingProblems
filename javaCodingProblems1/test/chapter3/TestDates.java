package chapter3;

import org.junit.Assert;
import org.junit.Test;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.time.zone.*;

public class TestDates  {

    @Test
    public void testParseDate() {
        String s = "2021-01-28";
        LocalDate d = LocalDate.parse(s);
        System.out.println(d);
    }

    @Test
    public void testParseDateTime() {
        String s = "2021-01-28T10:28:15";
        LocalDateTime d = LocalDateTime.parse(s);
        System.out.println(d);
    }

    @Test
    public void testFormat() {
        LocalDate dNow = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("LL/dd/yyyy");
        String s = dateTimeFormatter.format(dNow);
        System.out.println(s);
    }

    @Test
    public void testGetDate() {
        var dNow = LocalDate.now();
        System.out.println(dNow);
    }

    @Test
    public void testGetTime() {
        var tNow = LocalTime.now();
        System.out.println(tNow);
    }

    @Test
    public void testInstant() {
        Instant n = Instant.now();
        System.out.println(n);
    }

    @Test
    public void testPeriod() {
        LocalDate endOf20th = LocalDate.of(2000,12,31);
        LocalDate nowDate = LocalDate.now();
        Period period = Period.between(nowDate, endOf20th);
        Assert.assertNotNull(period);
    }

    @Test
    public void testDuration() {
        LocalTime morning = LocalTime.of(7, 0, 0);
        LocalTime now = LocalTime.now();
        Duration duration = Duration.between(now, morning);
        Assert.assertNotNull(duration);
    }

    public void testLocalDateTime() {
        var date = LocalDate.now();
        var time = LocalTime.now();
        var dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);
    }
}
