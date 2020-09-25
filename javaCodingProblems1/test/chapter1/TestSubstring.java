package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestSubstring {

    @Test
    public void testSubstring() {
        String inString = "This is a test";
        String target = "is";
        boolean result = Substring.containsSubstring(inString, target);
        Assert.assertEquals(result, true);
    }

    @Test
    public void testSubstringNot() {
        String inString = "This is a test";
        String target = "master";
        boolean result = Substring.containsSubstring(inString, target);
        Assert.assertEquals(result, false);
    }
}
