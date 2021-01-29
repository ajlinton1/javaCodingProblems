package chapter3;

import org.junit.Assert;
import org.junit.Test;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.time.zone.*;

public class TestDates  {

    @Test
    public void testParse() {
        String s = "2021-01-28";
        LocalDate d = LocalDate.parse(s);
        System.out.println(d);
    }
}
