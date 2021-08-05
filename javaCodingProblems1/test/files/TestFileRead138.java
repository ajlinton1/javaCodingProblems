package files;

import org.junit.Assert;
import org.junit.Test;

import javax.sound.sampled.AudioInputStream;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.EnumSet;

public class TestFileRead138 {

    @Test
    public void testReadFile() throws FileNotFoundException {
        var charset = Charset.defaultCharset();
        Assert.assertNotNull(charset);

        var path = Paths.get("C:\\Projects\\javaCodingProblems\\javaCodingProblems1\\src\\files\\CopyFileVisitor.java");
        try (InputStream is = new FileInputStream(path.toString())) {
            int i;
            while ((i = is.read()) != -1) {
                System.out.print((char)i);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @Test
    public void testReadFile1() throws FileNotFoundException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\javaCodingProblems1\\src\\files\\CopyFileVisitor.java");
        try (FileReader fr = new FileReader(path.toFile())) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char)i);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @Test
    public void testReadFile2() throws FileNotFoundException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\javaCodingProblems1\\src\\files\\CopyFileVisitor.java");
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            int i;
            while ((i = br.read()) != -1) {
                System.out.print((char)i);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @Test
    public void testReadFile3() throws FileNotFoundException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\javaCodingProblems1\\src\\files\\CopyFileVisitor.java");
        try (BufferedReader br = Files.newBufferedReader(path)) {
            int i;
            while ((i = br.read()) != -1) {
                System.out.print((char)i);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
