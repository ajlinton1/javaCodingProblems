package chapter2;

import org.junit.Test;

import java.util.Objects;

public class TestIndex {

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndex() {
        int top = 55;
        int v = 56;
        Objects.checkIndex(v, top);
    }

    @Test
    public void testIndex1() {
        int top = 55;
        int v = 50;
        Objects.checkIndex(v, top);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSubrange() {
        int top = 55;
        int rangeBottom = 5;
        int rangeTop = 57;
        Objects.checkFromToIndex(rangeBottom, rangeTop, top);
    }

    @Test
    public void testSubrange1() {
        int top = 55;
        int rangeBottom = 5;
        int rangeTop = 50;
        Objects.checkFromToIndex(rangeBottom, rangeTop, top);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSubrange2() {
        int top = 55;
        int rangeBottom = 30;
        int rangeTop = 20;
        Objects.checkFromToIndex(rangeBottom, rangeTop, top);
    }
}
