package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestLongestCommonPrefix {

    @Test
    public void testLongestCommonPrefix() {
//        String [] s = new String[1];
        String [] s = {"test", "tea", "tester"};
        String result = LongestCommonPrefix.getLongestCommonPrefix(s);
        Assert.assertNotNull(result);
        Assert.assertEquals("te", result);
    }
}
