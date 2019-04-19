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
    // private Song[] songs;
    private LList<Song> songList;


    public void setUp() {
        // songs = new Song[4];
        /*
         * songs[1] = new Song("titleB", "artistB", 1980, "genreB");
         * songs[2] = new Song("titleC", "artistC", 1990, "genreC");
         * songs[3] = new Song("titleA", "artistA", 2000, "genreA");
         */
        Song song1 = new Song("thanku", "john", 1980, "genreB");
        Song song2 = new Song("next", "ariana", 1990, "genreA");
        Song song3 = new Song("badbb", "bob", 2000, "genreC");
        Song song4 = new Song("pear", "michale", 3020, "rock");
        Song song5 = new Song("water", "natalia", 1020, "pop");
        Song song6 = new Song("cars", "daniel", 2020, "hip");
        
        songList = new LList<Song>();
        songList.add(song1);
        songList.add(song2);
        songList.add(song3);
        songList.add(song4);
        songList.add(song5);
        songList.add(song6);
        sorter = new Sorter(songList);
    }


    /**
     * Tests the sortByArtist method
     */
    public void testSortByArtist() {
        sorter.sortByArtist();
        assertEquals(songList.getEntry(1).getArtist(), "badbb");
        assertEquals(songList.getEntry(2).getArtist(), "cars");
        assertEquals(songList.getEntry(3).getArtist(), "next");
        assertEquals(songList.getEntry(4).getArtist(), "pear");
        assertEquals(songList.getEntry(5).getArtist(), "thanku");
        assertEquals(songList.getEntry(6).getArtist(), "water");
    }  


    /**
     * Tests the sortByTitle method
     */
    public void testSortByTitle() {
        sorter.sortByTitle();
        assertEquals(songList.getEntry(1).getTitle(), "badbb");
        assertEquals(songList.getEntry(2).getTitle(), "cars");
        assertEquals(songList.getEntry(3).getTitle(), "next");
        assertEquals(songList.getEntry(4).getTitle(), "pear");
        assertEquals(songList.getEntry(5).getTitle(), "thanku");
        assertEquals(songList.getEntry(6).getTitle(), "water");
    }  


    /**
     * Tests the sortByYear method
     */
    public void testSortByYear() {
        sorter.sortByArtist();
        for(int x = 1; x <= songList.getLength(); x++)
        {
            System.out.println(songList.getEntry(x).getYear());
        }
        assertEquals(songList.getEntry(1).getYear(), 1020);
        assertEquals(songList.getEntry(2).getYear(), 1980);
        assertEquals(songList.getEntry(3).getYear(), 1990);
        assertEquals(songList.getEntry(4).getYear(), 2000);
        assertEquals(songList.getEntry(5).getYear(), 2020);
        assertEquals(songList.getEntry(6).getYear(), 3020);
    }


    /** 
     * Tests the sortByGenre method
     */
    public void testSortByGenre() {

        sorter.sortByArtist();
        assertEquals(songList.getEntry(1).getGenre(), "genreA");
        assertEquals(songList.getEntry(2).getGenre(), "genreB");
        assertEquals(songList.getEntry(3).getGenre(), "genreC");

    }

}
