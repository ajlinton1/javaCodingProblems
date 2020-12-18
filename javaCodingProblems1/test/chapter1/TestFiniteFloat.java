package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestFiniteFloat {

    @Test
    public void isFiniteFloat() {
        Float f1 = 4.5f;
        Assert.assertEquals(Float.isFinite(f1), true);

        float f2 = 4.5f;
        Assert.assertEquals(Float.isFinite(f2), true);

        float f3 = f1 / 0;
        Assert.assertEquals(Float.isFinite(f3), false);

        float f4 = 0f / 0f;
        Assert.assertEquals(Float.isFinite(f4), false);

        Double d1 = 0.000333411333d;
        Assert.assertEquals(Double.isFinite(d1), true);

        Double d2 = d1 / 0;
        Assert.assertEquals(Double.isFinite(d2), false);

        Double d3 = Double.POSITIVE_INFINITY * 0;
        Assert.assertEquals(Double.isFinite(d3), false);
    }
}
