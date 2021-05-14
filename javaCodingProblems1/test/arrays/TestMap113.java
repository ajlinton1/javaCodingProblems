package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestMap113 {

    @Test
    public void replaceMapEntry() {
        var map = new HashMap<String, Integer>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        System.out.println(map.get("b"));

        map.replace("b", 22);
        System.out.println(map.get("b"));
    }
}
