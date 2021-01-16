package chapter2;

import org.junit.Test;

import java.util.Objects;

public class TestIndex {

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndex() {
        int bottom = 0;
        int top = 55;
        int v = 56;
        Objects.checkIndex(v, top);
    }
}
