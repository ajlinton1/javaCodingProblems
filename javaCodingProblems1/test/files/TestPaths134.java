package files;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.*;
import java.util.EnumSet;

public class TestPaths134 {

    @Test
    public void testWalkPaths() throws Exception{
        var path1 = Paths.get("D:\\Projects");
        var pathVisitor = new PathVisitor();
        Files.walkFileTree(path1, pathVisitor);
    }

    @Test
    public void testSearchFile() throws Exception {
        var path = Paths.get("workspace.xml");
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor(path);
        EnumSet options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
        for (Path root: roots) {
            if (!searchFileVisitor.isFileFound()) {
                Files.walkFileTree(root, options, Integer.MAX_VALUE, searchFileVisitor);
            }
        }
    }

    @Test
    public void testDeleteFile() throws Exception {
        var directory = Paths.get("d:\\temp4");
        var deleteFileVisitor = new DeleteFileVisitor();
        EnumSet options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(directory, options, Integer.MAX_VALUE, deleteFileVisitor);
    }
}
