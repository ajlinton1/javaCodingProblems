package functional;

import arrays.Melon;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMapping182 {

    @Test
    public void testMapping() {
        List<Melon> melons = Arrays.asList(new Melon("Gac", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700));
        List<String> melonNames = melons.stream()
                .map(Melon::getName)
                .collect(Collectors.toList());
        Assert.assertNotNull(melonNames);

        List<Integer> melonWeights = melons.stream()
                .map(Melon::getWeight)
                .collect(Collectors.toList());
        Assert.assertNotNull(melonWeights);

        List<Melon> lighterMelons = melons.stream()
                .map(m -> {
                    m.setWeight(m.getWeight() - 500);

                    return m;
                })
                .collect(Collectors.toList());
        Assert.assertNotNull(lighterMelons);

        List<Melon> lighterMelons1 = melons.stream()
                .peek(m -> m.setWeight(m.getWeight() - 500))
                .collect(Collectors.toList());
        Assert.assertNotNull(lighterMelons1);
    }

    @Test
    public void testFlatMap() {
        Melon[][] melonsArray = {
                {new Melon("Gac", 2000), new Melon("Hemi", 1600)},
                {new Melon("Gac", 2000), new Melon("Apollo", 2000)},
                {new Melon("Horned", 1700), new Melon("Hemi", 1600)}
        };
        Stream<Melon[]> streamOfMelonsArray = Arrays.stream(melonsArray);
        var result = streamOfMelonsArray
                .flatMap(Arrays::stream) // Stream<Melon>
                .distinct()
                .collect(Collectors.toList());
        Assert.assertNotNull(result);
    }
}
