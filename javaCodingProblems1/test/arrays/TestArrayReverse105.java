package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArrayReverse105 {

    @Test
    public void reverseArray() {
        var a = ArrayService.getRandomArray();
        var reversed = new int[a.length];
        for (var i=0; i<a.length; i++) {
            reversed[a.length - i - 1] = a[i];
        }

        Assert.assertNotNull(reversed);
    }

    @Test
    public void reverseArrayStream() {
        var a = ArrayService.getRandomArray();
        var list1 = new ArrayList<Integer>();
        var s = Arrays.stream(a);

        s.forEach((int x)->{
            list1.add(x);
        });

        Assert.assertEquals(list1.size(), a.length);
        var reversed = new int[list1.size()];
        for (var i=0;i<list1.size();i++) {
            reversed[list1.size()-1-i] = a[i];
        }

        Assert.assertNotNull(reversed);
    }


}
