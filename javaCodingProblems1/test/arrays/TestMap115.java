package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    Map<String, Integer> merge(Map<String, Integer> map1, Map<String, Integer> map2) {
        var ret = new HashMap<String, Integer>();
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
}
