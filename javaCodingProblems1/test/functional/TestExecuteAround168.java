package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Consumer;

public class TestExecuteAround168 {

    @Test
    public void testExecuteAround() {
        log(this::method1, "test");
    }

    void method1(String arg) {
        System.out.println("Method1 called " + arg);
    }

    void log(Consumer<String> consumer, String arg) {
        System.out.println("Starting call");
        consumer.accept(arg);
        System.out.println("Completed call");
    }
}
