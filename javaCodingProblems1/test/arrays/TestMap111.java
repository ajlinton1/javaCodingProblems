package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class TestMap111 {

    @Test
    public void testComputeAbsentPresent() {
        var map = new HashMap<String, Integer>();
        computeAbsentPresent(map, "key1");
        computeAbsentPresent(map, "key1");
        computeAbsentPresent(map, "key1");
        Integer v = map.get("key1");
        Assert.assertEquals(new Integer(4), v);
    }

    Function<String, String> compute = k -> k + "value";

    @Test
    public void testComputeAbsentPresent1() {
        var map = new HashMap<String, String>();
        map.put("key1", "value1");

        var v = map.computeIfAbsent("key2", k -> k + "value");
        Assert.assertEquals("key2value", v);
    }

    private void computeAbsentPresent(Map<String,Integer> map, String key) {
        if (map.containsKey(key)) {
            var existingValue = map.get(key);
            var newValue = existingValue * 2;
            map.put(key, newValue);
        } else {
            map.put(key, 1);
        }
    }
}
