/*
 * Florian Kieninger - S1510455013
 */
package at.fhhagenberg.sqe.exercise2;

import junit.framework.TestCase;

public class RingBufferTest extends TestCase {

    public void testIsEmpty() throws RingBufferException {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        assertEquals(true, ringBuffer.isEmpty());
        ringBuffer.enqueue(1);
        assertEquals(false, ringBuffer.isEmpty());
        ringBuffer.dequeue();
        assertEquals(true, ringBuffer.isEmpty());
    }

    public void testSize() throws RingBufferException {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        assertEquals(0, ringBuffer.size());
        ringBuffer.enqueue(1);
        assertEquals(1, ringBuffer.size());
        ringBuffer.enqueue(10);
        assertEquals(2, ringBuffer.size());
        ringBuffer.dequeue();
        assertEquals(1, ringBuffer.size());
        ringBuffer.dequeue();
        assertEquals(0, ringBuffer.size());
    }

    public void testEnqueue() throws RingBufferException {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        ringBuffer.enqueue(1);
        assertEquals(1, (int)ringBuffer.dequeue());
        ringBuffer.enqueue(10);
        ringBuffer.enqueue(20);
        assertEquals(10, (int)ringBuffer.dequeue());
        assertEquals(20, (int)ringBuffer.dequeue());
    }

    public void testDequeue() throws RingBufferException {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        ringBuffer.enqueue(1);
        assertEquals(1, ringBuffer.size());
        assertEquals(1, (int)ringBuffer.dequeue());
    }

}
