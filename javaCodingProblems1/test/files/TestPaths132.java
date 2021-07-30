package files;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPaths132 {

    @Test
    public void testRelativePath() {
        Path path1 = Paths.get("d:\\\\temp2\\level1\\level2");
        Path path2 = Paths.get("d:\\\\temp2\\levela1\\levela2");
        Path path1ToPath2 = path1.relativize(path2);
        Assert.assertNotNull(path1ToPath2);
    }
}
