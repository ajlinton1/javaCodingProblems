package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;

public class TestCustomCollector {

    @Test
    public void test() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600));

        Map<Boolean, List<Melon>> byWeight = melons.stream().collect(partitioningBy(m -> m.getWeight() > 2000));
        Assert.assertEquals(5, byWeight.get(true).size());

        Map<Boolean, List<Melon>> melons2000 = melons.stream()
                .collect(new MelonCollector());
        Assert.assertNotNull(melons2000);
    }
}
