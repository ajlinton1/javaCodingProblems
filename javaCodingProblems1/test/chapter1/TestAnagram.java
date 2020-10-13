package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestAnagram {

    @Test
    public void testIsAnagram() {
        String a = "abc";
        String b = "cba";
        boolean result = Anagram.isAnagram(a, b);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsAnagram1() {
        String a = "abcd";
        String b = "cba";
        boolean result = Anagram.isAnagram(a, b);
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsAnagram2() {
        String a = "abcd";
        String b = "cbax";
        boolean result = Anagram.isAnagram(a, b);
        Assert.assertEquals(false, result);
    }
}
