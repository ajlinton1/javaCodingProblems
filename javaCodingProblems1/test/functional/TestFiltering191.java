package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.*;

public class TestFiltering191 {

    List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
            new Melon("Hemi", 1600), new Melon("Gac", 3000),
            new Melon("Hemi", 2000), new Melon("Crenshaw", 1700),
            new Melon("Gac", 3000), new Melon("Hemi", 2600));

    @Test
    public void testFiltering() {
        Map<String, Set<Melon>> melonsFiltering = melons.stream()
                .collect(groupingBy(Melon::getType,
                        filtering(m -> m.getWeight() > 2000, toSet())));

        Assert.assertNotNull(melonsFiltering);

        Map<String, Set<Melon>> melonsFiltering1 = melons.stream()
                .filter(m -> m.getWeight() > 2000)
                .collect(groupingBy(Melon::getType, toSet()));

        Assert.assertNotNull(melonsFiltering1);

        Map<Boolean, Set<Melon>> melonsFiltering2 = melons.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000,
                        filtering(m -> m.getType().equals("Hemi"), toSet())));

        Assert.assertNotNull(melonsFiltering2);

        Map<Boolean, Set<Melon>> melonsFiltering3 = melons.stream()
                .filter(m -> m.getType().equals("Hemi"))
                .collect(partitioningBy(m -> m.getWeight() > 2000, toSet()));

        Assert.assertNotNull(melonsFiltering3);
    }

    @Test
    public void testMapping() {
        Map<String, TreeSet<Integer>> melonsMapping = melons.stream()
                .collect(groupingBy(Melon::getType,
                        mapping(Melon::getWeight, toCollection(TreeSet::new))));

        Assert.assertNotNull(melonsMapping);

        Map<Boolean, Set<String>> melonsMapping1 = melons.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000,
                        mapping(Melon::getType, toSet())));

        Assert.assertNotNull(melonsMapping1);
    }
}
