package chapter2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class TestCustomizedNullException {

    @Test
    public void testNullException() {
        Object o = null;
        try {
            String message = "This is a test";
            Objects.requireNonNull(o, () ->
                "Custom message:" + message
            );
        } catch (NullPointerException npe) {
            System.out.println(npe);
        }
    }

    @Test
    public void testCustomNullException() {
        Object o = null;
        try {
            if (Objects.isNull(o)) {
                throw new IllegalArgumentException("Null");
            }
        } catch (IllegalArgumentException npe) {
            System.out.println(npe);
        }

    }
}
