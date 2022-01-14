package functional;

import org.junit.Assert;
import org.junit.Test;

public class TestDefaultMethods198 {

    @Test
    public void test() {
        Square s = new Square(5);
        Assert.assertEquals(25, s.area(), 0.01);
        Assert.assertEquals(20, s.perimeter(5,5,5,5), 0.01);
    }
}
