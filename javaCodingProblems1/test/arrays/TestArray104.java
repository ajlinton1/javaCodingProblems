package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestArray104 {

    @Test
    public void test104() {
        var a = ArrayService.getRandomArray();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int average;
        for (int x: a) {
            if (x < min) {
                min = x;
            }
            if (x > max) {
                max = x;
            }
            sum = sum + x;
        }
        average = sum / a.length;
        System.out.println(max);
        System.out.println(min);
        System.out.println(average);

        Assert.assertTrue(max > min);
    }

}
