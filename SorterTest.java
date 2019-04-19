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
 * This is the SorterTest class. It tests the Sorter class by calling the four
 * different methods on a list of song objects.
 * 
 * @author Michael Cheung
 * @version 19.04.2019
 *
 */

public class SorterTest extends TestCase {

    // fields
    private LList<Song> songList;
    private Sorter sort;


    /**
     * This is the setUp method. It is called before every test method to
     * instantiate the list and sorter objects.
     */
    public void setUp() {
        songList = new LList<Song>();
        songList.add(new Song("Dogs", "Peep", 2000, "R&B"));
        songList.add(new Song("Cars", "Alice", 1999, "pop"));
        songList.add(new Song("Apples", "Bob", 1900, "rock"));
        songList.add(new Song("zap", "George", 2045, "pop"));
        songList.add(new Song("ocean", "walt", 3000, "country"));
        Song song = new Song("lucy", "loius", 1792, "alternative");
        songList.add(song);

        sort = new Sorter(songList);
    }


    /**
     * This test method tests the sortByYear() method and asserts the correct
     * years for the songs in the order they should appear in the list.
     */
    public void testSortYear() {
        sort.sortByYear();
        assertEquals(songList.getEntry(1).getYear(), 1792);
        assertEquals(songList.getEntry(2).getYear(), 1900);
        assertEquals(songList.getEntry(3).getYear(), 1999);
        assertEquals(songList.getEntry(4).getYear(), 2000);
        assertEquals(songList.getEntry(5).getYear(), 2045);
        assertEquals(songList.getEntry(6).getYear(), 3000);
    }


    /**
     * This test method tests the sortByTitle() method and asserts the correct
     * titles for the songs in the order they should appear in the list.
     */
    public void testSortTitle() {
        sort.sortByTitle();
        assertEquals(songList.getEntry(1).getTitle(), "Apples");
        assertEquals(songList.getEntry(2).getTitle(), "Cars");
        assertEquals(songList.getEntry(3).getTitle(), "Dogs");
        assertEquals(songList.getEntry(4).getTitle(), "lucy");
        assertEquals(songList.getEntry(5).getTitle(), "ocean");
        assertEquals(songList.getEntry(6).getTitle(), "zap");
    }


    /**
     * This test method tests the sortByArtist() method and asserts the correct
     * artists for the songs in the order they should appear in the list.
     */
    public void testSortArtist() {
        sort.sortByArtist();
        assertEquals(songList.getEntry(1).getArtist(), "Alice");
        assertEquals(songList.getEntry(2).getArtist(), "Bob");
        assertEquals(songList.getEntry(3).getArtist(), "George");
        assertEquals(songList.getEntry(4).getArtist(), "loius");
        assertEquals(songList.getEntry(5).getArtist(), "Peep");
        assertEquals(songList.getEntry(6).getArtist(), "walt");
    }


    /**
     * This test method tests the sortByGenre() method and asserts the correct
     * genres for the songs in the order they should appear in the list.
     */
    public void testSortGenre() {
        sort.sortByGenre();
        assertEquals(songList.getEntry(1).getGenre(), "R&B");
        assertEquals(songList.getEntry(2).getGenre(), "alternative");
        assertEquals(songList.getEntry(3).getGenre(), "country");
        assertEquals(songList.getEntry(4).getGenre(), "pop");
        assertEquals(songList.getEntry(5).getGenre(), "pop");
        assertEquals(songList.getEntry(6).getGenre(), "rock");
    }

}
