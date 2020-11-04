package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestIndentation {

    @Test
    public void testIndentation() {
        String s = "Part1\nPart2\nPart3";
        String result = Indentation.indent(s, 3);
        Assert.assertNotNull(result);
    }
}
