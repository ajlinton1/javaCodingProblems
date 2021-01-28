package chapter2;

import org.junit.Assert;
import org.junit.Test;

public class TestSwitch {

    @Test
    public void testSwitch() {
        String state = "MA";

        switch (state) {
            case "MA":
                System.out.println("Mass");
                break;
            case "NY":
                System.out.println("New York");
                break;
            default:
                System.out.println("Unknown state");
        }
    }

    private String switchExpression(String shortString) {
        return switch(shortString) {
            case "MA" -> "Mass";
            case "NY" -> "New York";
            default -> "Unknown";
        };
    }

    @Test
    public void testSwitchExpression() {
        String result = switchExpression("MA");
        Assert.assertEquals("Mass", result);
    }

}
