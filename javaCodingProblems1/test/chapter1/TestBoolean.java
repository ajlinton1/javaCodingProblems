package chapter1;

import org.junit.Assert;
import org.junit.Test;

public class TestBoolean {

    @Test
    public void booleanConditions() {
        int s = 10;
        int m = 21;
        if (Boolean.logicalAnd(m > s, s < m)) {
            Assert.assertEquals(true, true);
        } else {
            Assert.assertEquals(false, false);
        }
    }
}
