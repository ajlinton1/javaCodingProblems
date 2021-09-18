package reflection;

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.*;
import java.util.Arrays;

public class TestReflection154 {

    @Test
    public void testVariableArgs() {
        Class<Melon> clazz = Melon.class;
        Method[] methods = clazz.getDeclaredMethods();
        Method variableArgs = Arrays.asList(methods).stream()
                .filter(m -> m.isVarArgs())
                .findFirst()
                .orElseThrow();
        Assert.assertNotNull(variableArgs);
    }

    @Test
    public void testDefault() {
        Class<MySubclass> clazz = MySubclass.class;
        Method[] methods = clazz.getMethods();
        Method variableArgs = Arrays.asList(methods).stream()
                .filter(m -> m.isDefault())
                .findFirst()
                .orElseThrow();
        Assert.assertNotNull(variableArgs);
    }

    @Test
    public void testNested() {
        Class<Melon.NestedClasss> clazz = Melon.NestedClasss.class;
        Class<?> nestHost = clazz.getNestHost();
        Class<?>[] nestmembers = clazz.getNestMembers();
        Assert.assertNotNull(nestmembers);
    }
}
