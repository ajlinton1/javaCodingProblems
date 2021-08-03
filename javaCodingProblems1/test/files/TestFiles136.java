package files;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.util.EnumSet;

public class TestFiles136 {

    @Test
    public void testStreamFile() {
        try (var filesStream = Files.lines(Paths.get("C:\\Projects\\agile-dawn-65969\\package-lock.json"))) {
            filesStream.forEach(System.out::println);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @Test
    public void testBufferedReader() {
        try (var brStream = Files.newBufferedReader(Paths.get("C:\\Projects\\agile-dawn-65969\\package-lock.json"))) {
            brStream.lines().forEach(System.out::println);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
