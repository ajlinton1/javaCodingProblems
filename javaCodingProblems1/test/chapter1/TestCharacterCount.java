package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestCharacterCount {

    @Test
    public void testCharacterCount() {
        int ret = CharacterCount.getCount("This is a test of the system", 't');
        Assert.assertEquals(4, ret);
    }

}
