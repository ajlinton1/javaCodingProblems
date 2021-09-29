package reflection;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class TestReflection163 {

    @Test
    public void getArrayInfo() {
        int[] arrayOfInt = (int[]) Array.newInstance(int.class, 10);
        Assert.assertNotNull(arrayOfInt);
        Array.setInt(arrayOfInt, 0, 100);
        Assert.assertNotNull(arrayOfInt);
        int valueIndex0 = Array.getInt(arrayOfInt, 0);

        Class<?> stringClass = String[].class;
        Class<?> clazz = arrayOfInt.getClass();

        // int
        Class<?> typeInt = clazz.getComponentType();

        // java.lang.String
        Class<?> typeString = stringClass.getComponentType();
    }

}
