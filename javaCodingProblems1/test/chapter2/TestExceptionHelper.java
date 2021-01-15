package chapter2;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.Objects;

public class TestExceptionHelper {

    @Test
    public void testExceptionHelper() {
        Color color = null;
        try {
            color = MyObjects.requireNonNullElseThrow(color, ()-> new UnsupportedOperationException("Name cannot be null"));
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void testDefaultIfNull() {
        Color color = null;
        Color color1 = MyObjects.defaultIfNull(color, ()-> Color.RED);
        Assert.assertEquals(color1, Color.RED);
    }

    @Test
    public void testDefaultIfNull1() {
        Color color = null;
        Color color1 = Objects.requireNonNullElseGet(color, ()-> Color.RED);
        Assert.assertEquals(color1, Color.RED);
    }

}
