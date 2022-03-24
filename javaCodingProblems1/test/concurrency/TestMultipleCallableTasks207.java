package concurrency;

import org.junit.Test;

public class TestMultipleCallableTasks207 {

    @Test
    public void testMultipleCallable() {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        concurrency.multipleCallableTasks.AssemblyLine.startAssemblyLine();
    }

}
