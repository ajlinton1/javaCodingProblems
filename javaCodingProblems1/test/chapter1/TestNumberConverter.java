package chapter1;

import org.junit.Test;
import org.testng.Assert;

import java.util.List;

public class TestNumberConverter {

    @Test
    public void testConvert() {
        List<Object> ret = NumberConverter.convert("123");
        Assert.assertNotNull(ret);
    }
}
