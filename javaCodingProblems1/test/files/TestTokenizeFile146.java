package files;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;

public class TestTokenizeFile146 {

    @Test
    public void testTokenizeFile() throws IOException {
        var path = Paths.get("C:\\Users\\Andy\\OneDrive\\CrunchBase\\20210814\\companies-all-8-14-2021.csv");
        var result = FileTokenizer.get(path, Charset.defaultCharset(), ",");
        Assert.assertNotNull(result);
    }
}
