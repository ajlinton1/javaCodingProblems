package concurrency;

import concurrency.threadPoolSingleThread_TransferQueue.AssemblyLine;
import concurrency.threadPoolSingleThread_TransferQueue.AssemblyLineProducer;
import org.junit.Test;

import java.util.concurrent.*;

public class TestThreadPool202 {

    // C:\Projects\Java-Coding-Problems\Chapter10\P202_ThreadPoolSingleThread_TransferQueue\src\modern\challenge\AssemblyLine.java

    private static final TransferQueue<String> queue = new LinkedTransferQueue<>();

    @Test
    public void testAssemblyLine() throws InterruptedException {
        AssemblyLine.startAssemblyLine();
        Thread.sleep(10 * 1000);
        AssemblyLine.stopAssemblyLine();
    }

    @Test
    public void testAssemblyLineProducer() throws InterruptedException {
        AssemblyLineProducer.startAssemblyLine();
        Thread.sleep(10 * 1000);
        AssemblyLineProducer.stopAssemblyLine();
        Thread.sleep(10 * 1000);
        AssemblyLineProducer.startAssemblyLine();
        Thread.sleep(10 * 1000);
        AssemblyLineProducer.stopAssemblyLine();
    }



}


