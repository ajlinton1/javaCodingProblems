package chapter1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class TestDuplicateCharacters {

    @Test
    public void testGetCount() {
        DuplicateCharacters duplicateCharacters = new DuplicateCharacters();
        Map<Character, Long> ret = duplicateCharacters.getCount("abcda");
        Assert.assertNotNull(ret);
    }
}
