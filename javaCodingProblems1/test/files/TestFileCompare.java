package files;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestFileCompare {

    @Test
    public void testFileCompare() throws IOException {
        var path0 = Paths.get("D:\\Projects\\javaCodingProblems\\javaCodingProblems1\\test\\files\\TestFileCompare.java");
        var path1 = Paths.get("D:\\Projects\\javaCodingProblems\\javaCodingProblems1\\test\\files\\TestFileFilter.java");
        var mismatch = Files.mismatch(path0, path1);
        Assert.assertTrue(mismatch > 0);
    }
}
