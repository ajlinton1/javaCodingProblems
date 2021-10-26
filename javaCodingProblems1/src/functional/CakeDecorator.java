package functional;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class CakeDecorator {

    private Function<Cake, Cake> decorator;

    public CakeDecorator(Function<Cake, Cake>...decorators) {
        reduceDecorators(decorators);
    }

    public Cake decorate(Cake cake) {
        return decorator.apply(cake);
    }

    private void reduceDecorators(Function<Cake, Cake>...decorators) {
        decorator = Stream.of(decorators).reduce(Function.identity(), Function::andThen);
    }
}
