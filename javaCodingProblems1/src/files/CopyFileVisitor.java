package files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CopyFileVisitor implements FileVisitor {

    private final Path copyFrom;
    private final Path copyTo;

    public CopyFileVisitor(Path copyFrom, Path copyTo) {
        this.copyFrom = copyFrom;
        this.copyTo = copyTo;
    }

    private static void copySubTree(Path copyFrom, Path copyTo) throws IOException {
        Files.copy(copyFrom, copyTo, REPLACE_EXISTING, COPY_ATTRIBUTES);
    }

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        Path newDir = copyTo.resolve(copyFrom.relativize((Path)dir));

        try {
            Files.copy((Path)dir, newDir, REPLACE_EXISTING, COPY_ATTRIBUTES);
        } catch (IOException e) {
            System.err.println(e);
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        try {
            copySubTree((Path)file, copyTo.resolve(copyFrom.relativize((Path)file)));
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
        if (exc instanceof FileSystemLoopException) {
            System.err.println("Loop was detected");
        } else {
            System.err.println(exc);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
        Path newDir = copyTo.resolve(copyFrom.relativize((Path)dir));
        try {
            FileTime time = Files.getLastModifiedTime((Path)dir);
            Files.setLastModifiedTime(newDir, time);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return FileVisitResult.CONTINUE;
    }
}
