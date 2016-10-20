/*
 * Florian Kieninger - S1510455013
 */
package at.fhhagenberg.sqe.exercise3.model;

import junit.framework.TestCase;

/**
 * Represents the triangle test case.
 */
public class TriangleTest extends TestCase {

    public void testCreate_NegativeValueSideA() {
        try {
            Triangle.create(-5, 4, 3);
            fail("Exception expected");
        } catch (TriangleException e) {
            assertEquals(TriangleException.Type.NEGATIVE_VALUE, e.getType());
        }
    }

    public void testCreate_NegativeValueSideB() {
        try {
            Triangle.create(5, -4, 3);
            fail("Exception expected");
        } catch (TriangleException e) {
            assertEquals(TriangleException.Type.NEGATIVE_VALUE, e.getType());
        }
    }

    public void testCreate_NegativeValueSideC() {
        try {
            Triangle.create(5, 4, -3);
            fail("Exception expected");
        } catch (TriangleException e) {
            assertEquals(TriangleException.Type.NEGATIVE_VALUE, e.getType());
        }
    }

    public void testCreate_InvalidValueSideA() {
        try {
            Triangle.create(2, 1, 1);
            fail("Exception expected");
        } catch (TriangleException e) {
            assertEquals(TriangleException.Type.INVALID_VALUE, e.getType());
        }
    }

    public void testCreate_InvalidValueSideB() {
        try {
            Triangle.create(1, 2, 1);
            fail("Exception expected");
        } catch (TriangleException e) {
            assertEquals(TriangleException.Type.INVALID_VALUE, e.getType());
        }
    }

    public void testCreate_InvalidValueSideC() {
        try {
            Triangle.create(1, 1, 2);
            fail("Exception expected");
        } catch (TriangleException e) {
            assertEquals(TriangleException.Type.INVALID_VALUE, e.getType());
        }
    }

    public void testCreate() throws TriangleException {
        Triangle triangle = Triangle.create(5, 4, 3);
        assertNotNull(triangle);
    }

    public void testIsValid_NegativeValueSideA() {
        assertEquals(false, Triangle.isValid(-5, 4, 3));
    }

    public void testIsValid_NegativeValueSideB() {
        assertEquals(false, Triangle.isValid(5, -4, 3));
    }

    public void testIsValid_NegativeValueSideC() {
        assertEquals(false, Triangle.isValid(5, 4, -3));
    }

    public void testIsValid_InvalidValueSideA() {
        assertEquals(false, Triangle.isValid(2, 1, 1));
    }

    public void testIsValid_InvalidValueSideB() {
        assertEquals(false, Triangle.isValid(1, 2, 1));
    }

    public void testIsValid_InvalidValueSideC() {
        assertEquals(false, Triangle.isValid(1, 1, 2));
    }

    public void testIsValid() {
        assertTrue(Triangle.isValid(5, 4, 3));
    }

    public void testGetPerimeter() throws TriangleException {
        Triangle triangle = Triangle.create(5, 4, 3);
        assertEquals(12.0, triangle.getPerimeter());
    }

    public void testGetArea() throws TriangleException {
        Triangle triangle = Triangle.create(5, 4, 3);
        assertEquals(6.0, triangle.getArea());
    }

}
