package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- natjac99

/**
 * 
 * @author Natalia Jacobo (natjac99)
 * @version 04.16.2019
 *
 */
public class SongIteratorTest extends student.TestCase {
    @SuppressWarnings("rawtypes")
    private SongIterator iter;


    /**
     * This is the set up methods for tests
     */
    @SuppressWarnings("rawtypes")
    public void setUp() {
        iter = new SongIterator();
    }

/**
 * This is the remove last test
 */
    @SuppressWarnings("unchecked")
    public void testRemoveLast() {
        assertFalse(iter.removeLast(1));
        iter.put(1, "one");
        assertTrue(iter.contains(1));
        assertTrue(iter.removeLast(1));
        assertFalse(iter).contains(1));
        iter.put(1, "1.one");
        iter.put(1, "1.two");
        iter.put(1, "1.three");
        assertTrue(iter.removeLast(1));
        assertEquals("[1, 1]", iter.toString());
        assertEquals("1.two", iter.getLast(1));
    }


/**
 * This is the test fortestNull  
 */
    @SuppressWarnings({ "unchecked", "unchecked", "unchecked" })
    public void testNext() {
        Exception exp = null;
        @SuppressWarnings("unchecked")
        Iterator<Integer> itty = iter.iterator();
        assertTrue(iter).isEmpty());
        assertEquals(0, iter.size());
        try {
            itty.next();
            
        }
        catch (Exception e)
        {
            exp = e;
        }
        assertTrue(exp instanceof NoSuchElementException);
        assertFalse(iter.removeFirst(1));
        iter.addFirst(1, "s");
        iter.addFirst(2, "d");
        iter.addLast(3, "ee");
        assertEquals(3, iter.size());
    }

/**
 * This is the test other classes
 */
    @SuppressWarnings({ "unchecked", "unchecked" })
    public void testOther() {
        assertNull(iter.getFirst(1));
        iter.addFirst(1, "bb");
        assertTrue(iter.removeFirst(1));
        assertFalse(iter.removeFirst(1));
    }

}
