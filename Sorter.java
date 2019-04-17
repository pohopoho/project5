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
                if (songList[i].getArtist().compareToIgnoreCase(
                songList[j].getArtist()) < 0)
                {
                    temp = songList[i].getArtist();
                    songList[i].getArtist() = songList[j].getArtist();
                    songList[j].getArtist() = temp;
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
                if (songList[i].getTitle().compareToIgnoreCase(
                songList[j].getTitle()) < 0)
                {
                    temp = songList[i].getTitle();
                    songList[i].getTitle() = songList[j].getTitle();
                    songList[j].getTitle() = temp;
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
                if (songList[i].getYear() <= songList[j].getYear())
                {
                    temp = songList[i].getYear();
                    songList[i].getYear() = songList[j].getYear();
                    songList[j].getYear() = temp;
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
                if (songList[i].getGenre().compareToIgnoreCase(
                    songList[j].getGenre()) == 0)
                {
                    temp = songList[i].getGenre();
                    songList[i].getGenre() = songList[j].getGenre();
                    songList[j].getGenre() = temp;
                }
            }
        }
    }
}
