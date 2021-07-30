package files;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPaths129 {

    @Test
    public void testCreatePath() {
        Path pathAbsolute = Paths.get("d:\\\\temp2\\test.txt");
        Path pathRelative = Paths.get("myprog", "config", "test.txt");
        Assert.assertNotNull(pathAbsolute);
        Assert.assertNotNull(pathRelative);
    }
}
