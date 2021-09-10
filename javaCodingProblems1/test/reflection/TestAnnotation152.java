package reflection;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;

public class TestAnnotation152 {

    @Test
    public void testAnnotations() {
        Class<?> myClassClass = MySubclass.class;
        for (Annotation a: myClassClass.getAnnotations()) {
            System.out.println(a);
            Assert.assertNotNull(a);
        }
    }

}
