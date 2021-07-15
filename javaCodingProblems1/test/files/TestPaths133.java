package files;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPaths133 {

    @Test
    public void testComparePaths() {
        Path path1 = Paths.get("d:\\\\temp2\\level1\\level2");
        Path path2 = Paths.get("d:\\\\temp2\\levela1\\levela2");
        var result = path1.compareTo(path2);
        Assert.assertTrue(result < 0);
    }

    @Test
    public void testComparePaths1() {
        Path path1 = Paths.get("d:\\\\temp2\\level1\\level2");
        Path path2 = Paths.get("d:\\\\temp2\\level1\\level2");
        var result = path1.compareTo(path2);
        Assert.assertEquals(0, result);
    }

}
