package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
