package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestSortArrayOfString {

    @Test
    public void testSort() {
        String[] inStrings = new String[]{"a", "bb", "ccc", "dd", "e"};
        String[] result = SortArrayOfString.sort(inStrings);
        Assert.assertNotNull(result);
    }

}
