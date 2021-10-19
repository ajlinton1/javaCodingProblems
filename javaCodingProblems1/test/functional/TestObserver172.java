package functional;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TestObserver172 {

    @Test
    public void testObserver() {
        var observer = new Subject<String>();
        observer.addObserver((String s) -> {
            System.out.println("Observer 1: " + s);
        });
        observer.addObserver((String s) -> {
            System.out.println("Observer 2: " + s);
        });
        observer.emit("Test0");

        System.out.println("Done");
        // List of lambdas

        // Add and remove lambdas

        // Emit event method that calls all lambdas
    }

    class Subject<T> {

        List<Consumer<T>> registeredObservers = new ArrayList<>();

        public void addObserver(Consumer<T> observer) {
            registeredObservers.add(observer);
        }

        public void emit(T t){
            for (Consumer<T> observer: registeredObservers) {
                observer.accept(t);
            }
        }
    }
}
