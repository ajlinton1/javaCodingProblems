package functional;

import java.util.Objects;

public class Melon {
    enum Sugar {
        LOW, MEDIUM, HIGH, UNKNOWN
    }

    private final String type;
    private final int weight;
    private final Sugar sugar;

    public Melon(String type, int weight, Sugar sugar) {
        this.type = type;
        this.weight = weight;
        this.sugar = sugar;
    }

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
        this.sugar = Sugar.UNKNOWN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Melon melon = (Melon) o;
        return weight == melon.weight && Objects.equals(type, melon.type) && sugar == melon.sugar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight, sugar);
    }
    // constructors, getters, setters, equals(),
    // hashCode(), toString() omitted for brevity

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public Sugar getSugar() {
        return sugar;
    }
}
