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

    @Test
    public void testFlatMapping() {
        List<Melon> melonsGrown = Arrays.asList(
                new Melon("Honeydew", 5600,
                        Arrays.asList("Spider Mites", "Melon Aphids", "Squash Bugs")),
                new Melon("Crenshaw", 2000,
                        Arrays.asList("Pickleworms")),
                new Melon("Crenshaw", 1000,
                        Arrays.asList("Cucumber Beetles", "Melon Aphids")),
                new Melon("Gac", 4000,
                        Arrays.asList("Spider Mites", "Cucumber Beetles")),
                new Melon("Gac", 1000,
                        Arrays.asList("Squash Bugs", "Squash Vine Borers")));

        Map<String, Set<String>> pestsFlatMapping = melonsGrown.stream()
                .collect(groupingBy(Melon::getType,
                        flatMapping(m -> m.getPests().stream(), toSet())));

        Assert.assertNotNull(pestsFlatMapping);

        Map<Boolean, Set<String>> pestsFlatMapping1 = melonsGrown.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000,
                        flatMapping(m -> m.getPests().stream(), toSet())));

        Assert.assertNotNull(pestsFlatMapping1);
    }
}
