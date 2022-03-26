package concurrency;

import org.junit.Test;
import concurrency.barrier.*;

import java.util.concurrent.CyclicBarrier;
import java.util.logging.Logger;

public class testBarrier209 {

    private static final Logger logger = Logger.getLogger(ServerService.class.getName());

    @Test
    public void testBarrier() throws InterruptedException {
        Thread server = new Thread(new ServerInstance());
        server.start();
        server.join();
    }
}
