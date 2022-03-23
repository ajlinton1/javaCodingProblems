package concurrency;

import org.junit.Test;
import concurrency.callableFuture.AssemblyLine;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;

public class TestCallableFuture206 {

    @Test
    public void testCallableFuture() throws InterruptedException {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        AssemblyLine.startAssemblyLine();
        Thread.sleep(30 * 1000);
        AssemblyLine.stopAssemblyLine();

    }

    @Test
    public void testCancel() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(3000);

            return "Task completed";
        });

        while (!future.isDone()) {
            System.out.println("Task is in progress ...");
            Thread.sleep(100);

            long elapsedTime = (System.currentTimeMillis() - startTime);

            if (elapsedTime > 1000) {
                future.cancel(true);
            }
        }

        System.out.println("Task was cancelled: " + future.isCancelled()
                + "\nTask is done: " + future.isDone());
    }

}
