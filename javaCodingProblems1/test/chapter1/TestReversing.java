package chapter1;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestReversing {

    @Test
    public void testReverseWord() {
        String inString = "Hello";
        Reversing reversing = new Reversing();
        String ret = reversing.reverseWord(inString);
        Assert.assertEquals(ret, "olleH");
    }

    @Test
    public void testReverseWords() {
        String str = "This is a test";
        String ret = Reversing.reverseWords(str);
        Assert.assertNotNull(ret);
    }
}
