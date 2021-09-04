package reflection;

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.*;

public class TestReflection149 {

    @Test
    public void testInspectPackages() {
        Class<TestReflection149> testReflection149Class = TestReflection149.class;
        Assert.assertNotNull(testReflection149Class);
        Package p = testReflection149Class.getPackage();
        System.out.println(p.getName());
    }
}
