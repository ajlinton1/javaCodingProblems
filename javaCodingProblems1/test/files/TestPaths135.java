package files;

import org.junit.Test;

import java.nio.file.*;
import java.util.EnumSet;

public class TestPaths135 {

    @Test
    public void testWatchPath() throws Exception{
        var pathWatcher = new PathWatcher();
        var path = Paths.get("C:\\temp4");
//        pathWatcher.watchFolder(path);
    }
}
