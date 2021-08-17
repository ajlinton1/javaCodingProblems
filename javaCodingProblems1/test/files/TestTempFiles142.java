package files;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class TestTempFiles142 {

    @Test
    public void testTempFileLocation() {
        var tempFileLocation = System.getProperty("java.io.tmpdir");
        Assert.assertNotNull(tempFileLocation);
    }

    @Test
    public void testCreateTmpFolder() throws IOException {
        var pathNoPrefix = Files.createTempDirectory(null);

        var pathCustomPrefix = Files.createTempDirectory("logs_");

        var customBaseDir = FileSystems.getDefault().getPath("c:\\temp2");
        var customDirPrefix = "logs_";
        var pathCustomLocationAndPrefix = Files.createTempDirectory(customBaseDir, customDirPrefix);
        Assert.assertNotNull(pathCustomLocationAndPrefix);
    }

    @Test
    public void testCreateTmpFile() throws IOException {
        var pathNoPrefixSuffix = Files.createTempFile(null, null);

        var customFilePrefix = "_log";
        var customFileSuffix = ".txt";
        var pathCustomPrefixSuffix = Files.createTempFile(customFilePrefix, customFileSuffix);

        Assert.assertNotNull(pathCustomPrefixSuffix);
    }

    @Test
    public void testDeleteTmpFile() throws IOException, InterruptedException {
        var customBaseDir = FileSystems.getDefault().getPath("c:\\temp2");
        var customDirPrefix = "logs_";
        var tmpDir = Files.createTempDirectory(customBaseDir, customDirPrefix);
        var customFilePrefix = "_log";
        var customFileSuffix = ".txt";
        var tmpFile = Files.createTempFile(tmpDir, customFilePrefix, customFileSuffix);


        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                try (DirectoryStream<Path> ds = Files.newDirectoryStream(tmpDir)) {
                    for (Path file : ds) {
                        Files.delete(file);
                    }
                    Files.delete(tmpDir);
                } catch (IOException e) {

                }
            }
        });

        Thread.sleep(10000);
        System.out.println("Done");
    }

    @Test
    public void testDeleteTmpFile1() throws IOException, InterruptedException {
        var customBaseDir = FileSystems.getDefault().getPath("c:\\temp2");
        var customDirPrefix = "logs_";
        var tmpDir = Files.createTempDirectory(customBaseDir, customDirPrefix);
        var customFilePrefix = "_log";
        var customFileSuffix = ".txt";
        var tmpFile = Files.createTempFile(tmpDir, customFilePrefix, customFileSuffix);

        try (DirectoryStream<Path> ds = Files.newDirectoryStream(tmpDir)) {
            tmpDir.toFile().deleteOnExit();
            for (Path file: ds) {
                file.toFile().deleteOnExit();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

        System.out.println("Done");
    }

    @Test
    public void testDeleteTmpFile2() throws IOException, InterruptedException {
        var customBaseDir = FileSystems.getDefault().getPath("c:\\temp2");
        var customDirPrefix = "logs_";
        var tmpDir = Files.createTempDirectory(customBaseDir, customDirPrefix);
        var customFilePrefix = "_log";
        var customFileSuffix = ".txt";
        var tmpFile = Files.createTempFile(tmpDir, customFilePrefix, customFileSuffix);

        try (BufferedWriter bw = Files.newBufferedWriter(tmpFile, StandardCharsets.UTF_8, StandardOpenOption.DELETE_ON_CLOSE)) {
            Thread.sleep(1000);
        } catch (IOException | InterruptedException e) {
            System.err.println(e);
        }

        System.out.println("Done");
    }
}
