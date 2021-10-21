package functional;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;

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

    @Test
    public void testFormula() throws IOException {
        double xPlusYMinusZ = Formula.compute((sc)
                -> sc.add().add().minus().result());
        Assert.assertTrue(xPlusYMinusZ > 0);
    }

    @Test
    public void testFormula1() throws IOException {
        double xMinusYMultiplySqrtZ = Formula.compute((sc)
                -> sc.add().minus().multiplyWithSqrt().result());
        Assert.assertTrue(xMinusYMultiplySqrtZ > 0);
    }

}
