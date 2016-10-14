/*
 * Florian Kieninger - S1510455013
 */
package at.fhhagenberg.sqe.exercise3.model;

/**
 * Represents a triangle exception.
 */
public class TriangleException extends Exception {

    public enum Type {
        /**
         * A negative value was used to create a triangle.
         */
        NEGATIVE_VALUE,

        /**
         * Invalid values were used to create a triangle.
         */
        INVALID_VALUE
    }

    private Type type;

    /**
     * Constructor using fields.
     *
     * @param type {@link Type}: The type of the exception.
     */
    TriangleException(Type type) {
        super();
        this.type = type;
    }

    /**
     * Gets the type.
     *
     * @return {@link Type}: The type.
     */
    public Type getType() {
        return type;
    }
}
