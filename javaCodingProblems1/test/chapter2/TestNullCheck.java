package chapter2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add(null);
        list.add("c");

        var s1 = list.stream().filter((String s) -> s!=null);

        for (Object s: s1.toArray()) {
            System.out.println(s);
        }
    }
}
