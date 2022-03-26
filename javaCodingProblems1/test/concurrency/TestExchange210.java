package concurrency;

import concurrency.exchangers.AssemblyLine;
import org.junit.Test;

public class TestExchange210 {

    // C:\Projects\Java-Coding-Problems\Chapter10\P210_Exchangers\src\modern\challenge\Main.java

    @Test
    public void testExchange() throws InterruptedException {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        AssemblyLine.startAssemblyLine();
        Thread.sleep(60 * 1000);
        AssemblyLine.stopAssemblyLine();

    }
}
