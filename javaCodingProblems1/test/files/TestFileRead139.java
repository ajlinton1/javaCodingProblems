package files;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.directory.BasicAttribute;
import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class TestFileRead139 {

    @Test
    public void testFileSize() throws IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\out\\production\\javaCodingProblems\\files\\CopyFileVisitor.class");
        var fileSize = (int) Files.readAttributes(path, BasicFileAttributes.class).size();
        Assert.assertTrue(fileSize > 0);
    }

    @Test
    public void testReadFile() throws IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\out\\production\\javaCodingProblems\\files\\CopyFileVisitor.class");
        var fileSize = (int) Files.readAttributes(path, BasicFileAttributes.class).size();
        final byte[] buffer = new byte[fileSize];
        try (InputStream is = new FileInputStream(path.toString())) {
             int i;
             while ((i = is.read(buffer))!=-1) {
                 System.out.println("Reading");
             }
             System.out.println(new String(buffer));
        }
    }

    @Test
    public void testReadFile1() throws IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\out\\production\\javaCodingProblems\\files\\CopyFileVisitor.class");
        var fileSize = (int) Files.readAttributes(path, BasicFileAttributes.class).size();
        final byte[] buffer = new byte[fileSize];
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path.toString()))) {
            int i;
            while ((i = bis.read(buffer))!=-1) {
                System.out.println("Reading");
            }
            System.out.println(new String(buffer));
        }
    }

    @Test
    public void testReadFile2() throws IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\out\\production\\javaCodingProblems\\files\\CopyFileVisitor.class");
        var fileSize = (int) Files.readAttributes(path, BasicFileAttributes.class).size();
        final byte[] buffer = new byte[fileSize];
        try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(path))) {
            int i;
            while ((i = bis.read(buffer))!=-1) {
                System.out.println("Reading");
            }
            System.out.println(new String(buffer));
        }
    }

    @Test
    public void testReadFile3() throws IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\out\\production\\javaCodingProblems\\files\\CopyFileVisitor.class");
        var fileSize = (int) Files.readAttributes(path, BasicFileAttributes.class).size();
        final byte[] buffer = new byte[fileSize];
        try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(path))) {
            int i;
            while ((i = bis.read(buffer))!=-1) {
                System.out.println("Reading");
            }
            System.out.println(new String(buffer));
        }
    }

    @Test
    public void testReadFile4() throws IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\out\\production\\javaCodingProblems\\files\\CopyFileVisitor.class");
        var bytes = Files.readAllBytes(path);
        Assert.assertNotNull(bytes);
    }

    @Test
    public void testReadFile5() throws IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\out\\production\\javaCodingProblems\\files\\CopyFileVisitor.class");
        try (FileChannel fileChannel = (FileChannel.open(path, EnumSet.of(StandardOpenOption.READ)))) {
            MappedByteBuffer mbBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
            System.out.println(mbBuffer.limit());
        }
    }

    @Test
    public void testReadFile6() throws IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\out\\production\\javaCodingProblems\\files\\CopyFileVisitor.class");
        final int MAP_SIZE = 5242880;
        try (FileChannel fileChannel = (FileChannel.open(path, EnumSet.of(StandardOpenOption.READ)))) {
            int position = 0;
            long length = fileChannel.size();
            while (position < length) {
                long remaining = length - position;
                int bytestomap = (int) Math.min(MAP_SIZE, remaining);
                MappedByteBuffer mbBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, position, bytestomap);
                position += bytestomap;
            }
        }
    }

}
