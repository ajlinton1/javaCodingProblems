package functional;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import reflection.Melon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestSummarization188 {

    @Test
    public void testSummarization() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Cantaloupe", 2600));
        int sumWeightsGrams = melons.stream()
                .collect(Collectors.summingInt(Melon::getWeight));
        Assert.assertTrue(sumWeightsGrams > 0);
    }

    @Test
    public void testReducing() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Cantaloupe", 2600));
        double sumWeightsKg = melons.stream()
                .collect(Collectors.reducing(0.0,
                        m -> (double) m.getWeight() / 1000.0d, (m1, m2) -> m1 + m2));
        Assert.assertTrue(sumWeightsKg > 0);
    }

    @Test
    public void testAverage() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Cantaloupe", 2600));
        double avgWeights = melons.stream()
                .collect(Collectors.averagingInt(Melon::getWeight));
        Assert.assertTrue(avgWeights > 0);
    }

    @Test
    public void testCounting() {
        String str = "Lorem Ipsum is simply dummy text ...";

        long numberOfWords = Stream.of(str)
                .map(w -> w.split("\\s+"))
                .flatMap(Arrays::stream)
                .filter(w -> w.trim().length() != 0)
                .count();

        Assert.assertTrue(numberOfWords > 0);
    }

    @Test
    public void testCounting1() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Cantaloupe", 2600));
        long nrOfMelon = melons.stream()
                .filter(m -> m.getWeight() == 3000)
                .count();
        Assert.assertTrue(nrOfMelon > 0);
    }

    @Test
    public void testCounting2() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Cantaloupe", 2600));
        long nrOfMelon = melons.stream()
                .filter(m -> m.getWeight() == 3000)
                .collect(Collectors.counting());
        Assert.assertEquals(2, nrOfMelon);
    }

    @Test
    public void testCounting3() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Cantaloupe", 2600));
        long nrOfMelon = melons.stream()
                .filter(m -> m.getWeight() == 3000)
                .collect(Collectors.reducing(0L, m -> 1L, Long::sum));
        Assert.assertEquals(2, nrOfMelon);
    }

    @Test
    public void testMax() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Cantaloupe", 2600));
        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);

        Melon heaviestMelon = melons.stream()
                .collect(Collectors.maxBy(byWeight))
                .orElseThrow();

        Assert.assertTrue(heaviestMelon.getWeight() > 0);

        Melon lightestMelon = melons.stream()
                .collect(Collectors.minBy(byWeight))
                .orElseThrow();

        Assert.assertTrue(lightestMelon.getWeight() > 0);
    }

    @Test
    public void testGetAllStats() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Cantaloupe", 2600));
        IntSummaryStatistics melonWeightsStatistics = melons
                .stream().collect(Collectors.summarizingInt(Melon::getWeight));
        Assert.assertNotNull(melonWeightsStatistics);
    }
}
