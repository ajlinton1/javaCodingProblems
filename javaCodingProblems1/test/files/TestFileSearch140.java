package files;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TestFileSearch140 {

    @Test
    public void testFindString() throws IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\javaCodingProblems1\\test\\files\\testData.txt");
        var count = countOccurrences(path, "11", Charset.defaultCharset());
        Assert.assertEquals(1, count);
    }

    public static int countOccurrences(Path path, String text, Charset ch) throws IOException {
        int count = 0;
        try (BufferedReader br = Files.newBufferedReader(path, ch)) {
            String line;
            while ((line = br.readLine()) != null) {
                count += countStringInString(line, text);
            }
        }
        return count;
    }

    @Test
    public void testFindString1() throws IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\javaCodingProblems1\\test\\files\\testData.txt");
        var count = countOccurrences1(path, "11", Charset.defaultCharset());
        Assert.assertEquals(1, count);
    }

    @Test
    public void testFindString2() throws IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\javaCodingProblems1\\test\\files\\testData.txt");
        var count = countOccurrences2(path, "11", Charset.defaultCharset());
        Assert.assertEquals(1, count);
    }

    @Test
    public void testFindString3() throws IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\javaCodingProblems1\\test\\files\\testData.txt");
        var count = countOccurrences3(path, "11", Charset.defaultCharset());
        Assert.assertEquals(1, count);
    }

//    @Test
    public void testFindString4() throws IOException {
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\javaCodingProblems1\\test\\files\\testData.txt");
        var count = countOccurrences4(path, "11");
        Assert.assertEquals(1, count);
    }

    public static int countOccurrences1(Path path, String text, Charset ch) throws IOException {
        return Files.readAllLines(path, ch).parallelStream()
                .mapToInt((p)->countStringInString(p,text))
                .sum();
    }

    public static int countOccurrences2(Path path, String text, Charset ch) throws IOException {
        return Files.lines(path, ch).parallel()
                .mapToInt((p)->countStringInString(p,text))
                .sum();
    }

    public static long countOccurrences3(Path path, String text, Charset ch) throws IOException {
        long count;
        try (Scanner scanner = new Scanner(path, ch).useDelimiter(Pattern.quote(text))) {
            count = scanner.tokens().count() -1;
        }
        return count;
    }

    private static int countStringInString(String string, String toFind) {
        return string.split(Pattern.quote(toFind), -1).length -1;
    }

    private static final int MAP_SIZE = 5242880; // 5 MB in bytes

    public static int countOccurrences4(Path path, String text)
            throws IOException {

        final byte[] texttofind = text.getBytes(StandardCharsets.UTF_8);
        int count = 0;

        try (FileChannel fileChannel = FileChannel.open(path,
                StandardOpenOption.READ)) {
            int position = 0;
            long length = fileChannel.size();

            while (position < length) {
                long remaining = length - position;
                int bytestomap = (int) Math.min(MAP_SIZE, remaining);

                MappedByteBuffer mbBuffer = fileChannel.map(
                        FileChannel.MapMode.READ_ONLY, position, bytestomap);

                int limit = mbBuffer.limit();
                int lastSpace = -1;
                int firstChar = -1;

                while (mbBuffer.hasRemaining()) {
                    // spaghetti code omitted for brevity
                    position++;
                }
            }
        }

        return count;
    }
}
