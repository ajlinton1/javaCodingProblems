package functional;

import org.junit.Test;

import java.util.function.Consumer;

public class TestLoan173 {

    @Test
    public void testLoanPattern() {
        var connection = new Connection();
        connection.runWithTransaction((con) -> {
            System.out.println("Do update");
        });
    }

    class Connection{

        public void open() {}

        public void close() {}

        public void commit() {}

        public void runWithTransaction(Consumer<Connection> operation) {
            open();
            operation.accept(this);
            commit();
            close();
        }


    }
}
