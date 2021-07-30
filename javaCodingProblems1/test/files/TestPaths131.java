package files;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPaths131 {

    @Test
    public void testJoinPaths() {
        Path pathAbsolute = Paths.get("d:\\\\temp2");
        Path pathRelative = Paths.get("\\temp3");
        Path pathCombined = pathAbsolute.resolve(pathRelative);
        Assert.assertNotNull(pathCombined);
    }

    @Test
    public void testJoinPaths1() {
        Path pathAbsolute = Paths.get("d:\\\\temp2");
        Path pathRelative = Paths.get("temp3");
        Path pathCombined = pathAbsolute.resolveSibling(pathRelative);
        Assert.assertNotNull(pathCombined);
    }

    @Test
    public void testJoinPaths2() {
        Path pathAbsolute = Paths.get("\\temp2\\level1\\level2");
        Path pathRelative = Paths.get("\\level1\\part2");
        Path pathCombined = pathRelative.relativize(pathAbsolute);
        Assert.assertNotNull(pathCombined);
    }

}
