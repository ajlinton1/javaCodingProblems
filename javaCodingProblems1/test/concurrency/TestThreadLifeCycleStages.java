package concurrency;

import org.junit.Assert;
import org.junit.Test;

public class TestThreadLifeCycleStages {

    @Test
    public void testThreadLifeCycleStages() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        });
        t.start();
        t.run();
        t.join();
        System.out.println("join");
        Assert.assertEquals(t.getState(), Thread.State.TERMINATED);
    }
}
