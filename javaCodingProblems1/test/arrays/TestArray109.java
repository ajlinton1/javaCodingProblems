package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestArray109 {

    @Test
    public void testImmutableArray() {
        var a = ArrayService.getRandomArray();
        var b = new Integer[a.length];
        for (var i = 0; i < a.length; i++) {
            b[i] = new Integer(a[i]);
        }
        var immutable = new ImmutableArray<Integer>(b);
        Assert.assertEquals(b[54], immutable.get(54));
    }

    @Test
    public void testImmutableList() {
        var a = ArrayService.getRandomArray();
        var immutable = Collections.unmodifiableList(Arrays.asList(a));

        Assert.assertNotNull(immutable);
    }
}
