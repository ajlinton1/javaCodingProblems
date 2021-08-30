package files;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestTokenizeFile146 {

    @Test
    public void testTokenizeFile() throws IOException {
        var path = Paths.get("C:\\Users\\ajlin\\OneDrive\\CrunchBase\\20210814\\companies-all-8-14-2021.csv");
        var result = FileTokenizer.get(path, Charset.defaultCharset(), ",");
        Assert.assertNotNull(result);
    }

    @Test
    public void testTokenizeFile1() throws IOException {
        var path = Paths.get("C:\\Users\\ajlin\\OneDrive\\CrunchBase\\20210814\\companies-all-8-14-2021.csv");
        var result = FileTokenizer.get1(path, Charset.defaultCharset(), ",");
        Assert.assertNotNull(result);
    }

    @Test
    public void testTokenizeFile2() throws IOException {
        var path = Paths.get("C:\\Users\\ajlin\\OneDrive\\CrunchBase\\20210814\\companies-all-8-14-2021.csv");
        var result = FileTokenizer.get2(path, Charset.defaultCharset(), ",");
        Assert.assertNotNull(result);
    }

    @Test
    public void testTokenizeFile3() throws IOException {
        var path = Paths.get("C:\\Users\\ajlin\\OneDrive\\CrunchBase\\20210814\\companies-all-8-14-2021.csv");
        var result = Files.readAllLines(path, Charset.defaultCharset()).stream()
                .map(l -> l.split(Pattern.quote(",")))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        Assert.assertNotNull(result);
    }

    @Test
    public void testTokenizeFile4() throws IOException {
        var path = Paths.get("C:\\Users\\ajlin\\OneDrive\\CrunchBase\\20210814\\companies-all-8-14-2021.csv");
        var result = FileTokenizer.get4(path, Charset.defaultCharset(), ",");
        Assert.assertNotNull(result);
    }
}
