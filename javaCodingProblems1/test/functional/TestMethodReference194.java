package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class TestMethodReference194 {

    List<Melon> melons = Arrays.asList(
            new Melon("Crenshaw", 1200), new Melon("Gac", 3000),
            new Melon("Hemi", 2600), new Melon("Hemi", 1600));

    @Test
    public void testMethodReference() {
        melons.forEach(m -> Melon.growing100g(m));
        Assert.assertNotNull(melons);

        melons.forEach(Melon::growing100g);
        Assert.assertNotNull(melons);
    }

    public class MelonComparator implements Comparator {

        @Override
        public int compare(Object m1, Object m2) {
            return Integer.compare(((Melon) m1).getWeight(),
                    ((Melon) m2).getWeight());
        }
    }

    @Test
    public void testMethodReference1() {
        MelonComparator mc = new MelonComparator();

        List<Melon> sorted = melons.stream()
                .sorted((Melon m1, Melon m2) -> mc.compare(m1, m2))
                .collect(Collectors.toList());

        Assert.assertNotNull(sorted);

        List<Melon> sorted1 = melons.stream()
                .sorted(mc::compare)
                .collect(Collectors.toList());

        Assert.assertNotNull(sorted1);

        List<Integer> sorted2 = melons.stream()
                .map(m -> m.getWeight())
                .sorted((m1, m2) -> Integer.compare(m1, m2))
                .collect(Collectors.toList());

        Assert.assertNotNull(sorted2);

        List<Integer> sorted3 = melons.stream()
                .map(m -> m.getWeight())
                .sorted(Integer::compare)
                .collect(Collectors.toList());

        Assert.assertNotNull(sorted3);
    }

    @Test
    public void testConstructorReference() {
        BiFunction<String, Integer, Melon> melonFactory = Melon::new;
        Melon hemi1300 = melonFactory.apply("Hemi", 1300);
         Assert.assertNotNull(hemi1300);
    }
}
