package chapter2;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class TestEquals {

    @Test
    public void testEquals() {
        String s1 = "String1";
        String s2 = "String2";
        var result = s1.equals(s2);
        Assert.assertEquals(false, result);
    }

    @Test
    public void testEquals1() {
        String s1 = "String1";
        String s2 = "String1";
        var result = s1.equals(s2);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testEquals2() {
        String s1 = "String1";
        String s2 = s1;
        var result = s1.equals(s2);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testEquals3() {
        Color c1 = new Color(1);
        Color c2 = new Color(2);
        var result = c1.equals(c2);
        Assert.assertEquals(false, result);
    }

    @Test
    public void testEquals4() {
        Color c1 = new Color(1);
        Color c2 = new Color(1);
        var result = c1.equals(c2);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testEquals5() {
        Color c1 = new Color(1);
        Color c2 = new Color(1);
        String h1 = c1.toString();
        String h2 = c2.toString();
        var result = h1.equals(h2);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testEquals6() {
        Color c1 = new Color(1);
        Color c2 = new Color(1);
        int h1 = c1.hashCode();
        int h2 = c2.hashCode();
        var result = h1== h2;
        Assert.assertEquals(true, result);
    }

    @Test
    public void testEquals7() {
        Color c1 = new Color(1);
        Color c2 = new Color(2);
        int h1 = c1.hashCode();
        int h2 = c2.hashCode();
        Assert.assertNotEquals(h1, h2);
    }

}
