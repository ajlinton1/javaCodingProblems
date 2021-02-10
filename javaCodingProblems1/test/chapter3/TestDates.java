package chapter3;

import org.junit.Assert;
import org.junit.Test;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.time.zone.*;
import java.util.ArrayList;

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

    @Test
    public void testLocalDateTime() {
        var date = LocalDate.now();
        var time = LocalTime.now();
        var dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);
    }

    @Test
    public void testTimeUnits() {
        var date = LocalDateTime.now();
        var hour = date.getHour();
        var minute = date.getMinute();
        var second = date.getSecond();
        var year = date.getYear();
        var month = date.getMonth();
        var day = date.getDayOfMonth();
    }

    @Test
    public void testAddTime() {
        var date = LocalDateTime.now();
        var date1 = date.plusDays(2);
        System.out.println(date1);
    }

    @Test
    public void testSubtractTime() {
        var p = Period.ofDays(700);
        var date = LocalDateTime.now();
        var date1 = date.minus(p);
        System.out.println(date1);
    }

    @Test
    public void testGetTimeZones() {
        var zones = ZoneId.getAvailableZoneIds();
        System.out.println(zones);
        var zoneIds = new ArrayList<ZoneId>();
        for (String zone: zones) {
            var zoneId = ZoneId.of(zone);
            zoneIds.add(zoneId);
        }
        System.out.println(zoneIds);
    }

    @Test
    public void testGetTimeInAllTimeZones() {
        var now = ZonedDateTime.now();
        var zones = ZoneId.getAvailableZoneIds();
        var zoneIds = new ArrayList<ZoneId>();
        for (String zone: zones) {
            var zoneId = ZoneId.of(zone);
            System.out.println(zone);
            var zoneTime = now.withZoneSameInstant(zoneId);
            System.out.println(zoneTime);
        }
    }

    @Test
    public void testFlightTime() {
        // 2021-02-10T13:57:00.283218600+08:00[Australia/Perth]
        String departureTimeString = "2021-02-10T13:57:00.283218600+08:00";
        // Parse departureTime
        ZonedDateTime departureTime = ZonedDateTime.parse(departureTimeString);
        // Create Perth TimeZone
        // Set departure time to Perth timezone
        // Add 15 hours, 30 minutes
        var flightTime = Duration.ofHours(15).plus(30, ChronoUnit.MINUTES);
        var arrivalTimeUnzoned = departureTime.plus(flightTime);
        // Create Bucharest timezone, Europe/Bucharest
        var zoneBucharest = ZoneId.of("Europe/Bucharest");
        // Create arrival time
        var arrivalTime = arrivalTimeUnzoned.toInstant().atZone(zoneBucharest);
        System.out.println(arrivalTime);
    }
}
