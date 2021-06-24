package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class TestTuple125 {

    @Test
    public void testTuple() {
        var numbers = new int[]{2,3,6,9,0};
        var numbers1 = new ArrayList<Integer>();
        numbers1.add(3);
        Comparator<Integer> c1 = new ComparatorInteger();
        Integer[] numbers2 = new Integer[5];
        numbers2[0] = 5;
        numbers2[1] = 1;
        numbers2[2] = 7;
        numbers2[3] = 2;
        numbers2[4] = 9;
        var s = stats(numbers2, c1);
        Assert.assertNotNull(s);
    }

    private <T> Map.Entry<T,T> stats(T[] arr, Comparator<? super T> c){
        T min = arr[0];
        T max = arr[0];

        for (T elm: arr) {
            if (c.compare(min, elm)>0) {
                min = elm;
            }
            if (c.compare(min, elm)<0) {
                max = elm;
            }
        }
        return entry(min, max);
    }

    class ComparatorInteger implements Comparator<Integer> {

        @Override
        public int compare(Integer x, Integer y) {
            if (x>y) {
                return 1;
            }
            if (x<y) {
                return -1;
            }
            return 0;
        }
    }


}
