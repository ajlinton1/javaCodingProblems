package files;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPaths130 {

    @Test
    public void testConvertPath() {
        Path pathRelative = Paths.get("myprog", "config", "test.txt");
        var file = pathRelative.toFile();
        Assert.assertNotNull(file);
        var url = pathRelative.toUri();
        Assert.assertNotNull(url);
        var s = pathRelative.toString();
        Assert.assertNotNull(s);
    }

}
