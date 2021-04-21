package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestEqualArray {

    @Test
    public void testArrayNotEqual() {
        var a = ArrayService.getRandomArray();
        var b = ArrayService.getRandomArray();
        var equal = Arrays.equals(a, b);

        Assert.assertFalse(equal);
    }

    @Test
    public void testArrayEqual() {
        var a = ArrayService.getRandomArray();
        var b = a;
        var equal = Arrays.equals(a, b);

        Assert.assertTrue(equal);
    }

    @Test
    public void testArrayEqual1() {
        var a = ArrayService.getRandomArray();
        var b = new int[a.length];
        for (var i=0;i<b.length;i++) {
            b[i] = a[i];
        }
        var equal = Arrays.equals(a, b);

        Assert.assertTrue(equal);
    }

    @Test
    public void testArrayCompare() {
        var a = ArrayService.getRandomArray();
        var b = ArrayService.getRandomArray();
        var c = Arrays.compare(a, b);

        Assert.assertNotNull(c);
    }

}
