package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class TestGrouping189 {

    @Test
    public void testGrouping() {
        List<Melon> melons = Arrays.asList(
                new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600)
        );
        Map<String, List<Melon>> byTypeInList = melons.stream()
                .collect(groupingBy(Melon::getType));
        Assert.assertNotNull(byTypeInList);

        Map<Integer, List<Melon>> byWeightInList = melons.stream()
                .collect(groupingBy(Melon::getWeight));
        Assert.assertNotNull(byWeightInList);

        Map<String, Set<Melon>> byTypeInSet = melons.stream()
                .collect(groupingBy(Melon::getType, toSet()));
        Assert.assertNotNull(byTypeInSet);

        Map<Integer, Set<Melon>> byWeightInSet = melons.stream()
                .collect(groupingBy(Melon::getWeight, toSet()));
        Assert.assertNotNull(byWeightInSet);

        Map<String, List<Melon>> byTypeInList1 = melons.stream()
                .distinct()
                .collect(groupingBy(Melon::getType));
        Assert.assertNotNull(byTypeInList1);

        Map<Integer, List<Melon>> byWeightInList1 = melons.stream()
                .distinct()
                .collect(groupingBy(Melon::getWeight));
        Assert.assertNotNull(byWeightInList1);

        Map<Integer, Set<Melon>> byWeightInSetOrdered = melons.stream()
                .collect(groupingBy(Melon::getWeight, TreeMap::new, toSet()));
        Assert.assertNotNull(byWeightInSetOrdered);

        Map<Integer, Set<String>> byWeightInSetOrdered1 = melons.stream()
                .collect(groupingBy(Melon::getWeight, TreeMap::new,
                        Collectors.mapping(Melon::getType, toSet())));
        Assert.assertNotNull(byWeightInSetOrdered1);

        Map<String, Long> typesCount = melons.stream()
                .collect(groupingBy(Melon::getType, counting()));
        Assert.assertNotNull(typesCount);

        Map<Integer, Long> weightsCount = melons.stream()
                .collect(groupingBy(Melon::getWeight, counting()));
        Assert.assertNotNull(weightsCount);

        Map<String, Optional<Melon>> minMelonByType = melons.stream()
                .collect(groupingBy(Melon::getType,
                        minBy(comparingInt(Melon::getWeight))));
        Assert.assertNotNull(minMelonByType);

        Map<String, Optional<Melon>> maxMelonByType = melons.stream()
                .collect(groupingBy(Melon::getType,
                        maxBy(comparingInt(Melon::getWeight))));
        Assert.assertNotNull(maxMelonByType);

        Map<String, Integer> minMelonByType1 = melons.stream()
                .collect(groupingBy(Melon::getType,
                        collectingAndThen(minBy(comparingInt(Melon::getWeight)),
                                m -> m.orElseThrow().getWeight())));
        Assert.assertNotNull(minMelonByType1);

        Map<String, Integer> maxMelonByType1 = melons.stream()
                .collect(groupingBy(Melon::getType,
                        collectingAndThen(maxBy(comparingInt(Melon::getWeight)),
                                m -> m.orElseThrow().getWeight())));
        Assert.assertNotNull(maxMelonByType1);

        Map<String, Melon[]> byTypeArray = melons.stream()
                .collect(groupingBy(Melon::getType, collectingAndThen(
                        Collectors.toList(), l -> l.toArray(Melon[]::new))));
        Assert.assertNotNull(byTypeArray);

        Map<String, Melon[]> byTypeArray1 = melons.stream()
                .collect(groupingBy(Melon::getType, toArray(Melon[]::new)));
        Assert.assertNotNull(byTypeArray1);
    }

    @Test
    public void testSplitList() {
        List<Integer> allWeights = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            int x = (int)Math.round(Math.random()*100);
            allWeights.add(x);
        }

        final AtomicInteger count = new AtomicInteger();
        Collection<List<Integer>> chunkWeights = allWeights.stream()
                .collect(Collectors.groupingBy(c -> count.getAndIncrement() / 10))
                .values();
        Assert.assertNotNull(chunkWeights);
    }

    private static <T> Collector<T, ? , T[]>
    toArray(IntFunction<T[]> func) {

        return Collectors.collectingAndThen(
                Collectors.toList(), l -> l.toArray(func.apply(l.size())));
    }
}
