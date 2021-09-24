package reflection;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class TestReflection160 {

    @Test
    public void testGetStaticMethods() {
        List<Method> staticMethods = new ArrayList<>();
        Class<Melon> clazz = Melon.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method: methods) {
            if (Modifier.isStatic(method.getModifiers())) {
                staticMethods.add(method);
            }
        }
        Assert.assertEquals(staticMethods.size(), 2);
    }

}
