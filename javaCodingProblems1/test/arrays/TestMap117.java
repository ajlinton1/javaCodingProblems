package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

}
