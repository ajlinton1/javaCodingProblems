package chapter2;

import java.util.function.Supplier;

public class MyObjects {

    public static <T, X extends Throwable> T requireNonNullElseThrow(T obj, X exception) throws X {
        if (obj == null) {
            throw exception;
        }
        return obj;
    }

    public static <T, X extends Throwable> T requireNonNullElseThrow1(T obj, Supplier<? extends X> exceptionSupplier) throws X {
        if (obj == null) {
            throw exceptionSupplier.get();
        }
        return obj;
    }
}
