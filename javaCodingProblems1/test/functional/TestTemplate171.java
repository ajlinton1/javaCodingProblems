package functional;

import org.junit.Assert;
import org.junit.Test;

public class TestTemplate171 {

    @Test
    public void testTemplate() {
        databaseOperation(() -> {
            System.out.println("Doing operation");
        });
    }

    void databaseOperation(IDatabaseOperation operation) {
        System.out.println("Open connection");
        operation.doOperation();
        System.out.println("Close connection");
    }

    @FunctionalInterface
    interface IDatabaseOperation {
        void doOperation();
    }
}
