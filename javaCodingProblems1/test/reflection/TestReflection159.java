package reflection;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.List;

public class TestReflection159 {

    @Test
    public void testInvokeInstanceMethod() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Method cultivateMethod = Melon.class.getDeclaredMethod("cultivate", String.class, Seed.class, int.class);
        Melon instanceMelon = Melon.class.getDeclaredConstructor().newInstance();
        var cultivatedMelons = (List<Melon>) cultivateMethod.invoke(instanceMelon, "Gac", new Seed(), 10);
        Assert.assertNotNull(cultivatedMelons);
    }
}
