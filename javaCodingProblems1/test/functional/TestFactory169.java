package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class TestFactory169 {

    @Test
    public void testFactory() {
        var factory = new Factory();
        var vehicle = factory.produce("Car");
        Assert.assertNotNull(vehicle);
        Assert.assertTrue(vehicle instanceof Car);
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

        Map<String, Supplier<Vehicle>> factoryMap = new HashMap<>();

        public Factory() {
            factoryMap.put("Car", Car::new);
            factoryMap.put("Truck", Truck::new);
        }

        public Vehicle produce(String vehicleType) {
            var factory = factoryMap.get(vehicleType);
            return factory.get();
        }
    }
}
