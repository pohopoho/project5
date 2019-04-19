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
    private int[] heardYes;
    private int[] likedYes;
    private int[] heardNo;
    private int[] likedNo;


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
        heardYes = new int[12];
        likedYes = new int[12];
        heardNo = new int[12];
        likedNo = new int[12];
        for (int i = 0; i < 12; i++) {
            heardYes[i] = 0;
            likedYes[i] = 0;
            heardNo[i] = 0;
            likedNo[i] = 0;
        }
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


    public int[] getHeardYes() {
        return heardYes;
    }


    public int[] getLikedYes() {
        return likedYes;
    }


    public int[] getHeardNo() {
        return heardNo;
    }


    public int[] getLikedNo() {
        return likedNo;
    }


    public void setHeardYes(int[] newHeardYes) {
        heardYes = newHeardYes;
    }


    public void setLikedYes(int[] newLikedYes) {
        likedYes = newLikedYes;
    }


    public void setHeardNo(int[] newHeardNo) {
        heardNo = newHeardNo;
    }


    public void setLikedNo(int[] newLikedNo) {
        likedNo = newLikedNo;
    }
    
    /**
     * This is the equals method.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (this.getClass() == obj.getClass()) {
            Song s1 = (Song)obj;
            return s1.getTitle().equals(this.getTitle())
                && s1.getArtist().equals(this.getArtist())
                && s1.getYear()==(this.getYear())
                && s1.getGenre().equals(this.getGenre());
        }
        return false;
   }
}
