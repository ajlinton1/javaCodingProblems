package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TestStrategy170 {

    @Test
    public void testStrategy() {
        var list = new ArrayList();
        list.add(4);
        list.add(9);
        list.add(8);
        list.add(2);
        var filtered = filter(list, (x) -> { return (x > 5);});
        Assert.assertTrue(filtered.length == 2);
    }

    Object[] filter(List<Integer> inList, Predicate<Integer> predicate) {
        var ret = inList.stream().filter(predicate).toArray();
        return ret;
    }
}
