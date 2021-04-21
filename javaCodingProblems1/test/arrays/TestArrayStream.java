package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestArrayStream {

    @Test
    public void testArrayToStream() {
        var a = ArrayService.getRandomArray();
        var s = Arrays.stream(a);
        Assert.assertNotNull(s);
    }

}
