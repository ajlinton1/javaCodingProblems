package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestConversion {

    @Test
    public void testUnsignedConversion(){
        int intValue = 5;
        long longValue = Integer.toUnsignedLong(intValue);
        Assert.assertTrue(longValue > 0);
    }
}
