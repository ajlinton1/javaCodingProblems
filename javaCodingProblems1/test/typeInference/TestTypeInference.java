package typeInference;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestTypeInference {

    @Test
    public void test78() {
        var x = new ArrayList();
        Assert.assertNotNull(x);
    }

    @Test
    public void test79() {
        var x = 1;
        System.out.println(x);
    }

    private StringBuilder method1() {
        var sb = new StringBuilder();
        sb.append("This is another test");
        return sb;
    }

    @Test
    public void test80() {
        var x = method1();
        Assert.assertNotNull(x);
        System.out.println(x);
    }
}
