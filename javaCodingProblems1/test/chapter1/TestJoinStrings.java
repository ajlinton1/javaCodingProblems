package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestJoinStrings {

    @Test
    public void testJoinStrings() {
        String[] s = {"first", "second", "third"};
        String result = JoinStrings.join(s, "-");
        Assert.assertEquals("first-second-third", result);
    }
}
