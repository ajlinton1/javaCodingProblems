package files;

import functional.Melon;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCompose197 {

    List<Melon> melons = Arrays.asList(new Melon("Gac", 2000),
            new Melon("Horned", 1600), new Melon("Apollo", 3000),
            new Melon("Gac", 3000), new Melon("Hemi", 1600));

    @Test
    public void testComposePredicates() {
        Predicate<Melon> p2000 = m -> m.getWeight() > 2000;

        var result = melons.stream().filter(p2000);
        Assert.assertEquals(2, result.count());

        Predicate<Melon> p2000GacApollo
                = p2000.and(m -> m.getType().equals("Gac"))
                .or(m -> m.getType().equals("Apollo"));

        List<Melon> result1 = melons.stream()
                .filter(p2000GacApollo)
                .collect(Collectors.toList());
        Assert.assertNotNull(result1);

        Predicate<Melon> restOf = p2000GacApollo.negate();
        List<Melon> result2 = melons.stream()
                .filter(restOf)
                .collect(Collectors.toList());
        Assert.assertNotNull(result2);

        Predicate<Melon> pNot2000 = Predicate.not(m -> m.getWeight() > 2000);
        List<Melon> result3 = melons.stream()
                .filter(pNot2000)
                .collect(Collectors.toList());
        Assert.assertNotNull(result3);
    }

    @Test
    public void testComposeComparators() {
        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);
        List<Melon> sortedMelons = melons.stream()
                .sorted(byWeight)
                .collect(Collectors.toList());
        Assert.assertNotNull(sortedMelons);

        List<Melon> sortedMelons1 = melons.stream()
                .sorted(Comparator.comparing(Melon::getWeight))
                .collect(Collectors.toList());
        Assert.assertNotNull(sortedMelons1);

        List<Melon> sortedMelons2 = melons.stream()
                .sorted(Comparator.comparing(Melon::getType).reversed())
                .collect(Collectors.toList());
        Assert.assertNotNull(sortedMelons2);

        Comparator<Melon> byWeightAndType
                = Comparator.comparing(Melon::getWeight)
                .thenComparing(Melon::getType);
        List<Melon> sortedMelons3 = melons.stream()
                .sorted(byWeightAndType)
                .collect(Collectors.toList());
        Assert.assertNotNull(sortedMelons3);
   }

    @Test
    public void testComposeComparators1() {
        List<Melon> melons = Arrays.asList(new Melon("Gac", 2000),
                new Melon("Horned", 1600), new Melon("Apollo", 3000),
                new Melon("Gac", 3000), new Melon("hemi", 1600));

        Comparator<Melon> byWeightAndType = Comparator.comparing(Melon::getWeight)
                .thenComparing(Melon::getType, String.CASE_INSENSITIVE_ORDER);


        List<Melon> sortedMelons = melons.stream()
                .sorted(byWeightAndType)
                .collect(Collectors.toList());

        Assert.assertNotNull(sortedMelons);
    }

    @Test
    public void testComposingFunctions() {
        Function<Double, Double> f = x -> x * 2;
        Function<Double, Double> g = x -> Math.pow(x, 2);
        Function<Double, Double> gf = f.andThen(g);
        double resultgf = gf.apply(4d); // 64.0
        Assert.assertEquals(64.0, resultgf, 0.0);
    }

}
