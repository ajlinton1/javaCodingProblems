package chapter2;

import org.junit.Test;

import java.awt.*;

public class TestExceptionHelper {

    @Test
    public void testExceptionHelper() {
        String name = null;
        try {
            MyObjects.requireNonNullElseThrow(name, new UnsupportedOperationException("Name cannot be null"));
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void testExceptionHelper1() {
        Color color = null;
        try {
            color = MyObjects.requireNonNullElseThrow1(color, ()-> new UnsupportedOperationException("Name cannot be null"));
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex);
        }
    }
}
