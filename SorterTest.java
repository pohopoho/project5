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
public class SorterTest extends TestCase {
    private Sorter sorter;
    private LList<Song> songs;

    /**
     * Setup for the test methods
     */
    public void setUp() {
        Song songs1 = new Song("titleB", "artistB", 1990, "genreB");
        Song songs2 = new Song("titleC", "artistC", 2000, "genreC");
        Song songs3 = new Song("titleD", "artistD", 2010, "genreD");
        Song songs4 = new Song("titleA", "artistA", 1980, "genreA");
        songs = new LList<Song>();
        songs.add(songs1);
        songs.add(songs2);
        songs.add(songs3);
        songs.add(songs4);
        
        sorter = new Sorter(songs);
    }


    /**
     * Tests the sortByArtist method
     */
    public void testSortByArtist() {
        sorter.sortByArtist();
        assertEquals(songs.getEntry(1).getArtist(), "artistA");
        assertEquals(songs.getEntry(2).getArtist(), "artistB");
        assertEquals(songs.getEntry(3).getArtist(), "artistC");
        assertEquals(songs.getEntry(4).getArtist(), "artistD");
    }


    /**
     * Tests the sortByTitle method
     */
    public void testSortByTitle() {
        sorter.sortByTitle();
        assertEquals(songs.getEntry(1).getTitle(), "titleA");
        assertEquals(songs.getEntry(2).getTitle(), "titleB");
        assertEquals(songs.getEntry(3).getTitle(), "titleC");
        assertEquals(songs.getEntry(4).getTitle(), "titleD");
    }


    /**
     * Tests the sortByYear method
     */
    public void testSortByYear() {
        sorter.sortByYear();
        assertEquals(songs.getEntry(1).getYear(), 1980);
        assertEquals(songs.getEntry(2).getYear(), 1990);
        assertEquals(songs.getEntry(3).getYear(), 2000);
        assertEquals(songs.getEntry(4).getYear(), 2010);
    }


    /**
     * Tests the sortByGenre method
     */
    public void testSortByGenre() {
        sorter.sortByGenre();
        assertEquals(songs.getEntry(1).getGenre(), "genreA");
        assertEquals(songs.getEntry(2).getGenre(), "genreB");
        assertEquals(songs.getEntry(3).getGenre(), "genreC");
        assertEquals(songs.getEntry(4).getGenre(), "genreD");
    }
}

/*public class SorterTest extends TestCase{
    
    private LList<Song> songList;
    private Sorter sort;
    
    public void setUp()
    {
        songList = new LList<Song>();
        songList.add(new Song("Dogs", "Peep", 2000, "R&B"));
        songList.add(new Song("Cars", "Alice", 1999, "pop"));
        songList.add(new Song("Apples", "Bob", 1900, "rock"));
        songList.add(new Song("Zap", "George", 2045, "pop"));
        songList.add(new Song("Lightbulb", "Light", 1616, "country"));
        songList.add(new Song("IwearCrocs", "Croc", 1989, "pop"));
        songList.add(new Song("Boats", "Frog", 2020, "country"));

        sort = new Sorter(songList);
    }
    
    public void testSortYear()
    {
        sort.sortByYear();
    }
    
    public void testSortTitle()
    {
        sort.sortByTitle();
    }
    
    public void testSortArtist()
    {
        sort.sortByArtist();
    }
    
    public void testSortPop()
    {
        sort.sortByGenre();
    }

}*/
