package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestParser {

    @Test
    public void testParseInt() {
        String s = "35";
        int result = Parser.parseInt(s, 10);
        Assert.assertEquals(35, result);
    }

    @Test
    public void testParseLong() {
        String s = "355";
        long result = Long.parseUnsignedLong(s, 10);
        Assert.assertEquals(355, result);
    }

    @Test
    public void testCompareUnsigned() {
        int x = 5;
        int y = 6;
        int result = Integer.compareUnsigned(x, y);
        Assert.assertTrue(result < 0);
    }

}
