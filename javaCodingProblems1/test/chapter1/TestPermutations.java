package chapter1;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestPermutations {

    @Test
    public void testPermutations() {
        List<String> result = Permutations.getPermutations("abcda");
        Assert.assertNotNull(result);
    }
}
