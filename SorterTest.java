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

}
