package files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class FileTokenizer {

    public static List<String> get(Path path, Charset cs, String delimiter) throws IOException {
        String delimiterStr = Pattern.quote(delimiter);
        List<String> content = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiterStr);
                content.addAll(Arrays.asList(values));
            }
        }
        return content;
    }

}
