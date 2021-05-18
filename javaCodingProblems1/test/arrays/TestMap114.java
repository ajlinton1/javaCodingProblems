package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestMap114 {

    @Test
    public void testMapsEqual() {
        var map1 = new HashMap<String, Integer>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);

        var map2 = new HashMap<String, Integer>();
        map2.put("a", 1);
        map2.put("b", 2);
        map2.put("c", 3);

        var isEqual = mapsEqual(map1, map2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void testMapsEqual1() {
        var map1 = new HashMap<String, Integer>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);

        var map2 = new HashMap<String, Integer>();
        map2.put("a", 1);
        map2.put("b", 2);
        map2.put("c", 3);

        var isEqual = map1.equals(map2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void testMapsNotEqual() {
        var map1 = new HashMap<String, Integer>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);

        var map2 = new HashMap<String, Integer>();
        map2.put("a", 1);
        map2.put("b", 2);
        map2.put("c", 3);
        map2.put("d", 4);

        var isEqual = mapsEqual(map1, map2);
        Assert.assertFalse(isEqual);
    }

    @Test
    public void testMapsNotEqual1() {
        var map1 = new HashMap<String, Integer>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);

        var map2 = new HashMap<String, Integer>();
        map2.put("a", 1);
        map2.put("b", -2);
        map2.put("c", 3);

        var isEqual = mapsEqual(map1, map2);
        Assert.assertFalse(isEqual);
    }

    @Test
    public void testMapsNotEqual2() {
        var map1 = new HashMap<String, Integer>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);

        var map2 = new HashMap<String, Integer>();
        map2.put("a", 1);
        map2.put("e", 2);
        map2.put("c", 3);

        var isEqual = mapsEqual(map1, map2);
        Assert.assertFalse(isEqual);
    }

    boolean mapsEqual(Map<String,Integer> map1, Map<String,Integer> map2) {
        boolean ret = true;

        if (map1.keySet().size()!=map2.keySet().size()) {
            return false;
        }

        for (String key:map1.keySet()) {
            Integer value1 = map1.get(key);
            Integer value2 = map2.get(key);
            if (value1!=value2) {
                return false;
            }
        }

        return ret;
    }

}
