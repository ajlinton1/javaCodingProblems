package concurrency;

import concurrency.latches.ServerInstance;
import org.junit.Test;

public class TestLatches208 {

    @Test
    public void testLatches() throws InterruptedException {
        Thread server = new Thread(new ServerInstance());
        server.start();
        server.join();
    }
}
