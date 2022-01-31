package concurrency;

import org.junit.Assert;
import org.junit.Test;
import java.util.concurrent.*;

public class TestExecutor201 {

    @Test
    public void testExecutor() {
        SimpleExecutor se = new SimpleExecutor();

        se.execute(() -> {
            System.out.println("Simple task executed via Executor interface");
        });
    }

    class SimpleExecutor implements Executor {

        @Override
        public void execute(Runnable r) {
            (new Thread(r)).start();
        }
    }
}
