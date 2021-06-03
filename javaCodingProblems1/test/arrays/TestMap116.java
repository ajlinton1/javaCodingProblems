package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestMap116 {

    @Test
    public void testMapCopy() {
        var map1 = new HashMap<String, Integer>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);

        var map2 = TestMap116.mapCopy(map1);
        Assert.assertNotNull(map2);
        Assert.assertEquals(3, map2.keySet().size());
    }

    public static <T,V> Map<T,V> mapCopy(Map<T,V> m) {
        Map<T,V> ret = new HashMap<T,V>();
        for (var key: m.keySet()) {
            var v = m.get(key);
            ret.put(key, v);
        }
        return ret;
    }

    @Test
    public void testMapDeepCopy() {
        var map1 = new HashMap<String, String>();
        map1.put("a", "aa");
        map1.put("b", "bb");
        map1.put("c", "cc");

        var map2 = TestMap116.mapDeepCopy(map1);
        Assert.assertNotNull(map2);
        Assert.assertEquals(3, map2.keySet().size());

        var v1 = map1.get("a");
        var v2 = map2.get("a");
        Assert.assertTrue(v1 != v2);
    }

    public static <T,String> Map<T,String> mapDeepCopy(Map<T,String> m) {
        Map<T,String> ret = new HashMap<T,String>();
        for (var key: m.keySet()) {
            String v = m.get(key);
            var sb = new StringBuilder();
            sb.append(v);
            String v1 = (String) sb.toString();
            ret.put(key, v1);
        }
        return ret;
    }

    @Test
    public void testMapCopy1() {
        var map1 = new HashMap<String, Integer>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);

        var map2 = new HashMap<>(map1);
        Assert.assertNotNull(map2);
        Assert.assertEquals(3, map2.keySet().size());
    }

}
