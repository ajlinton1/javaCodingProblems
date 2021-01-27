package chapter2;

import org.junit.Assert;
import org.junit.Test;

public class TestClonable {

    @Test
    public void testClone() {
        var cloneableClass = new ClonableClass(4, "Ed");
        ClonableClass clone = null;
        try {
            clone = cloneableClass.clone();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        System.out.println(clone);
    }

    @Test
    public void testToString() {
        var cloneableClass = new ClonableClass(4, "Ed");
        String s = cloneableClass.toString();
        System.out.println(s);
    }
}
