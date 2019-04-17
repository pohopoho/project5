/**
 * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Daniel Moreno (danielrm)
 */
package prj5;
import student.TestCase;

/**
 * Test class for Sorter.
 *
 * @author Daniel Moreno (danielrm)
 * @version 04/16/2019
 */
public class SorterTest extends TestCase{
    private Sorter sorter;
    private Song[] songs;
    
    public void setUp()
    {
        songs = new Song[4];
        songs[1] = new Song("titleB", "artistB", 1980, "genreB");
        songs[2] = new Song("titleC", "artistC", 1990, "genreC");
        songs[3] = new Song("titleA", "artistA", 2000, "genreA");
        
        //sorter = new Sorter(songs);
    }
    
    /**
     * Tests the sortByArtist method
     */
    public void testSortByArtist()
    {
        sorter.sortByArtist();
        assertEquals(songs[1].getArtist(), "artistA");
        assertEquals(songs[2].getArtist(), "artistB");
        assertEquals(songs[3].getArtist(), "artistC");
    }
    
    /**
     * Tests the sortByTitle method
     */
    public void testSortByTitle()
    {
        sorter.sortByTitle();
        assertEquals(songs[1].getTitle(), "titleA");
        assertEquals(songs[2].getTitle(), "titleB");
        assertEquals(songs[3].getTitle(), "titleC");
    }
    
    /**
     * Tests the sortByYear method
     */
    public void testSortByYear()
    {
        sorter.sortByYear();
        assertEquals(songs[1].getYear(), 1980);
        assertEquals(songs[2].getYear(), 1990);
        assertEquals(songs[3].getYear(), 2000);
    }
    
    /**
     * Tests the sortByGenre method
     */
    public void testSortByGenre()
    {
        sorter.sortByGenre();
        assertEquals(songs[1].getGenre(), "genreA");
        assertEquals(songs[2].getGenre(), "genreB");
        assertEquals(songs[3].getGenre(), "genreC");
    }
}
