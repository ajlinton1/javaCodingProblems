package reflection;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class TestReflection162 {

    @Test
    public void getPublicFields() {
        Class<Melon> clazz = Melon.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields) {
            if (Modifier.isPublic(field.getModifiers())) {
                System.out.println("Field is public: " + field.getName());
            }
            if (Modifier.isPrivate(field.getModifiers())) {
                System.out.println("Field is private: " + field.getName());
            }
        }
    }
}
