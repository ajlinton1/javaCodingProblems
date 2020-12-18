package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestDivision {

    @Test
    public void signedDivision() {
        int divisionMinMax = Integer.MIN_VALUE / Integer.MAX_VALUE;
        Assert.assertEquals(-1, divisionMinMax);

        int divisionMaxMin = Integer.MAX_VALUE / Integer.MIN_VALUE;
        Assert.assertEquals(0, divisionMaxMin);

        int moduloSignedMinMax = Integer.MIN_VALUE % Integer.MAX_VALUE;
        Assert.assertEquals(-1, moduloSignedMinMax);

        int moduloSignedMaxMin = Integer.MAX_VALUE % Integer.MIN_VALUE;
        Assert.assertEquals(2147483647, moduloSignedMaxMin);
    }

    @Test
    public void unsignedDivision() {
        int divisionMinMax = Integer.divideUnsigned(Integer.MIN_VALUE , Integer.MAX_VALUE);
        Assert.assertEquals(1, divisionMinMax);

        int divisionMaxMin = Integer.divideUnsigned(Integer.MAX_VALUE , Integer.MIN_VALUE);
        Assert.assertEquals(0, divisionMaxMin);

        int moduloSignedMinMax = Integer.remainderUnsigned(Integer.MIN_VALUE , Integer.MAX_VALUE);
        Assert.assertEquals(1, moduloSignedMinMax);

        int moduloSignedMaxMin = Integer.remainderUnsigned(Integer.MAX_VALUE , Integer.MIN_VALUE);
        Assert.assertEquals(2147483647, moduloSignedMaxMin);
    }

}
