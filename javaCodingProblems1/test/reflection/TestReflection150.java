package reflection;

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.*;

// https://learning.oreilly.com/library/view/java-cookbook-4th/9781492072577/ch17.html#javacook-reflection-SECT-2

public class TestReflection150 {

    @Test
    public void testInspectClass() {
        Class<TestReflection150> testReflection150Class = TestReflection150.class;
        Assert.assertNotNull(testReflection150Class);
    }

    @Test
    public void testInspectClass1() {
        String s = "This is a test";
        Class stringClass = s.getClass();
        Assert.assertNotNull(stringClass);
    }

    @Test
    public void testInspectClass2() {
        Class c = this.getClass();
        Assert.assertNotNull(c);
        System.out.println(c.getPackage());
        System.out.println(c.getName());
        System.out.println(c.getAnnotatedInterfaces());
        System.out.println(c.getCanonicalName());
        System.out.println(c.getClassLoader());
        System.out.println(c.getConstructors());
        System.out.println(c.getDeclaredMethods());
        Assert.assertNotNull(null);
    }

    @Test
    public void testInstantiate() throws Exception {
        Class<MyClass> myClassClass = MyClass.class;
        var myClass = myClassClass.getDeclaredConstructor().newInstance();
        Assert.assertNotNull(myClass);
        myClass.method1();
    }
}
