/*
 * Florian Kieninger - S1510455013
 */
package at.fhhagenberg.sqe.exercise2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RingBufferTest.class,
        EmptyRingBufferTest.class
})
public class AllTests {}
