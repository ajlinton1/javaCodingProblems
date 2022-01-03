package functional;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

public class MelonCollector implements Collector<Melon, Map<Boolean, List<Melon>>, Map<Boolean, List<Melon>>> {

    @Override
    public Supplier<Map<Boolean, List<Melon>>> supplier() {

        return () -> {
            return new HashMap<Boolean, List<Melon>>() {
                {
                    put(true, new ArrayList<>());
                    put(false, new ArrayList<>());
                }
            };
        };
    }

    @Override
    public BiConsumer<Map<Boolean, List<Melon>>, Melon> accumulator() {

        return (var acc, var melon) -> {
            acc.get(melon.getWeight() > 2000).add(melon);
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Melon>>> combiner() {

        return (var map, var addMap) -> {
            map.get(true).addAll(addMap.get(true));
            map.get(false).addAll(addMap.get(false));

            return map;
        };
    }

    @Override
    public Function<Map<Boolean, List<Melon>>,
            Map<Boolean, List<Melon>>> finisher() {

        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(IDENTITY_FINISH, CONCURRENT);
    }
}