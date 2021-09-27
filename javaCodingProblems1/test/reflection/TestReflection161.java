package reflection;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class TestReflection161 {

    @Test
    public void testGenericTypes() throws NoSuchMethodException {
        Class<Melon> clazz = Melon.class;

        Method sliceMethod = clazz.getDeclaredMethod("slice");
        Method asMapMethod = clazz.getDeclaredMethod("asMap", List.class);

        Type sliceReturnType = sliceMethod.getGenericReturnType();
        Type asMapReturnType = asMapMethod.getGenericReturnType();

        printGenerics(asMapReturnType);
    }

    public static void printGenerics(Type genericType) {

        if (genericType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) genericType;
            Type[] typeOfArguments = type.getActualTypeArguments();

            for (Type typeOfArgument: typeOfArguments) {
                Class classTypeOfArgument = (Class) typeOfArgument;
                System.out.println("Class of type argument: "
                        + classTypeOfArgument);

                System.out.println("Simple name of type argument: "
                        + classTypeOfArgument.getSimpleName());
            }
        }
    }
}
