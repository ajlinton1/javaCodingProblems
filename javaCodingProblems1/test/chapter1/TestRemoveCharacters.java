package chapter1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestRemoveCharacters {

    @Test
    public void testRemoveCharacters() {
        Set<Character> toRemove = new HashSet<>();
        toRemove.add('t');
        String result = RemoveCharacters.remove("this is a test", toRemove);
        Assert.assertNotNull(result);
    }

    @Test
    public void testRemoveCharacter() {
        Character toRemove = 't';
        String result = RemoveCharacters.removeCharacter("this is a test", toRemove);
        Assert.assertNotNull(result);
    }
}
