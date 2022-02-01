package concurrency;

import java.util.Random;
import java.util.concurrent.*;

public final class AssemblyLine {

    private static ExecutorService producerService;
    private static ExecutorService consumerService;
    private static final int MAX_PROD_TIME_MS = 5 * 1000;
    private static final int MAX_CONS_TIME_MS = 7 * 1000;
    private static final int TIMEOUT_MS = MAX_CONS_TIME_MS + 1000;
    private static final Random rnd = new Random();
    private static volatile boolean runningProducer;
    private static volatile boolean runningConsumer;
    private static Consumer consumer;
    private static Producer producer;
    private static final TransferQueue<String> queue = new LinkedTransferQueue<>();

    private AssemblyLine() {
        throw new AssertionError("There is a single assembly line!");
    }

    public static void startAssemblyLine() {

        if (runningProducer || runningConsumer) {
            System.out.println("Assembly line is already running ...");
            return;
        }

        System.out.println("\n\nStarting assembly line ...");
        System.out.println("Remaining bulbs from previous run: \n"
                + queue + "\n\n");

        runningProducer = true;
        producerService = Executors.newSingleThreadExecutor();
        producer = new Producer();
        producerService.execute(producer);

        runningConsumer = true;
        consumerService = Executors.newSingleThreadExecutor();
        consumer = new Consumer();
        consumerService.execute(consumer);
    }

    public static void stopAssemblyLine() {

        System.out.println("Stopping assembly line ...");

        boolean isProducerDown = shutdownProducer();
        boolean isConsumerDown = shutdownConsumer();

        if (!isProducerDown || !isConsumerDown) {
            System.out.println("Something abnormal happened during  shutting down the assembling line!");

            System.exit(0);
        }

        System.out.println("Assembling line was successfully stopped!");
    }

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (runningProducer) {
                try {
                    String bulb = "bulb-" + rnd.nextInt(1000);

                    Thread.sleep(rnd.nextInt(MAX_PROD_TIME_MS));

                    boolean transfered = queue.tryTransfer(bulb,
                            TIMEOUT_MS, TimeUnit.MILLISECONDS);

                    if (transfered) {
                        System.out.println("Checked: " + bulb);
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    System.out.println("Exception: " + ex);
                    break;
                }
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (runningConsumer) {
                try {
                    String bulb = queue.poll(
                            MAX_PROD_TIME_MS, TimeUnit.MILLISECONDS);

                    if (bulb != null) {
                        Thread.sleep(rnd.nextInt(MAX_CONS_TIME_MS));
                        System.out.println("Packed: " + bulb);
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    System.out.println("Exception: " + ex);
                    break;
                }
            }
        }
    }



    private static boolean shutdownProducer() {
        runningProducer = false;
        return shutdownExecutor(producerService);
    }

    private static boolean shutdownConsumer() {
        runningConsumer = false;
        return shutdownExecutor(consumerService);
    }

    private static boolean shutdownExecutor(ExecutorService executor) {

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT_MS * 2,
                    TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
                return executor.awaitTermination(TIMEOUT_MS * 2,
                        TimeUnit.MILLISECONDS);
            }

            return true;
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            System.out.println("Exception: " + ex);
        }

        return false;
    }
}
