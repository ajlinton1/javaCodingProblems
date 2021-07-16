package files;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPaths134 {

    @Test
    public void testWalkPaths() throws Exception{
        var path1 = Paths.get("D:\\Projects");
        var pathVisitor = new PathVisitor();
        Files.walkFileTree(path1, pathVisitor);
    }
}
