package files;

import org.junit.Test;

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
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path, p -> (Files.size((Path)p) > 1024 * 1024 * 1))) {
            for (Path file: ds) {
                System.out.println(file);
            }
        }
    }

}
