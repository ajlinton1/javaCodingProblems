package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

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
    public void testArrayObjectEqual() {
        var a = new Melon[100];
        var b = new Melon[100];
        for (var i=0;i<100;i++) {
            a[i] = new Melon((int)(Math.random()*100));
            b[i] = a[i];
        }
        var comparison = Arrays.compare(a, b);
        Assert.assertEquals(0, comparison);
    }

    @Test
    public void testArrayObjectEqual1() {
        var a = new Melon[100];
        var b = new Melon[100];
        for (var i=0;i<100;i++) {
            a[i] = new Melon((int)(Math.random()*100));
            b[i] = new Melon((int)(Math.random()*100));
        }
        var comparison = Arrays.compare(a, b);
        Assert.assertNotEquals(0, comparison);
    }

    @Test
    public void testArrayObjectEqual2() {
        var a = new Melon[100];
        var b = new Melon[100];
        for (var i=0;i<100;i++) {
            var w = (int)(Math.random()*100);
            a[i] = new Melon(w);
            b[i] = new Melon(w);
        }
        var comparison = Arrays.compare(a, b);
        Assert.assertEquals(0, comparison);
    }

}
