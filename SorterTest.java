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

        int[] tempHeardYes = new int[12];
        tempHeardYes[0] = 5;
        tempHeardYes[1] = 0;
        tempHeardYes[2] = 2;
        tempHeardYes[3] = 2;
        tempHeardYes[4] = 5;
        tempHeardYes[5] = 0;
        tempHeardYes[6] = 2;
        tempHeardYes[7] = 2;
        tempHeardYes[8] = 5;
        tempHeardYes[9] = 0;
        tempHeardYes[10] = 2;
        tempHeardYes[11] = 2;

        int[] tempHeardNo = new int[12];
        tempHeardNo[0] = 5;
        tempHeardNo[1] = 2;
        tempHeardNo[2] = 0;
        tempHeardNo[3] = 6;
        tempHeardNo[4] = 5;
        tempHeardNo[5] = 2;
        tempHeardNo[6] = 0;
        tempHeardNo[7] = 6;
        tempHeardNo[8] = 5;
        tempHeardNo[9] = 2;
        tempHeardNo[10] = 0;
        tempHeardNo[11] = 6;

        int[] tempLikedYes = new int[12];
        tempLikedYes[0] = 5;
        tempLikedYes[1] = 0;
        tempLikedYes[2] = 1;
        tempLikedYes[3] = 1;
        tempLikedYes[4] = 5;
        tempLikedYes[5] = 0;
        tempLikedYes[6] = 1;
        tempLikedYes[7] = 1;
        tempLikedYes[8] = 5;
        tempLikedYes[9] = 0;
        tempLikedYes[10] = 1;
        tempLikedYes[11] = 1;

        int[] tempLikedNo = new int[12];
        tempLikedNo[0] = 0;
        tempLikedNo[1] = 0;
        tempLikedNo[2] = 1;
        tempLikedNo[3] = 1;
        tempLikedNo[4] = 0;
        tempLikedNo[5] = 0;
        tempLikedNo[6] = 1;
        tempLikedNo[7] = 1;
        tempLikedNo[8] = 0;
        tempLikedNo[9] = 0;
        tempLikedNo[10] = 1;
        tempLikedNo[11] = 1;

        songList.getEntry(3).setHeardYes(tempHeardYes);
        songList.getEntry(3).setHeardNo(tempHeardNo);
        songList.getEntry(3).setLikedYes(tempLikedYes);
        songList.getEntry(3).setLikedNo(tempLikedNo);

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


    /**
     * tests repByHobby
     */
    public void testRepByHobby() {

        int[] temp = new int[8];
        temp[0] = 50;
        temp[1] = 0;
        temp[2] = 100;
        temp[3] = 25;

        temp[4] = 100;
        temp[5] = 0;
        temp[6] = 50;
        temp[7] = 50;
        sort.sortByTitle();

        sort.repByHobby();
        for (int i = 0; i < 8; i++) {
            assertEquals(temp[i], songList.getEntry(1).getBarPercents()[i]);
        }

    }


    /**
     * tests repByMajor method
     */
    public void testRepByMajor() {
        int[] temp = new int[8];
        temp[0] = 50;
        temp[1] = 0;
        temp[2] = 100;
        temp[3] = 25;

        temp[4] = 100;
        temp[5] = 0;
        temp[6] = 50;
        temp[7] = 50;
        sort.sortByTitle();

        sort.repByMajor();
        for (int i = 0; i < 8; i++) {
            assertEquals(temp[i], songList.getEntry(1).getBarPercents()[i]);
        }
    }


    /**
     * tests repByRegion method
     */
    public void testRepByRegion() {
        int[] temp = new int[8];
        temp[0] = 50;
        temp[1] = 0;
        temp[2] = 100;
        temp[3] = 25;

        temp[4] = 100;
        temp[5] = 0;
        temp[6] = 50;
        temp[7] = 50;
        sort.sortByTitle();

        sort.repByRegion();
        for (int i = 0; i < 8; i++) {
            assertEquals(temp[i], songList.getEntry(1).getBarPercents()[i]);
        }
    }

}
