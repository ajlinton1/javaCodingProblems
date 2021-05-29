package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMap115 {

    @Test
    public void testMapMerge() {
        var map1 = new HashMap<String, Integer>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);

        var map2 = new HashMap<String, Integer>();
        map2.put("d", 4);
        map2.put("e", 5);
        map2.put("f", 6);

        var map3 = merge(map1, map2);
        Assert.assertNotNull(map3);
        Assert.assertEquals(6, map3.keySet().size());
    }

    @Test
    public void testMapMerge1() {
        var map1 = new HashMap<String, Integer>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);

        var map2 = new HashMap<String, Integer>();
        map2.put("d", 4);
        map2.put("e", 5);
        map2.put("b", 6);

        var map3 = this.<String,Integer>merge(map1, map2);
        Assert.assertNotNull(map3);
        Assert.assertEquals(5, map3.keySet().size());
    }

    // https://learning.oreilly.com/library/view/java-generics-and/0596527756/ch01.html

    <T0, T1> Map<T0, T1> merge(Map<T0, T1> map1, Map<T0, T1> map2) {
        var ret = new HashMap<T0, T1>();
        for (var key:map1.keySet()) {
            ret.put(key, map1.get(key));
        }
        for (var key:map2.keySet()) {
            if (ret.get(key)!=null) {
                ret.replace(key, map2.get(key));
            } else {
                ret.put(key, map2.get(key));
            }
        }
        return ret;
    }

    @Test
    public void testMapMerge2() {
        var map1 = new HashMap<String, Integer>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);

        var map2 = new HashMap<String, Integer>();
        map2.put("d", 4);
        map2.put("e", 5);
        map2.put("b", 6);

        var map3 = TestMap115.mergeMaps(map1, map2);
        Assert.assertNotNull(map3);
        Assert.assertEquals(5, map3.keySet().size());
    }

    public static <K, V> Map<K, V> mergeMaps(Map<K, V> map1, Map<K, V> map2) {
        Map<K, V> map = new HashMap<>(map1);
        map2.forEach((key, value) -> map.merge(key, value, (v1, v2) -> v2));
        return map;
    }

    @Test
    public void testMapMerge3() {
        var map1 = new HashMap<String, Integer>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);

        var map2 = new HashMap<String, Integer>();
        map2.put("d", 4);
        map2.put("e", 5);
        map2.put("b", 6);

        var map3 = TestMap115.mergeMapsStreams(map1, map2);
        Assert.assertNotNull(map3);
        Assert.assertEquals(5, map3.keySet().size());
    }

    public static <K, V> Map<K, V> mergeMapsStreams(Map<K, V> map1, Map<K, V> map2) {
        Stream<Map.Entry<K, V>> combined = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream());
        Map<K, V> map = combined.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v2));
        return map;
    }
}
