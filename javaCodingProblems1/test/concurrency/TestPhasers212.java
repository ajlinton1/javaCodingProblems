package concurrency;

import org.junit.Test;
import concurrency.phasers.*;

public class TestPhasers212 {

    @Test
    public void testPhasers() throws InterruptedException {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        Thread server = new Thread(new ServerInstance());
        server.start();
        server.join();
    }
}
