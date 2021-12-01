package functional;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import reflection.Melon;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCollect186 {

    @Test
    public void testCollect() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Cantaloupe", 2600));

        List<Integer> resultToList = melons.stream()
                .map(Melon::getWeight)
                .filter(x -> x >= 1000)
                .collect(Collectors.toList());

        Assert.assertNotNull(resultToList);

        List<Integer> resultToList1 = melons.stream()
                .map(Melon::getWeight)
                .filter(x -> x >= 1000)
                .collect(Collectors.toCollection(ArrayList::new));

        Assert.assertNotNull(resultToList1);

        Set<Integer> resultToSet = melons.stream()
                .map(Melon::getWeight)
                .filter(x -> x >= 1000)
                .collect(Collectors.toSet());

        Assert.assertNotNull(resultToSet);

        Set<Integer> resultToSet1 = melons.stream()
                .map(Melon::getWeight)
                .filter(x -> x >= 1000)
                .collect(Collectors.toCollection(HashSet::new));

        Assert.assertNotNull(resultToSet1);

        Set<Integer> resultToSet2 = melons.stream()
                .map(Melon::getWeight)
                .filter(x -> x >= 1000)
                .collect(Collectors.toCollection(TreeSet::new));

        Assert.assertNotNull(resultToSet2);

/*        Map<String, Integer> resultToMap = melons.stream()
                .distinct()
                .collect(Collectors.toMap(Melon::getType,
                        Melon::getWeight));

        Assert.assertNotNull(resultToMap); */

        Map<Integer, Integer> resultToMap1 = melons.stream()
                .distinct()
                .map(x -> Map.entry(
                        new Random().nextInt(Integer.MAX_VALUE), x.getWeight()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Assert.assertNotNull(resultToMap1);

        Map<String, Integer> resultToMap2 = melons.stream()
                .collect(Collectors.toMap(Melon::getType, Melon::getWeight,
                        (oldValue, newValue) -> oldValue));

        Assert.assertNotNull(resultToMap2);

        Map<String, Integer> resultToMap3 = melons.stream()
                .sorted(Comparator.comparingInt(Melon::getWeight))
                .collect(Collectors.toMap(Melon::getType, Melon::getWeight,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));

        Assert.assertNotNull(resultToMap3);
    }

    @Test
    public void testCollect1() {
        String str = "Lorem Ipsum is simply Ipsum Lorem not simply Ipsum";

        Map<String, Integer> mapOfWords = Stream.of(str)
                .map(w -> w.split("\\s+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toMap(
                        w -> w.toLowerCase(), w -> 1, Integer::sum));

        Assert.assertNotNull(mapOfWords);
    }
}
