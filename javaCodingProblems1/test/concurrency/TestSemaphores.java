package concurrency;

import concurrency.semaphores.Barbershop;
import concurrency.semaphores.BarbershopCustomer;
import org.junit.Assert;
import org.junit.Test;

public class TestSemaphores {

    @Test
    public void testSemaphores() {
        Barbershop bs = new Barbershop(3);

        for (int i = 1; i <= 10; i++) {
            BarbershopCustomer bc = new BarbershopCustomer(bs, i);
            new Thread(bc).start();
        }
    }
}
