package files;

import org.junit.Assert;
import org.junit.Test;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestJson141 {

    @Test
    public void testReadJson() throws IOException {
        Jsonb jsonb = JsonbBuilder.create();
        var path = Paths.get("C:\\Projects\\javaCodingProblems\\data\\songsOrphan.json");
        Object[] objects = jsonb.fromJson(Files.newBufferedReader(path, StandardCharsets.UTF_8), Object[].class);
        Assert.assertNotNull(objects);
    }

    @Test
    public void testReadCSV() throws IOException {
        var path = Paths.get("C:\\Users\\ajlin\\OneDrive\\CrunchBase\\boston-5-14-2020.csv");
        var result = readAsObject(path, Charset.defaultCharset(), ",");
        Assert.assertNotNull(result);
    }

    public static List<List<String>> readAsObject(Path path, Charset cs, String delimiter) throws IOException {
        List<List<String>> content = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                content.add(Arrays.asList(values));
            }
        }
        return content;
    }
}
