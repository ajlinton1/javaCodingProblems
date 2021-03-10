package arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestSortArray {

    @Test
    public void test99() {
        int[] a = new int[100];
        for (int i=0;i<a.length;i++) {
            double d = Math.random()*100;
            a[i] = (int)d;
        }
        Assert.assertNotNull(a);
    }
}
