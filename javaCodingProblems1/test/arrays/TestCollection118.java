package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCollection118 {

    @Test
    public void testFilterCollection() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        List<String> filtered = new ArrayList<>();
        for (var v:list) {
            if (!v.equals("b")) {
                filtered.add(v);
            }
        }

        Assert.assertNotNull(filtered);
      }

    @Test
    public void testFilterCollection1() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        List<String> filtered = filterList(list, (v) -> {return !v.equals(("b"));});

        Assert.assertNotNull(filtered);
        Assert.assertEquals(2, filtered.size());
    }

    @FunctionalInterface
    public interface Predicate {
        boolean isDesired(String s);
    }

    private List<String> filterList(List<String> list, Predicate predicate) {
        List<String> filtered = new ArrayList<>();
        for (var x:list) {
            if (predicate.isDesired(x)) {
                filtered.add(x);
            }
        }
        return filtered;
    }
}
