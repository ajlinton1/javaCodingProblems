package reflection;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class TestAnnotations158 {

    @Test
    public void getAnnotations() {
        Class<Melon> clazz = Melon.class;
        Annotation[] annotations = clazz.getPackage().getAnnotations();
        Assert.assertNotNull(annotations);
    }

    @Test
    public void getAnnotations1() {
        Class<Melon> clazz = Melon.class;
        Annotation[] annotations = clazz.getAnnotations();
        Assert.assertNotNull(annotations);
    }
}
