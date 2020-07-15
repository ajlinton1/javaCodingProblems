package chapter1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class TestFirstNonRepeatedCharacter {

    @Test
    public void testGetFirstNonRepeatedCharacter() {
        FirstNonRepeatedCharacter firstNonRepeatedCharacter = new FirstNonRepeatedCharacter();
        char r = firstNonRepeatedCharacter.getFirstNonRepeatedCharacter("aabbccdeeffghhiijjkk");
        Assert.assertEquals(r, 'd');
    }

}
