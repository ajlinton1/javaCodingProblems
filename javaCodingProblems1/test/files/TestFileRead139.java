package files;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.directory.BasicAttribute;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class TestFileRead139 {

    @Test
    public void testFileSize() throws IOException {
        var path = Paths.get("C:\\Projects\\scala3Test2\\target\\scala-3.0.0\\classes\\hello.class");
        var fileSize = (int) Files.readAttributes(path, BasicFileAttributes.class).size();
        Assert.assertTrue(fileSize > 0);
    }

    @Test
    public void testReadFile() throws IOException {
        var path = Paths.get("C:\\Projects\\scala3Test2\\target\\scala-3.0.0\\classes\\hello.class");
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
        var path = Paths.get("C:\\Projects\\scala3Test2\\target\\scala-3.0.0\\classes\\hello.class");
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
        var path = Paths.get("C:\\Projects\\scala3Test2\\target\\scala-3.0.0\\classes\\hello.class");
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
        var path = Paths.get("C:\\Projects\\scala3Test2\\target\\scala-3.0.0\\classes\\hello.class");
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

}
