package chapter2;

import org.junit.Test;

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
        String name = null;
        try {
            name = MyObjects.requireNonNullElseThrow1(name, ()-> new UnsupportedOperationException("Name cannot be null"));
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex);
        }
    }
}
