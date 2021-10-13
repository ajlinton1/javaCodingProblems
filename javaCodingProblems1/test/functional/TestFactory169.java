package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestFactory169 {

    @Test
    public void testFactory() {
        var factory = new Factory();
        var vehicle = factory.produce("Car");
        Assert.assertNotNull(vehicle);
    }

    interface Vehicle {
        void drive();
    }

    class Car implements Vehicle {

        @Override
        public void drive() {
            System.out.println("Drive car");
        }
    }

    class Truck implements Vehicle {

        @Override
        public void drive() {
            System.out.println("Drive truck");
        }
    }

    interface VehicleFactory {

        Vehicle produce();

    }

    class Factory {

        Map<String, VehicleFactory> factoryMap = new HashMap<>();

        public Factory() {
            factoryMap.put("Car", () -> {return new Car();});
            factoryMap.put("Truck", () -> {return new Truck();});
        }

        public Vehicle produce(String vehicleType) {
            var factory = factoryMap.get(vehicleType);
            return factory.produce();
        }
    }
}
