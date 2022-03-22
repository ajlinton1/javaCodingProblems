package concurrency;

import org.junit.Assert;
import org.junit.Test;


public class TestThreadPool204 {

    // C:\Projects\Java-Coding-Problems\Chapter10\P204_ThreadPoolCached_LinkedBlockingQueue\src\modern\challenge\Main.java

    @Test
    public void testThreadPoolCached_LinkedBlockingQueue() throws InterruptedException {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        concurrency.threadPoolCached_LinkedBlockingQueue.AssemblyLine.startAssemblyLine();
        Thread.sleep(90 * 1000 * 3);
        concurrency.threadPoolCached_LinkedBlockingQueue.AssemblyLine.stopAssemblyLine();
    }
}
