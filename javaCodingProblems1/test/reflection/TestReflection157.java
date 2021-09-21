package reflection;

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.*;
import java.util.Arrays;
import java.beans.*;

public class TestReflection157 {

    @Test
    public void testGettersSetters() throws IntrospectionException {
        for (PropertyDescriptor pd : Introspector.getBeanInfo(Melon.class).getPropertyDescriptors()) {
            if (pd.getReadMethod() != null && !"class".equals(pd.getName())) {
                System.out.println(pd.getReadMethod());
            }
            if (pd.getWriteMethod() != null && !"class".equals(pd.getName())) {
                System.out.println(pd.getWriteMethod());
            }
        }
    }

    @Test
    public void testAccessSetter() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        var melon = new Melon();
        new PropertyDescriptor("weight", Melon.class).getWriteMethod().invoke(melon, 200);
        Assert.assertEquals(200, melon.getWeight());
    }
}
