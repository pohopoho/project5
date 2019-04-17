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

/**
 * This class sorts the glyphs based on 
 * artist, title, year, and genre.
 *
 * @author Daniel Moreno (danielrm)
 * @version 04/15/2019
 */
public class Sorter {
    private LList<Song> songList;
    
    public Sorter(LList<Song> songs)
    {
        songList = songs;
    }
    
    /**
     * Sorts the glyphs alphabetically by the names of the artists
     */
    public void sortByArtist()
    {
        String temp = new String();
        for (int i = 0; i < songList.getLength(); i++)
        {
            for (int j = i + 1; j < songList.getLength(); j++)
            {
                if (songList.getEntry(i).getArtist().compareToIgnoreCase(
                songList.getEntry(i).getArtist()) < 0)
                {
                    
                    songList.replace(i, songList.getEntry(j));
                    
                    temp = songList.getEntry(i).getArtist();
                    String strI = songList.getEntry(i).getArtist();
                    strI = songList.getEntry(j).getArtist();
                    String strJ = songList.getEntry(j).getArtist();
                    strJ = temp;
                }
            }
        }
    }
    
    /**
     * Sorts the glyphs alphabetically by song title
     */
    public void sortByTitle()
    {
        String temp = new String();
        for (int i = 0; i < songList.getLength(); i++)
        {
            for (int j = i + 1; j < songList.getLength(); j++)
            {
                if (songList.getEntry(i).getTitle().compareToIgnoreCase(
                songList.getEntry(j).getTitle()) < 0)
                {
                    temp = songList.getEntry(i).getTitle();
                    songList.getEntry(i).getTitle() = songList[j].getTitle();
                    songList.getEntry(j).getTitle() = temp;
                }
            }
        }
    }
    
    /**
     * Sorts the glyphs by the year the song came out, early songs first
     */
    public void sortByYear()
    {
        int temp = 0;
        for (int i = 0; i < songList.getLength(); i++)
        {
            for (int j = i + 1; j < songList.getLength(); j++)
            {
                if (songList.getEntry(i).getYear() <= songList.getEntry(j).getYear())
                {
                    temp = songList.getEntry(i).getYear();
                    songList.getEntry(i).getYear() = songList[j].getYear();
                    songList.getEntry(j).getYear() = temp;
                }
            }
        }
    }
    
    /**
     * Sorts the glyphs by song genre
     */
    public void sortByGenre()
    {
        String temp = new String();
        for (int i = 0; i < songList.getLength(); i++)
        {
            for (int j = i + 1; j < songList.getLength(); j++)
            {
                if (songList.getEntry(i).getGenre().compareToIgnoreCase(
                    songList.getEntry(j).getGenre()) == 0)
                {
                    temp = songList.getEntry(i).getGenre();
                    songList.getEntry(i).getGenre() = songList[j].getGenre();
                    songList.getEntry(j).getGenre() = temp;
                }
            }
        }
    }
}
