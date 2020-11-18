package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestMaxMin {

    @Test
    public void testMin() {
        int result = MaxMin.min(2,3);
        Assert.assertEquals(2, result);
    }

    @Test
    public void testMax() {
        int result = MaxMin.max(4,3);
        Assert.assertEquals(4, result);
    }

}
