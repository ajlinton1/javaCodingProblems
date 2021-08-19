package files;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestFileFilter {

    @Test
    public void testFilterFiles() throws IOException {
        var path = Paths.get("C:\\Users\\Andy\\OneDrive\\Music");
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path, "*.{mp3}")) {
            for (Path file: ds) {
                System.out.println(file);
            }
        }
    }

    @Test
    public void testFilterFiles1() throws IOException {
        var path = Paths.get("C:\\Users\\Andy\\OneDrive\\Music");
        DirectoryStream.Filter  filter = p -> (Files.size((Path)p) > 1024 * 1024 * 1);
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path, filter)) {
            for (Path file: ds) {
                System.out.println(file);
            }
        }
    }

    @Test
    public void testFilterFiles2() throws IOException {
        var path = Paths.get("C:\\Users\\Andy\\OneDrive\\Music");
        FilenameFilter filter = (f, n) -> n.endsWith(".mp3");
        var files = path.toFile().list(filter);
        for (String file: files) {
            System.out.println(file);
        }
    }

    @Test
    public void testFilterFiles3() throws IOException {
        var path = Paths.get("C:\\Users\\Andy\\OneDrive\\Music");
        var files = path.toFile().list((f, n) -> n.endsWith(".mp3"));
        for (String file: files) {
            System.out.println(file);
        }
    }

    @Test
    public void testFilterFiles4() throws IOException {
        var path = Paths.get("C:\\Users\\Andy\\OneDrive");
        var files = path.toFile().listFiles(File::isDirectory);
        for (File file: files) {
            System.out.println(file);
        }
    }
}
