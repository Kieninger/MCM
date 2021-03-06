/*
 * Florian Kieninger - S1510455013
 */
/*************************************************************************
 *  Compilation:  javac RingBuffer.java
 *  Execution:    java RingBuffer
 *
 *  Ring buffer (fixed size queue) implementation using a circular array
 *  (array with wrap-around).
 *
 *************************************************************************/

package at.fhhagenberg.sqe.exercise2;

import java.util.Iterator;
import java.util.NoSuchElementException;

// suppress unchecked warnings in Java 1.5.0_6 and later
@SuppressWarnings("unchecked")

public class RingBuffer<Item> implements Iterable<Item> {
    private Item[] a;            // queue elements
    private int N = 0;           // number of elements on queue
    private int first = 0;       // index of first element of queue
    private int last  = 0;       // index of next available slot

    // cast needed since no generic array creation in Java
    public RingBuffer(int capacity) {
        a = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() { return N == 0; }
    public int size()        { return N;      }

    public void enqueue(Item item) throws RingBufferException {
        if (N == a.length) { throw new RingBufferException("Ring buffer overflow"); }
        a[last] = item;
        last = (last + 1) % a.length;     // wrap-around
        N++;
    }

    // remove the least recently added item - doesn't check for underflow
    public Item dequeue() throws RingBufferException {
        if (isEmpty()) { throw new RingBufferException("Ring buffer underflow"); }
        Item item = a[first];
        a[first] = null;                  // to help with garbage collection
        N--;
        first = (first + 1) % a.length;   // wrap-around
        return item;
    }

    public Iterator<Item> iterator() { return new RingBufferIterator(); }

    // an iterator, doesn't implement remove() since it's optional
    public class RingBufferIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext()  { return i < N;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i++];
        }
    }

}

