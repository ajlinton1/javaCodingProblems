package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestAdder {

    @Test
    public void testAddInt() {
        int a = 5;
        int b = 3;
        int result = Adder.add(a, b);
        Assert.assertEquals(8, result);
    }

    @Test(expected = java.lang.ArithmeticException.class)
    public void testAddIntOverflow() {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int result = Adder.add(a, b);
        Assert.assertEquals(8, result);
    }

    @Test(expected = java.lang.ArithmeticException.class)
    public void testAddLongOverflow() {
        long a = Long.MAX_VALUE;
        long b = Long.MAX_VALUE;
        Adder.add(a, b);
    }
}
