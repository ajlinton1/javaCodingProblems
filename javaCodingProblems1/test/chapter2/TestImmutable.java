package chapter2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestImmutable {

    @Test
    public void testImmutable() {
        String s0 = "First value";
        String toString0 = s0.toString();
        int hashCode0 = s0.hashCode();
        String s1 = "Second value";
        String toString1 = s1.toString();
        int hashCode1 = s1.hashCode();
        Assert.assertNotEquals(hashCode0, hashCode1);
    }

    @Test
    public void testImmutable1() {
        String s0 = "First value";
        int hashCode0 = s0.hashCode();
        s0 = "Second value";
        int hashCode1 = s0.hashCode();
        Assert.assertNotEquals(hashCode0, hashCode1);
    }

    @Test
    public void testImmutable2() {
        String s0 = "First value";
        Object o0 = (Object)s0;
        String toString0 = o0.toString();
        s0 = "Second value";
        Object o1 = (Object)s0;
        String toString1 = o1.toString();
        Assert.assertNotEquals(toString0, toString1);
    }

    @Test
    public void testImmutable3() {
        String s0 = "First value";
        String s1 = "First value";
        Assert.assertEquals(s0 == s1, true);
    }

    @Test
    public void testImmutable4() {
        String s0 = "First value";
        String s1 = "Second value";
        s0 = "First value";
        Assert.assertEquals(false, s0 == s1);
    }

    @Test
    public void testImmuatableClass() {
        Immutable immutable = Immutable.getBuilder(1,2,3).build();
        Immutable immutable1 = Immutable.getBuilder(4,5,6).build();
        Assert.assertEquals(false, immutable == immutable1);
    }

    @Test
    public void testImmuatableClass1() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        Immutable immutable = Immutable.getBuilder(1,2,3).list(list).build();
        list.add("There");
        List<String> list1 = immutable.getList();
        for (String s: list1) {
            System.out.println(s);
        }
        Assert.assertEquals(1, list1.size());
    }

    @Test
    public void testImmuatableClass2() {
        List<String> list = new ArrayList<>();
        String s = "Hello";
        list.add(s);
        Immutable immutable = Immutable.getBuilder(1,2,3).list(list).build();
        s = "Goodby";
        List<String> list1 = immutable.getList();
        String s1 = list.get(0);
        Assert.assertNotEquals(s, s1);
    }
}
