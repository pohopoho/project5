package prj5;

public class LListTest extends student.TestCase {
    LList<String> list;


    public void setUp() {
        list = new LList<String>();
    }


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
        assertEquals(list.getEntry(0), "john");
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
        assertEquals(list.getEntry(0), "beatles");
        list.add(1, "coldplay");
        assertEquals(list.getLength(), 2);
        assertEquals(list.getEntry(0), "coldplay");
        //assertEquals(list.getEntry(0), "coldplay");
        //list.add("greenday");
        //list.add("beyonce"); 
        /*list.add(1, "Maroon5");
        assertEquals(list.getEntry(1), "Maroon5");
        // tests clear()
        list.clear();
        assertEquals(list.getLength(), 0);*/
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
        list.add("mariah");
        list.add("carey");
        try {
            list.getEntry(2);
        }
        catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
    }


    /**
     * This method tests the remove method that removes an entry at a specific
     * index
     */
    public void testRemove() {
        list.clear();  
        boolean thrown = true;
        try {
            list.remove(1);
        }
        catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
        list.add("taylor");  
        list.add("swift");
        try {
            list.remove(2);
        }
        catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
        list.add("tim"); 
        list.add("mcGraw");  
        //assertEquals(list.remove(1), "taylor");
        assertEquals(list.getLength(), 4);
    }  
     
    /**
     * tests the remove(T) method
     */
    public void testRemoveEntry() {
        assertFalse(list.remove("jayZ"));
        assertFalse(list.remove(null));
        list.add("miley");
        list.add("cyrus");
        list.add("carly");
        list.add("rae");
        assertTrue(list.remove("carly"));
        //assertFalse(list.remove("drake"));
        
    }
}
