package functional;

import org.junit.Assert;
import org.junit.Test;

public class TestCascadedBuilder {

    @Test
    public void testCascadedBuilder() {
        Delivery.deliver(d -> d.firstname("Mark")
                .lastname("Kyilt")
                .address("25 Street, New York")
                .content("10 books"));
    }
}
