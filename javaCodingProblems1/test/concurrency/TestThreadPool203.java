package concurrency;

import org.junit.Assert;
import org.junit.Test;

public class TestThreadPool203 {

    // C:\Projects\Java-Coding-Problems\Chapter10\P203_ThreadPoolFixed_TransferQueue\src\modern\challenge\Main.java

    @Test
    public void testThreadPool() throws InterruptedException {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tF %1$tT] [%4$-7s] %5$s %n");

        concurrency.threadPoolFixed_TransferQueue.AssemblyLine.startAssemblyLine();
        Thread.sleep(20 * 1000);
        concurrency.threadPoolFixed_TransferQueue.AssemblyLine.stopAssemblyLine();

        Thread.sleep(2000);

        concurrency.threadPoolFixed_TransferQueue.AssemblyLine.startAssemblyLine();
        Thread.sleep(15 * 1000);
        concurrency.threadPoolFixed_TransferQueue.AssemblyLine.stopAssemblyLine();
    }
}
