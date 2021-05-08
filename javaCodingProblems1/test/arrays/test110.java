package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class test110 {

    @Test
    public void testGetValueOrDefault() {
        var map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        var x = map.getOrDefault("key3", "defaultValue");
        Assert.assertEquals("defaultValue", x);
    }
}
