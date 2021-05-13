package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestMap112 {

    @Test
    public void testRemoveMapEntry() {
        var map = new HashMap<String, Integer>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        var r = map.remove("b");
        Assert.assertNotNull(r);
    }

    @Test
    public void testRemoveMapEntry1() {
        var map = new HashMap<String, Integer>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        var r = map.remove("b", "?");
        Assert.assertEquals(false, r);

        var r1 = map.remove("b", new Integer(2));
        Assert.assertEquals(true, r1);
    }

    @Test
    public void testRemoveMapEntry2() {
        var map = new HashMap<String, Integer>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        map.keySet().removeIf(e -> e.equals("c"));

        Assert.assertNotNull(map);
    }

}
