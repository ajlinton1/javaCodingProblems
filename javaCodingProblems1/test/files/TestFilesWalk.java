package files;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestFilesWalk {

    @Test
    public void testFileWalk() throws Exception {
        Path startPath = Paths.get("C:\\temp");
        var paths = Files.walk(startPath, FileVisitOption.FOLLOW_LINKS);
        paths.forEach(System.out::println);
    }
}
