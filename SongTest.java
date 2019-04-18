package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- natjac99

/**
 * 
 * @author Natalia Jacobo (natjac99)
 * @version 04.16.1999
 *          This is the test class for song
 */
public class SongTest extends student.TestCase {
    private Song song1;
    private Song song2;


    /**
     * This is the setUP method for the test class
     */
    public void setUp() {
        song1 = new Song("Year 3000", "Jonas Brothers", 2006, "Pop");
        song2 = new Song("Chicken Fried", "Zac Brown Band", 2008, "Country");
    }


    /**
     * This is the test for getTitle() method.
     */
    public void testGetTitle() {
        assertEquals(song1.getTitle(), "Year 3000");
        assertEquals(song2.getTitle(), "Chicken Fried");
    }


    /**
     * This is the test for the getArtist() method.
     */
    public void testGetArtist() {
        assertEquals(song1.getArtist(), "Jonas Brothers");
        assertEquals(song2.getArtist(), "Zac Brown Band");
    }


    /**
     * This is the test for the getYear() method.
     */
    public void testGetYear() {
        assertEquals(song1.getYear(), 2006);
        assertEquals(song2.getYear(), 2008);
    }


    /**
     * This is the test for getGenre() method.
     */
    public void testGetGenre() {
        assertEquals(song1.getGenre(), "Pop");
        assertEquals(song2.getGenre(), "Country");
    }
}