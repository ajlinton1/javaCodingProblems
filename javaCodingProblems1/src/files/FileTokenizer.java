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
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static List<String> get1(Path path, Charset cs, String delimiter) throws IOException {
        String delimiterStr = Pattern.quote(delimiter);
        List<String> content = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;
            while ((line = br.readLine()) != null) {
                content.addAll(Stream.of(line.split(delimiterStr))
                        .collect(Collectors.toList()));
            }
        }
        return content;
    }

    public static List<String> get2(Path path, Charset cs, String delimiter) throws IOException {
        try (Stream<String> lines = Files.lines(path, cs)) {
            return lines.map(l -> l.split(Pattern.quote(delimiter)))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());
        }
    }


    public static List<String> get4(Path path,
                                   Charset cs, String delimiter) throws IOException {

        Pattern pattern = Pattern.compile(Pattern.quote(delimiter));
        List<String> content = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(path, cs)) {

            String line;
            while ((line = br.readLine()) != null) {
                content.add(pattern.splitAsStream(line)
                        .collect(Collectors.joining(";")));
            }
        }
        return content;
    }

}
