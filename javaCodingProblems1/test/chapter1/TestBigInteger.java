package chapter1;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TestBigInteger {

    @Test
    public void getValue() {
        BigInteger nr = BigInteger.valueOf(Long.MAX_VALUE);
        int result = nr.intValue();
        Assert.assertEquals(result, -1);

        try {
            int result1 = nr.intValueExact();
            Assert.assertEquals(result1, -1);
        } catch (ArithmeticException ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void longToInt() {
        long nr = Integer.MAX_VALUE;
        int nrCast = (int)nr;
        System.out.println(nrCast);

        long nr1 = Integer.MAX_VALUE + 1;
        int nrCast1 = (int)nr1;
        System.out.println(nrCast1);

        try {
            long nr2 = Long.MAX_VALUE;
            int nrCast2 = Math.toIntExact(nr2);
            System.out.println(nrCast2);

        } catch (ArithmeticException ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void floor() {
        int x = -222;
        int y = 14;
        int z = Math.floorDiv(x, y);
        Assert.assertEquals(-16, z);
    }

    @Test
    public void nextFloatingPoint() {
        float f = 0.1f;
        float nextF = Math.nextAfter(f, Float.NEGATIVE_INFINITY);
        Assert.assertEquals(0.099999994, nextF, 0.001);
    }

    @Test
    public void largeMultiplication() {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        int z = x * y;

        Assert.assertEquals(1, z);

        try {
            int z1 = Math.multiplyExact(x,y);
        } catch (ArithmeticException ae) {

        }
    }

    @Test
    public void fusedMultiplyAdd() {
        double x = 49.29d;
        double y = -28.58d;
        double z = 33.63d;
        double q = (x * y) + z;

        double fma = Math.fma(x, y, z);

        Assert.assertEquals(q, fma, 0.1);
    }
}
