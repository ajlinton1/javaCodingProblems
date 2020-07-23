package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestWhiteSpace {

    @Test
    public void testRemoveWhiteSpace() {
        String inString = "This is a test";
        String response = WhiteSpace.remove(inString);
        Assert.assertEquals("Thisisatest", response);
    }
}
