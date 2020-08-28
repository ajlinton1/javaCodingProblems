package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestPalindrome {

    @Test
    public void testPalindrome() {
        boolean result = Palindrome.isPalindrome("a");
        Assert.assertTrue(result);
    }

    @Test
    public void testPalindrome1() {
        boolean result = Palindrome.isPalindrome("aa");
        Assert.assertTrue(result);
    }

    @Test
    public void testPalindrome2() {
        boolean result = Palindrome.isPalindrome("kayak");
        Assert.assertTrue(result);
    }

    @Test
    public void testPalindrome3() {
        boolean result = Palindrome.isPalindrome("level");
        Assert.assertTrue(result);
    }

    @Test
    public void testPalindrome4() {
        boolean result = Palindrome.isPalindrome("Was it a car or a cat I saw");
        Assert.assertTrue(result);
    }
}
