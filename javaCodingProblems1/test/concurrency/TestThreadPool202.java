package concurrency;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.*;

public class TestThreadPool202 {

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


