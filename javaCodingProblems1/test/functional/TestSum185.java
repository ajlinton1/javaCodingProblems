package functional;

import arrays.Melon;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestSum185 {

    @Test
    public void testSum() {
        List<Melon> melons = Arrays.asList(new Melon("Gac", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700));
        int total = melons.stream()
                .mapToInt(Melon::getWeight)
                .sum();
        Assert.assertEquals(10300, total);

        int max = melons.stream()
                .mapToInt(Melon::getWeight)
                .max()
                .orElse(-1);
        Assert.assertEquals(3000, max);

        int min = melons.stream()
                .mapToInt(Melon::getWeight)
                .min()
                .orElse(-1);
        Assert.assertEquals(1600, min);
    }

    @Test
    public void testReduce() {
        List<Melon> melons = Arrays.asList(new Melon("Gac", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700));

        int total = melons.stream()
                .map(Melon::getWeight)
                .reduce(0, (m1, m2) -> m1 + m2);

        Assert.assertEquals(10300, total);

        int max = melons.stream()
                .map(Melon::getWeight)
                .reduce(Integer::max)
                .orElse(-1);
        Assert.assertEquals(3000, max);

        int min = melons.stream()
                .map(Melon::getWeight)
                .reduce(Integer::min)
                .orElse(-1);
        Assert.assertEquals(1600, min);
    }

    @Test
    public void testReduceProduct() {
        List<Double> numbers = Arrays.asList(1.0d, 5.0d, 8.0d, 10.0d);

        double total = numbers.stream().reduce(1.0d, (x1, x2) -> x1 * x2);
        Assert.assertEquals(400, total, 0.0d);
    }

    @Test
    public void testHarmonicMean() {
        List<Double> numbers = Arrays.asList(1.0d, 5.0d, 8.0d, 10.0d);
        double hm = numbers.size() / numbers.stream()
                .mapToDouble(x -> 1.0d / x)
                .reduce((x1, x2) -> (x1 + x2))
                .orElseThrow();
        Assert.assertEquals(2.807017543859649, hm, 0.0d);
    }
}
