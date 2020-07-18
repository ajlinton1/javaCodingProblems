package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestJustDigits {

    @Test
    public void testJustDigits() {
        boolean result = JustDigits.isJustDigits("123");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testJustDigits1() {
        boolean result = JustDigits.isJustDigits("12a3");
        Assert.assertEquals(false, result);
    }

    @Test
    public void testJustDigits2() {
        boolean result = JustDigits.isJustDigits("");
        Assert.assertEquals(false, result);
    }

}
