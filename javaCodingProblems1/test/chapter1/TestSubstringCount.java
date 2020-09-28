package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestSubstringCount {

    @Test
    public void testSubstringCount() {
        String inString = "This is a test";
        String target = "is";
        int result = Substring.count(inString, target);
        Assert.assertEquals(result, 2);
    }

    @Test
    public void testSubstringCount1() {
        String inString = "This is a test of the system";
        String target = "test";
        int result = Substring.count(inString, target);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testSubstringCount2() {
        String inString = "This is a tttt of the system";
        String target = "tt";
        int result = Substring.count(inString, target);
        Assert.assertEquals(result, 2);
    }

}
