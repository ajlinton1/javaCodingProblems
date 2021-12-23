package functional;

import java.util.List;
import java.util.Objects;

public class Melon {
    enum Sugar {
        LOW, MEDIUM, HIGH, UNKNOWN
    }

    private final String type;
    private int weight;
    private final Sugar sugar;
    private List<String> pests;

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

    public Melon(String type, int weight, List<String> pests) {
        this.type = type;
        this.weight = weight;
        this.pests = pests;
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

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Sugar getSugar() {
        return sugar;
    }

    public List<String> getPests() {
        return pests;
    }

    public static int growing100g(Melon melon) {
        melon.setWeight(melon.getWeight() + 100);

        return melon.getWeight();
    }
}
