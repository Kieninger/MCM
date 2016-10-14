/*
 * Florian Kieninger - S1510455013
 */
package at.fhhagenberg.sqe.exercise2;

import junit.framework.TestCase;

public class EmptyRingBufferTest extends TestCase {

    public void testEmptyRingBuffer() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        try {
            ringBuffer.dequeue();
            fail("Exception was expected");
        } catch (RingBufferException ringBufferException) {
            assertEquals("Ring buffer underflow", ringBufferException.getMessage());
        }
    }

}
