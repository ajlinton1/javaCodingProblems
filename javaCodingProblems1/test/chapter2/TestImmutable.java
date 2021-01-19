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

}
