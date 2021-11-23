package arrays;

public class Melon implements Comparable {

    private int weight;
    private String name;

    public Melon(int weight) {
        this.weight = weight;
    }

    public Melon(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        var a = (Melon)o;
        return Integer.compare(this.getWeight(), a.getWeight());
    }

    public Melon getCopy() {
        return new Melon(getWeight());
    }
}
