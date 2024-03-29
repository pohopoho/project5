package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is the linked list testClass
 * 
 * @author Punita Verma (punitav9)
 * @version 20.04.2019
 *
 */
public class LListTest extends student.TestCase {
    /**
     * This is the field for the list
     */
    private LList<String> list;


    /**
     * Setup for the test methods
     */
    public void setUp() {
        list = new LList<String>();
    }


    /**
     * Test for getLength
     */
    public void testGetLength() {
        assertEquals(list.getLength(), 0);
        list.add("adele");
        assertEquals(list.getLength(), 1);
    }


    /**
     * This method tests the add method when it adds a single entry to the end
     * of the list
     */
    public void testAddEntry() {
        assertEquals(list.getLength(), 0);
        list.add("john");
        assertEquals(list.getLength(), 1);
        assertEquals(list.getEntry(1), "john");
        list.clear();
    }


    /**
     * This test method tests the add method with two parameters
     */
    public void testAddEntryAtInt() {
        boolean thrown = false;
        try {
            list.add(4, "madonna");
        }
        catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
        list.add("beatles");
        assertEquals(list.getEntry(1), "beatles");
        list.add(2, "coldplay");
        assertEquals(list.getLength(), 2);
        assertEquals(list.getEntry(2), "coldplay");
        list.add("greenday");
        list.add("beyonce");
        list.add(1, "Maroon5");
        assertEquals(list.getEntry(1), "Maroon5");
        try {
            list.add(-2, "madonna");
        }
        catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
        list.clear();
        list.add(1, "hello");
        assertEquals(list.getEntry(1), "hello");
        list.add("is it me");
        list.add(2, "youre looking for");
        assertEquals(list.getEntry(2), "youre looking for");

    }


    /**
     * tests clear
     */
    public void testClear() {
        list.add("spice");
        list.add("girls");
        list.clear();
        assertEquals(list.getLength(), 0);
    }


    /**
     * This method tests the contains method
     */
    public void testContains() {
        assertFalse(list.contains("tupac"));
        list.add("tupac");
        assertTrue(list.contains("tupac"));
        assertFalse(list.contains(null));
        list.add("samSmith");
        assertFalse(list.contains("obama"));
    }


    /**
     * This test method tests the getEntry() method
     */
    public void testGetEntry() {
        boolean thrown = true;
        try {
            list.getEntry(-1);
        }
        catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
        list.add("mariah");
        list.add("carey");
        try {
            list.getEntry(3);
        }
        catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);

    }


    /**
     * This method tests the remove method that removes an entry at a specific
     * index
     */
    public void testRemove() {
        list.clear();
        boolean thrown = true;
        try {
            list.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
        try {
            list.remove(5);
        }
        catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
        list.add("taylor");
        list.remove(1);
        list.add("justin");
        list.add("swift");
        list.remove(2);
        list.add("tim");
        list.add("mcGraw");
        assertEquals(list.remove(2), "tim");
        assertEquals(list.getLength(), 2);
        list.clear();
        list.add("im bored");
        assertEquals(list.remove(1), "im bored");
    }


    /**
     * Tests the replace method
     */
    public void testReplace() {
        boolean thrown = false;
        try {
            list.replace(1, "s");
        }
        catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
        try {
            list.replace(-1, "s");
        }
        catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
        try {
            list.replace(1, null);
        }
        catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
        try {
            list.replace(42, "s");
        }
        catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
        list.clear();
        list.add("mJ");
        list.add("rihanna");
        assertEquals(list.replace(1, "kanye"), "mJ");
        list.add("oprah");
        assertEquals(list.replace(2, "nick"), "rihanna");
        assertEquals(list.replace(3, "joe"), "oprah");

    }


    /**
     * Tests toArray()
     */
    public void testToArray() {
        list.add("timberlake");
        list.add("justin");
        list.add("beiber");

        assertEquals(list.toArray().length, 3);
        list.add(null);
        assertEquals(list.toArray().length, 4);
    }


    /**
     * This method tests the equals method in the LList class
     */
    public void testEquals() {
        assertTrue(list.equals(list));
        LList<String> listNull = new LList<>();
        list.add("anEntry");
        assertFalse(list.equals(listNull));
        list.clear();
        String s = "hello";
        assertFalse(list.equals(s));
        list.add("wiggles");
        LList<String> list2 = new LList<>();
        assertFalse(list.equals(list2));
        list2.add("jay");
        assertFalse(list.equals(list2));
        list2.remove(1);
        list2.add("wiggles");
        assertTrue(list.equals(list2));
        LList<String> nullList = null;
        assertEquals(false, list.equals(nullList));
    }


    /**
     * Test for iterator
     */
    public void testIterator() {
        list.clear();
        Iterator<String> iter = list.iterator();

        Exception e = null;
        try {
            iter.next();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof NoSuchElementException);

        list.add("one");
        list.add("two");
        list.add("three");
        iter = list.iterator();
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), "one");

        assertEquals(iter.next(), "two");
        assertTrue(iter.hasNext());
        list.clear();
        iter = list.iterator();
        assertFalse(iter.hasNext());
        
    }
}