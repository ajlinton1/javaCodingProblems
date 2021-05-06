package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArray108 {

    @Test
    public void testIncreaseSize() {
        var a = ArrayService.getRandomArray();
        var b = Arrays.copyOf(a, a.length+1);
        Assert.assertNotNull(b);
    }
}
