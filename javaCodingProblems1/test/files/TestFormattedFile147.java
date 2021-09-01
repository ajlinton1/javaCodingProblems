package files;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.util.Formatter;

public class TestFormattedFile147 {

    @Test
    public void testNoFormat() throws IOException {
        Path path = Paths.get("noformat.txt");
        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            for (int i = 0; i < 10; i++) {
                int x = (int) (Math.random()*1000);
                double y = (double) (Math.random()*1000);
                bw.write("| " + x + " | " + y);
                bw.newLine();
            }
        }
    }

    @Test
    public void testFormatted() throws IOException {
        Path path = Paths.get("format.txt");
        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            for (int i = 0; i < 10; i++) {
                int x = (int) (Math.random()*1000);
                double y = (double) (Math.random()*1000);
                bw.write(String.format("| %6s | %.3f", x, y));
                System.out.println(String.format("| %6s | %.3f", x, y));
                bw.newLine();
            }
        }
    }

    @Test
    public void testFormatter() throws IOException {
        Path path = Paths.get("formatter.txt");
        try (Formatter output = new Formatter(path.toFile())) {
            for (int i = 0; i < 10; i++) {
                int x = (int) (Math.random()*1000);
                double y = (double) (Math.random()*1000);
                output.format("| %6s | %.3f", x, y);
                System.out.println(String.format("| %6s | %.3f", x, y));
            }
        }
    }

    @Test
    public void testFormatter1() throws IOException {
        Path path = Paths.get("withFormatter.txt");
        DecimalFormat formatter = new DecimalFormat("###,### bytes");
        try (Formatter output = new Formatter(path.toFile())) {
            for (int i = 0; i < 10; i++) {
                int x = (int) (Math.random()*1000);
                output.format("%12s%n", formatter.format(x));
            }
        }
    }
}
