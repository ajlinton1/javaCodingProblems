package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestMostAppearances {

    @Test
    public void testMostAppearances() {
        Character result = MostAppearances.getMostAppearances("this is at test");
        Assert.assertNotNull(result);
    }
}
