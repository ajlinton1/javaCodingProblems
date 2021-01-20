package chapter2;

import org.junit.Assert;
import org.junit.Test;

public class TestImmutable {

    @Test
    public void testImmutable() {
        String s0 = "First value";
        String toString0 = s0.toString();
        int hashCode0 = s0.hashCode();
        String s1 = "Second value";
        String toString1 = s1.toString();
        int hashCode1 = s1.hashCode();
        Assert.assertNotEquals(hashCode0, hashCode1);
    }

    @Test
    public void testImmutable1() {
        String s0 = "First value";
        int hashCode0 = s0.hashCode();
        s0 = "Second value";
        int hashCode1 = s0.hashCode();
        Assert.assertNotEquals(hashCode0, hashCode1);
    }

    @Test
    public void testImmutable2() {
        String s0 = "First value";
        Object o0 = (Object)s0;
        String toString0 = o0.toString();
        s0 = "Second value";
        Object o1 = (Object)s0;
        String toString1 = o1.toString();
        Assert.assertNotEquals(toString0, toString1);
    }

    @Test
    public void testImmutable3() {
        String s0 = "First value";
        String s1 = "First value";
        Assert.assertEquals(s0 == s1, true);
    }

    @Test
    public void testImmutable4() {
        String s0 = "First value";
        String s1 = "Second value";
        s0 = "First value";
        Assert.assertEquals(true, s0 == s1);
    }

}
