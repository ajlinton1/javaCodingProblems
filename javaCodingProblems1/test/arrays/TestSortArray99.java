package arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestSortArray99 {

    @Test
    public void testInitializeArray() {
        var a = ArrayService.getRandomArray();
        Assert.assertNotNull(a);
    }

    @Test
    public void testBubbleSort() {
        var a = ArrayService.getRandomArray();
        var swap = false;
        do {
            swap = false;
            for (var i=0;i<a.length-1;i++) {
                if (a[i]>a[i+1]) {
                    var temp = a[i+1];
                    a[i+1] = a[i];
                    a[i] = temp;
                    swap = true;
                }
            }
        } while (swap);

        var previous1 = -1;
        for (var current: a) {
            Assert.assertTrue(current >= previous1);
            previous1 = current;
        }
    }
}
