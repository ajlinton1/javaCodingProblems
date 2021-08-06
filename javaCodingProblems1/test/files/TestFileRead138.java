package files;

import org.junit.Assert;
import org.junit.Test;

import javax.sound.sampled.AudioInputStream;
import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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

    @Test
    public void testReadFileMemory() throws FileNotFoundException, IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\javaCodingProblems1\\src\\files\\CopyFileVisitor.java");
        var lines = Files.readAllLines(path);
        lines.forEach(System.out::println);
    }

    @Test
    public void testReadFileMemory1() throws FileNotFoundException, IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\javaCodingProblems1\\src\\files\\CopyFileVisitor.java");
        var content = Files.readString(path);
        Assert.assertNotNull(content);
    }

    @Test
    public void testReadFileMemory2() throws FileNotFoundException, IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\javaCodingProblems1\\src\\files\\CopyFileVisitor.java");
        try (FileChannel fileChannel = (FileChannel.open(path, EnumSet.of(StandardOpenOption.READ)))) {
            MappedByteBuffer mBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
            if (mBuffer!=null) {
                String bufferContent = StandardCharsets.UTF_8.decode(mBuffer).toString();
                System.out.println(bufferContent);
                mBuffer.clear();
            }
        }
    }

    private static final int MAP_SIZE = 5242880;

    @Test
    public void testReadFileMemory3() throws FileNotFoundException, IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\javaCodingProblems1\\src\\files\\CopyFileVisitor.java");
        try (FileChannel fileChannel = (FileChannel.open(path, EnumSet.of(StandardOpenOption.READ)))) {

            int position = 0;
            long length = fileChannel.size();

            while (position < length) {
                long remaining = length - position;
                int bytestomap = (int)Math.min(MAP_SIZE, remaining);
                MappedByteBuffer mBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, position, bytestomap);
                if (mBuffer!=null) {
                    String bufferContent = StandardCharsets.UTF_8.decode(mBuffer).toString();
                    System.out.println(bufferContent);
                    mBuffer.clear();
                }

                position += bytestomap;
            }
        }
    }
}
