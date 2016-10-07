/*
 * Name: Florian Kieninger
 * ID: S1510455013
 */
package at.fhhagenberg.sqe.exercise1.business;

/**
 * Represents the model of a triangle.
 */
public class TriangleModel {

    /**
     * Creates a new triangle model.
     * Returns {@code null} if one value is negative.
     * Returns {@code null} if one value is bigger than the other two combined.
     *
     * @param a {@link double}: Side a of the triangle.
     * @param b {@link double}: Side b of the triangle.
     * @param c {@link double}: Side c of the triangle.
     * @return The created triangle.
     */
    public static TriangleModel create(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return null;
        }

        if(a + b < c || a + c < b || b + c < a) {
            return null;
        }

        return new TriangleModel(a, b, c);
    }

    private double a;
    private double b;
    private double c;

    private TriangleModel(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Gets the perimeter of the triangle.
     *
     * @return the perimeter of the triangle.
     */
    public double getPerimeter() {
        return a + b + c;
    }

    /**
     * Gets the area of the triangle.
     *
     * @return the area of the triangle.
     */
    public double getArea() {
        // Heron's Formula
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}