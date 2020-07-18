package chapter1;

import org.junit.Test;

public class TestVowelCount {

    @Test
    public void testVowelCount() {
        VowelCount vowelCount = new VowelCount("This is a test");
        int v = vowelCount.getVowelCount();
        int c = vowelCount.getConsonantCount();
    }
}
