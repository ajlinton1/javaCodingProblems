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

    @Test
    public void testBlocked() throws InterruptedException {
        Thread t1 = new Thread(new SyncCode());
        Thread t2 = new Thread(new SyncCode());

        t1.start();
        Thread.sleep(2000);
        t2.start();
        Thread.sleep(2000);

        System.out.println("BlockedThread t1: "
                + t1.getState() + "(" + t1.getName() + ")");
        System.out.println("BlockedThread t2: "
                + t2.getState() + "(" + t2.getName() + ")");
    }

    private static class SyncCode implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName()
                    + " is in run() method");
            syncMethod();
        }

        public static synchronized void syncMethod() {
            System.out.println("Thread " + Thread.currentThread().getName()
                    + " is in syncMethod() method");

            while (true) {
                // t1 will stay here forever, therefore t2 is blocked
            }
        }
    }

    public void waitingThread() throws InterruptedException {
        new Thread(() -> {
            Thread t1 = Thread.currentThread();
            Thread t2 = new Thread(() -> {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("WaitingThread t1: "
                        + t1.getState()); // WAITING
            });

            t2.start();

            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }

    @Test
    public void testWaitingThread() throws InterruptedException {
        waitingThread();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(20000);
        }
    }

    @Test
    public void testTimedWaiting() throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();

        Thread.sleep(500);

        System.out.println("TimedWaitingThread t: "
                + t.getState()); // TIMED_WAITING
        Assert.assertEquals(Thread.State.TIMED_WAITING, t.getState());
    }

    @Test
    public void testTerminated() throws InterruptedException {
        Thread t = new Thread(() -> {

        });

        t.start();

        Thread.sleep(1000);

        System.out.println("TimedWaitingThread t: "
                + t.getState());
        Assert.assertEquals(Thread.State.TERMINATED, t.getState());
    }

}

