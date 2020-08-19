package chapter1;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestNumberConverter {

    @Test
    public void testConvert() {
        List<Object> ret = NumberConverter.convert("123");
        Assert.assertNotNull(ret);
    }
}
