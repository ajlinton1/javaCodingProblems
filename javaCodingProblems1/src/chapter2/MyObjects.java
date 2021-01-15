package chapter2;

import java.util.function.Supplier;

public class MyObjects {

    public static <T, X extends Throwable> T requireNonNullElseThrow(T obj, Supplier<? extends X> exceptionSupplier) throws X {
        if (obj == null) {
            throw exceptionSupplier.get();
        }
        return obj;
    }

    public static <T> T defaultIfNull(T obj, Supplier<T> defaultSupplier) {
        if (obj == null) {
            return defaultSupplier.get();
        }
        return obj;
    }

}
