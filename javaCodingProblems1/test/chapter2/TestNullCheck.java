package chapter2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TestNullCheck {

    @Test
    public void testNullCheck() {
        Object o = null;
        if (o == null) {
            System.out.println("Null");
        }
    }

    @Test
    public void testFillNulls() {
        List<String> list1 = Arrays.asList("a","b",null,"c");

        var s1 = list1.stream().filter(Objects::nonNull);

        for (Object s: s1.toArray()) {
            System.out.println(s);
        }
    }
}
