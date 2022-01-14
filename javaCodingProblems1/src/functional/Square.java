package functional;

public class Square implements Polygon {

    private final double edge;

    public Square(double edge) {
        this.edge = edge;
    }

    @Override
    public double area() {
        return Math.pow(perimeter(edge) / 4, 2);
    }

    @Override
    public double perimeter(double...segments) {
        return segments[0] * 4;
    }
}
