package files;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestScanner148 {

    @Test
    public void testScanner() throws IOException {
        try (Scanner scanner = new Scanner(Path.of("C:\\Users\\ajlin\\OneDrive\\CrunchBase\\20210814\\companies-all-8-14-2021.csv"),
                StandardCharsets.UTF_8).useDelimiter((","))) {
            while (scanner.hasNextLine()) {
                var line = scanner.next();
                System.out.println(line);
            }

        }
    }
}
