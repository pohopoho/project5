// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- punitav9
/**
 * 
 */
package prj5;

/**
 * This is the class for a song object. It initializes the song fields using the
 * parameters passed into the constructor and allows access to these fields with
 * getter methods.
 * 
 * @author Punita Verma (punitav9)
 * @version 04.14.2019
 *
 */
public class Song {
    private String title;
    private String artist;
    private int year;
    private String genre;
    private int[] heard;
    private int[] liked;


    /**
     * This is the parameterized constructor for the class. It initializes the
     * song fields with the parameters passed and intializes the heard and liked
     * arrays to new array of size 12.
     * 
     * @param songTitle
     *            The title of the song
     * @param songArtist
     *            The artist of the song
     * @param songYear
     *            The year the song was released
     * @param songGenre
     *            The genre of the song
     */
    public Song(
        String songTitle,
        String songArtist,
        int songYear,
        String songGenre) {
        title = songTitle;
        artist = songArtist;
        year = songYear;
        genre = songGenre;
        heard = new int[12];
        liked = new int[12];
    }


    /**
     * This getter method returns the string value for the title of the song.
     * 
     * @return the title field
     */
    public String getTitle() {
        return title;
    }


    /**
     * This getter method returns the string value for the artist of the song.
     * 
     * @return the artist field
     */
    public String getArtist() {
        return artist;
    }


    /**
     * This getter method returns the int value for the year of the song.
     * 
     * @return the year field
     */
    public int getYear() {
        return year;
    }


    /**
     * This getter method returns the string value for the genre of the song.
     * 
     * @return the genre field
     */
    public String getGenre() {
        return genre;
    }
}