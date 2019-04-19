/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author Michael Cheung
 *
 */

public class SorterTest extends TestCase{
    
    private LList<Song> songList;
    private Sorter sort;
    
    public void setUp()
    {
        songList = new LList<Song>();
        songList.add(new Song("Dogs", "Peep", 2000, "R&B"));
        songList.add(new Song("Cars", "Alice", 1999, "pop"));
        songList.add(new Song("Apples", "Bob", 1900, "rock"));
        songList.add(new Song("Zap", "George", 2045, "pop"));


        sort = new Sorter(songList);
    }
    
    public void testSortYear()
    {
        sort.sortByYear();
    }

}
