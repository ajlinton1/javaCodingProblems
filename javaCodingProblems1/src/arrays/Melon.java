package arrays;

public class Melon implements Comparable {

    private int weight;

    public Melon(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        var a = (Melon)o;
        return Integer.compare(this.getWeight(), a.getWeight());
    }
}
