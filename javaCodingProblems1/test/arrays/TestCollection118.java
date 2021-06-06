package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        List<String> filtered = filterList1(list, (v) -> {return !v.equals(("b"));});

        Assert.assertNotNull(filtered);
        Assert.assertEquals(2, filtered.size());
    }

    private List<String> filterList1(List<String> list, Predicate<String> predicate) {
        List<String> filtered = new ArrayList<>();
        for (var x:list) {
            if (predicate.test(x)) {
                filtered.add(x);
            }
        }
        return filtered;
    }

    @Test
    public void testFilterCollection2() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        List<String> filtered = list.stream().filter((v) -> {return !v.equals(("b"));}).collect(Collectors.toList());

        Assert.assertNotNull(filtered);
        Assert.assertEquals(2, filtered.size());
    }

    @Test
    public void testFilterCollection3() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        list.removeIf(v -> v.equals("b"));

        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void testFilterCollection4() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        var separated = list.stream().collect(Collectors.partitioningBy(v->v.equals("b")));

        Assert.assertNotNull(separated);
    }

}
