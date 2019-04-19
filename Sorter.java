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

import java.util.Iterator;

//import java.util.Iterator;

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
        String lowest = new String();
        String comparing = new String();
        for(int i = 1; i <= songList.getLength() - 1; i++)
        {
            int minIndex = i;
            lowest = songList.getEntry(minIndex).getArtist();
            for(int j = i + 1; j <= songList.getLength(); j++)
            {
                comparing = songList.getEntry(j).getArtist();
                if(comparing.toLowerCase().compareTo(lowest.toLowerCase()) < 0)
                {
                    minIndex = j;
                }
            }
            Song temp = songList.getEntry(minIndex);
            songList.replace(minIndex, songList.getEntry(i));
            songList.replace(i, temp);
        }
        for(int x = 1; x <= songList.getLength(); x++)
        {
            System.out.println(songList.getEntry(x).getArtist());
        }
        
    }
    
    /**
     * Sorts the glyphs alphabetically by song title
     */
    public void sortByTitle()
    {
        String lowest = new String();
        String comparing = new String();
        for(int i = 1; i <= songList.getLength() - 1; i++)
        {
            int minIndex = i;
            lowest = songList.getEntry(minIndex).getTitle();
            for(int j = i + 1; j <= songList.getLength(); j++)
            {
                comparing = songList.getEntry(j).getTitle();
                if(comparing.toLowerCase().compareTo(lowest.toLowerCase()) < 0)
                {
                    minIndex = j;
                }
            }
            Song temp = songList.getEntry(minIndex);
            songList.replace(minIndex, songList.getEntry(i));
            songList.replace(i, temp);
        }
        for(int x = 1; x <= songList.getLength(); x++)
        {
            System.out.println(songList.getEntry(x).getTitle());
        }
    }
    
    /**
     * Sorts the glyphs by the year the song came out, early songs first
     */
    public void sortByYear()
    {
        int lowest;
        int comparing;
        for(int i = 1; i <= songList.getLength() - 1; i++)
        {
            int minIndex = i;
            lowest = songList.getEntry(minIndex).getYear();
            for(int j = i + 1; j <= songList.getLength(); j++)
            {
                comparing = songList.getEntry(j).getYear();
                if(comparing < lowest)
                {
                    minIndex = j;
                }
            }
            Song temp = songList.getEntry(minIndex);
            songList.replace(minIndex, songList.getEntry(i));
            songList.replace(i, temp);
        }
        for(int x = 1; x <= songList.getLength(); x++)
        {
            System.out.println(songList.getEntry(x).getYear());
        }
    }
    
    /**
     * Sorts the glyphs by song genre
     */
    public void sortByGenre()
    {
        String lowest = new String();
        String comparing = new String();
        for(int i = 1; i <= songList.getLength() - 1; i++)
        {
            int minIndex = i;
            lowest = songList.getEntry(minIndex).getGenre();
            for(int j = i + 1; j <= songList.getLength(); j++)
            {
                comparing = songList.getEntry(j).getGenre();
                if(comparing.compareTo(lowest) < 0)
                {
                    minIndex = j;
                }
            }
            Song temp = songList.getEntry(minIndex);
            songList.replace(minIndex, songList.getEntry(i));
            songList.replace(i, temp);
        }
        for(int x = 1; x <= songList.getLength(); x++)
        {
            System.out.println(songList.getEntry(x).getGenre());
        }
    }
    
    /**
     * 
     */
    public void repByHobby()
    {
        
    }
}