package files;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.util.EnumSet;

public class TestFilesFind {

    @Test
    public void testFindFile() throws Exception {
        var path = Paths.get("C:\\temp");
        var fileStream = Files.find(path, 10,
                (path1, attr)->path1.toString().endsWith("mp3"),
                FileVisitOption.FOLLOW_LINKS);
        fileStream.forEach(System.out::println);
    }
}
