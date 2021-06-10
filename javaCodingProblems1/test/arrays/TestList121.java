package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TestList121 {

    @Test
    public void testSubstituteList() {
        List<Integer> original = new ArrayList();
        original.add(1);
        original.add(2);
        original.add(3);
        original.add(4);
        original.add(5);

        var subList = substitute(original, (x)->x*2);

        Assert.assertNotNull(subList);
    }

    List<Integer> substitute(List<Integer> original, Function<Integer,Integer> sub) {
        var ret = new ArrayList<Integer>();
        for (var x: original) {
            var r = sub.apply(x);
            ret.add(r);
        }
        return ret;
    }
}
