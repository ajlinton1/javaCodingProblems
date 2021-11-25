package functional;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestMatching184 {

    @Test
    public void testMatching() {
        List<String> melons = Arrays.asList(
                "Gac", "Cantaloupe", "Hemi", "Gac", "Gac", "Hemi",
                "Cantaloupe", "Horned", "Hemi", "Hemi");
        boolean isAnyGac = melons.stream()
                .anyMatch(m -> m.equals("Gac"));
        Assert.assertTrue(isAnyGac);

        boolean isAnyApollo = melons.stream()
                .anyMatch(m -> m.equals("Apollo")); // false
        Assert.assertFalse(isAnyApollo);

        boolean isNoneGac = melons.stream()
                .noneMatch(m -> m.equals("Gac")); // false
        Assert.assertFalse(isNoneGac);

        boolean isNoneApollo = melons.stream()
                .noneMatch(m -> m.equals("Apollo"));
        Assert.assertTrue(isNoneApollo);

        boolean areAllGac = melons.stream()
                .allMatch(m -> m.equals("Gac"));
        Assert.assertFalse(areAllGac);

        boolean areAllLargerThan2 = melons.stream()
                .allMatch(m -> m.length() > 2);
        Assert.assertTrue(areAllLargerThan2);
    }
}
