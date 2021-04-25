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
            min = Math.min(x, min);
            max = Math.max(x, max);
            sum = sum + x;
        }
        average = sum / a.length;
        System.out.println(max);
        System.out.println(min);
        System.out.println(average);

        Assert.assertTrue(max > min);

        var max1 = Arrays.stream(a).max().getAsInt();
        Assert.assertEquals(max, max1);
        var min1 = Arrays.stream(a).min().getAsInt();
        Assert.assertEquals(min, min1);
        var sum1 = Arrays.stream(a).sum();
        Assert.assertEquals(sum, sum1);

        var average1 = (int)Arrays.stream(a).average().getAsDouble();
        Assert.assertEquals(average, average1);
    }

    @Test
    public void test104Objects() {
        var numbers = ArrayService.getRandomArray();
        var melons = new Melon[numbers.length];
        for (var i=0;i<numbers.length;i++) {
            melons[i] = new Melon(numbers[i]);
        }

        var maxMelon = ArrayService.max(melons);
        Assert.assertNotNull(maxMelon);
    }

}
