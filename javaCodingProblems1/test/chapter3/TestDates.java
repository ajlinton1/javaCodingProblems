package chapter3;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
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
        LocalDateTime ldt = LocalDateTime.of(2021, Month.FEBRUARY, 10, 1, 1);
        ZonedDateTime auPerthDeparture = ldt.atZone(ZoneId.of("Australia/Perth"));

        var flightTime = Duration.ofHours(15).plus(30, ChronoUnit.MINUTES);
        ZonedDateTime auPerthArrive = auPerthDeparture.plus(flightTime);

        ZonedDateTime euBucharestDepart = auPerthDeparture.withZoneSameInstant(ZoneId.of("Europe/Bucharest"));
        ZonedDateTime euBucharestArrive = auPerthArrive.withZoneSameInstant(ZoneId.of("Europe/Bucharest"));

        System.out.println(euBucharestArrive);
    }

    @Test
    public void testUnixTimestamp() {
        long unixTimestamp = 1387909800;
        var oldDate = new java.util.Date(unixTimestamp * 1000L);
        System.out.println(oldDate);
        
        var instant = Instant.ofEpochSecond(unixTimestamp);
        var date = java.util.Date.from(instant);
        System.out.println(date);
        
        var newDate = LocalDateTime.ofEpochSecond(unixTimestamp, 0, ZoneOffset.UTC);
        System.out.println(newDate);
    }

    @Test
    public void testFirstLastMonthDat() {
        var today = LocalDate.now();
        var firstDay = today.with(TemporalAdjusters.firstDayOfMonth());
        var lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);
    }

    @Test
    public void testZoneOfsets() {
        ZoneOffset zoneOffset = ZoneOffset.UTC;
        System.out.println(zoneOffset);
    }

    @Test
    public void testDateTemporal() {
        var epochSec = Instant.ofEpochSecond(5000L);
        var localDateTime = LocalDateTime.ofInstant(epochSec, ZoneId.systemDefault());
        System.out.println(localDateTime);

        var localDate = LocalDate.ofInstant(epochSec, ZoneId.systemDefault());
        System.out.println(localDate);
    }
    
    @Test
    public void testDateRange() {
        var start = LocalDate.of(2021,2,16);
        var end = LocalDate.of(2021,3,20);
        start.datesUntil(end).forEach(System.out::println);
    }

    @Test
    public void testAge() {
        var birthdate = LocalDate.of(1965, 9, 11);
        var now = LocalDate.now();
        var age = Period.between(birthdate, now);
        var ageYears = age.getYears();
        System.out.println(ageYears);
    }

    @Test
    public void testDayStartEnd() {
        var day = LocalDate.of(2020, 8, 3);
        var start = day.atStartOfDay();
        System.out.println(start);
        var end = start.plusHours(24);
        System.out.println(end);
    }

    @Test
    public void testDifferenceBetweenDates() {
        var start = LocalDate.of(2001, 4, 4);
        var end = LocalDate.of(2008, 3, 4);
        var diff = Period.between(start, end);
        var days = diff.getDays();
        System.out.println(days);
        var daysBetween = ChronoUnit.DAYS.between(start, end);
        System.out.println(daysBetween);
    }
}
