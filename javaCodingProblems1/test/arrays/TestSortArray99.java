package arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestSortArray99 {

    @Test
    public void testInitializeArray() {
        var a = ArrayService.getRandomArray();
        Assert.assertNotNull(a);
    }
}
