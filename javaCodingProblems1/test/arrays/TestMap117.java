package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestMap117 {

    @Test
    public void testSortMap() {
        var map1 = new HashMap<String, Integer>();
        map1.put("c", 1);
        map1.put("a", 3);
        map1.put("b", 2);

        var sorted = new HashMap<String, Integer>();
        for (var sourceKey: map1.keySet()) {
            String smallest = null;
            for (var currentKey: map1.keySet()) {
                if (smallest==null || currentKey.compareTo(smallest)<0) {
                    if (sorted.get(currentKey)==null) {
                        smallest = currentKey;
                    }
                }
            }
            sorted.put(smallest, map1.get(smallest));
        }

        Assert.assertNotNull(sorted);
    }

    @Test
    public void testSortTreeMap() {
        var map1 = new HashMap<String, Integer>();
        map1.put("c", 1);
        map1.put("a", 3);
        map1.put("b", 2);

        var sorted = new TreeMap<String, Integer>(map1);

        Assert.assertNotNull(sorted);
    }

    @Test
    public void testSortTreeMap1() {
        var map1 = new HashMap<String, Melon>();
        map1.put("c", new Melon(1));
        map1.put("a", new Melon(4));
        map1.put("b", new Melon(2));

        var sorted = new TreeMap<String, Melon>(map1);

        Assert.assertNotNull(sorted);
    }

    @Test
    public void testSortByKeyStream() {
        var map1 = new HashMap<String, Melon>();
        map1.put("c", new Melon(1));
        map1.put("a", new Melon(4));
        map1.put("b", new Melon(2));

        var sorted = map1.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(v1, v2)->v1, LinkedHashMap::new));

        Assert.assertNotNull(sorted);
    }

    @Test
    public void testSortByValueStream() {
        var map1 = new HashMap<String, Melon>();
        map1.put("c", new Melon(1));
        map1.put("a", new Melon(4));
        map1.put("b", new Melon(2));

        var sorted = map1.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Melon::getWeight)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(v1, v2)->v1, LinkedHashMap::new));

        Assert.assertNotNull(sorted);
    }

    @Test
    public void testSortKeyList() {
        var map1 = new HashMap<String, Melon>();
        map1.put("c", new Melon(1));
        map1.put("a", new Melon(4));
        map1.put("b", new Melon(2));

        List<String> list = new ArrayList<>(map1.keySet());
        Collections.sort(list);

        Assert.assertNotNull(list);
    }

    @Test
    public void testSortValueList() {
        var map1 = new HashMap<String, Melon>();
        map1.put("c", new Melon(1));
        map1.put("a", new Melon(4));
        map1.put("b", new Melon(2));

        List<Melon> list = new ArrayList<>(map1.values());
        Collections.sort(list);

        Assert.assertNotNull(list);
    }

}
