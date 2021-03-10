package typeInference;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTypeInference {

    @Test
    public void test78() {
        var x = new ArrayList();
        Assert.assertNotNull(x);
    }

    @Test
    public void test79() {
        var x = 1;
        System.out.println(x);
    }

    private StringBuilder method1() {
        var sb = new StringBuilder();
        sb.append("This is another test");
        return sb;
    }

    @Test
    public void test80() {
        var x = method1();
        Assert.assertNotNull(x);
        System.out.println(x);
    }

    @Test
    public void test81() {
        var byteNumber = (byte) 25;     // inferred as byte
        var shortNumber = (short) 1463; // inferred as short
        System.out.println(shortNumber);
    }

    @Test
    public void test84() {
        List<String> list1 = new ArrayList<String>();
        list1.add("test1");
        System.out.println(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("test2");
        System.out.println(list2);

        var list3 = new ArrayList<>();
        list3.add("test3");
        list3.add(new Integer(1));
        System.out.println(list3);

        var list4 = new ArrayList<String>();
        list4.add("test4");
        System.out.println(list4);
    }

    @Test
    public void test85() {
        String[] a = new String[10];
        a[0] = "This is a test";
        var b = a;
        System.out.println(b);

        var c = new String[10];
        c[0] = "This is a test";
        System.out.println(c);

        int[] numbers = {1,2,3};
    }

    @Test
    public void test88() {
        var intOrString = false;
        if (Math.random()>0.5) {
            intOrString = true;
        }
        var x = intOrString ? 23 : "34";
        System.out.println(x);
    }

    @Test
    public void test89() {
        for (var i=0;i<10;i++) {
            System.out.println(i);
        }
    }
}
