package functional;

import java.util.Collection;
import java.util.stream.Stream;

public class AsStreams {

    public static <T> Stream<T> elementAsStream(T element) {
        return Stream.ofNullable(element);
    }

    public static <T> Stream<T> collectionAsStreamWithNulls(
            Collection<T> element) {
        return Stream.ofNullable(element).flatMap(Collection::stream);
    }

}
