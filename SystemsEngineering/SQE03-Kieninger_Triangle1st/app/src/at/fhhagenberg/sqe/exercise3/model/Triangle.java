/*
 * Florian Kieninger - S1510455013
 */
package at.fhhagenberg.sqe.exercise3.model;

/**
 * Represents the model of a triangle.
 */
public class Triangle {

    /**
     * Creates a new triangle model.
     * Returns {@code null} if one value is negative.
     * Returns {@code null} if one value is bigger than the other two combined.
     *
     * @param a {@link double}: Side a of the triangle.
     * @param b {@link double}: Side b of the triangle.
     * @param c {@link double}: Side c of the triangle.
     * @return The created triangle.
     * @throws TriangleException {@link TriangleException}: Thrown if on value is negative or one value is bigger than the other two combined.
     */
    public static Triangle create(double a, double b, double c) throws TriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new TriangleException(TriangleException.Type.NEGATIVE_VALUE);
        }

        if(a + b <= c || a + c <= b || b + c <= a) {
            throw new TriangleException(TriangleException.Type.INVALID_VALUE);
        }

        return new Triangle(a, b, c);
    }

    /**
     * Checks if the values are valid for a triangle.
     * The triangle is valid if all values are positive and one value is not bigger than the other two combined.
     *
     * @param a {@link double}: Side a of the triangle.
     * @param b {@link double}: Side b of the triangle.
     * @param c {@link double}: Side c of the triangle.
     * @return {@link boolean}: Returns {@code true}, if the values are valid, {@code false} otherwise.
     */
    public static boolean isValid(double a, double b, double c) {
        try {
            Triangle.create(a, b, c);
            return true;
        } catch (TriangleException exception) {
            return false;
        }
    }

    private double a;
    private double b;
    private double c;

    private Triangle(double a, double b, double c) {
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