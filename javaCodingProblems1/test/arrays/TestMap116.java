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
        var map1 = new HashMap<String, Integer>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);

        var map2 = TestMap116.mapDeepCopy(map1);
        Assert.assertNotNull(map2);
        Assert.assertEquals(3, map2.keySet().size());
    }

    public static <T,V> Map<T,V> mapDeepCopy(Map<T,V> m) {
        Map<T,V> ret = new HashMap<T,V>();
        for (var key: m.keySet()) {
            var v = m.get(key);
 //           var v1 = v.clone();
            ret.put(key, v);
        }
        return ret;
    }

}
