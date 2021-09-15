package reflection;

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.*;
import java.util.Arrays;

public class TestReflection153 {

    @Test
    public void testSyntheticConstructs() {
        Class<Melon.Slice> clazzSlice = Melon.Slice.class;
        Field[] fields = clazzSlice.getDeclaredFields();
        System.out.println(fields.length);
        System.out.println(fields[0].isSynthetic());
        System.out.println(fields[0].getName());
    }

    @Test
    public void testSyntheticBridge() {
        Class<Melon> clazz = Melon.class;
        Method[] methods = clazz.getDeclaredMethods();
        Method compareBridge = Arrays.asList(methods).stream()
                .filter(m -> m.isSynthetic() && m.isBridge())
                .findFirst()
                .orElseThrow();

// public int modern.challenge.Melon.compare(
// java.lang.Object, java.lang.Object)
        System.out.println(compareBridge);
    }
}
