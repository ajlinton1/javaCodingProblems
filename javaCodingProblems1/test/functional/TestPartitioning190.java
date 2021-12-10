package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class TestPartitioning190 {

    @Test
    public void testPartition() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600));
        Map<Boolean, List<Melon>> byWeight = melons.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000));
        Assert.assertNotNull(byWeight);

        Map<Boolean, Set<Melon>> byWeight1 = melons.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000, toSet()));
        Assert.assertNotNull(byWeight1);

        Map<Boolean, List<Melon>> byWeight2 = melons.stream()
                .distinct()
                .collect(partitioningBy(m -> m.getWeight() > 2000));
        Assert.assertNotNull(byWeight2);

        Map<Boolean, Long> byWeightAndCount = melons.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000, counting()));
        Assert.assertNotNull(byWeightAndCount);

        Map<Boolean, Long> byWeight3 = melons.stream()
                .distinct()
                .collect(partitioningBy(m -> m.getWeight() > 2000, counting()));
        Assert.assertNotNull(byWeight3);

        Map<Boolean, Melon> byWeightMax = melons.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000,
                        collectingAndThen(maxBy(comparingInt(Melon::getWeight)),
                                Optional::get)));
        Assert.assertNotNull(byWeightMax);
    }
}
