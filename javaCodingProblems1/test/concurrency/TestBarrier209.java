package concurrency;

import org.junit.Test;
import concurrency.barrier.*;

import java.util.logging.Logger;

public class TestBarrier209 {

    private static final Logger logger = Logger.getLogger(ServerService.class.getName());

    @Test
    public void testBarrier() throws InterruptedException {
        Thread server = new Thread(new ServerInstance());
        server.start();
        server.join();
    }
}
