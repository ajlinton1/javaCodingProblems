package concurrency;

import org.junit.Test;

// C:\Projects\Java-Coding-Problems\Chapter10\P205_ThreadPoolWorkStealing_LinkedBlockingQueue\src\modern\challenge\Main.java

public class TestWorkStealingThreadPool205 {

    @Test
    public void testThreadPoolWorkStealing_LinkedBlockingQueue() {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        concurrency.threadPoolWorkStealing_LinkedBlockingQueue.AssemblyLine.startAssemblyLine();
    }

    // C:\Projects\Java-Coding-Problems\Chapter10\P205_ThreadPoolWorkStealing_LinkedBlockingQueue_SplitQueue\src\modern\challenge\AssemblyLine.java

    @Test
    public void testThreadPoolWorkStealing_LinkedBlockingQueue_SplitQueue() {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tF %1$tT] [%4$-7s] %5$s %n");

        concurrency.threadPoolWorkStealing_LinkedBlockingQueue_SplitQueue.AssemblyLine.startAssemblyLine();
    }
}
