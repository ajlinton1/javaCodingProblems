package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestArray119 {

    @Test
    public void testListToArray() {
        var list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        var array = list.toArray();

        Assert.assertNotNull(array);
    }

    @Test
    public void testListToArray1() {
        var list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        Collection<String> collection = list;

        var array = collection.toArray(new String[0]);

        Assert.assertNotNull(array);
    }

    @Test
    public void testListToArray2() {
        var list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        var array = list.toArray(new String[0]);

        Assert.assertNotNull(array);
    }

    @Test
    public void testListToArray3() {
        var list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        var array = list.toArray(String[]::new);

        Assert.assertNotNull(array);
    }
}
