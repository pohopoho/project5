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
    private int[] heardYes; // 0-3 Hobbies, 4-7 majors, 8-11 Regions
    private int[] likedYes; // 0-3 Hobbies, 4-7 majors, 8-11 Regions
    private int[] heardNo; // 0-3 Hobbies, 4-7 majors, 8-11 Regions
    private int[] likedNo; // 0-3 Hobbies, 4-7 majors, 8-11 Regions
    private int[] barPercents; // 0-3 all heard percent (purple, blue, yellow,
                               // green) 4-7 all like percent (p, b, y, g)


    /**
     * This is the parameterized constructor for the class. It initializes the
     * song fields with the parameters passed and initializes the heard and liked
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
        barPercents = new int[8];
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


    /**
     * This getHeardYes() method returns value of people who heard song.
     * 
     * @return the array holding the amount of people who answered Yes to
     *         hearing this song
     */
    public int[] getHeardYes() {
        return heardYes;
    }


    /**
     * This getLikedYes() method returns value of people who like song.
     * @return the array holding the amount of people who answered Yes to liking
     *         this song
     */
    public int[] getLikedYes() {
        return likedYes;
    }


    /**
     * This getLikedYes() method returns value of people who never heard the song.
     * @return the array holding the amount of people who answered No to hearing
     *         this song
     */
    public int[] getHeardNo() {
        return heardNo;
    }


    /**
     * This is the newHeardYes() method. It is a mutator for heardYes.
     * 
     * @param newHeardYes
     *            an int[] containing updated values
     */
    public void setHeardYes(int[] newHeardYes) {
        heardYes = newHeardYes;
    }


    /**
     * This is the setLikedYes() method. It is a mutator for the likedYes.
     * 
     * @param newLikedYes
     *            an int[] containing updated values
     */
    public void setLikedYes(int[] newLikedYes) {
        likedYes = newLikedYes;
    }


    /**
     * This is the setHeardNo() method. This is a mutator for heardNo.
     * 
     * @param newHeardNo
     *            an int[] containing updated values
     */
    public void setHeardNo(int[] newHeardNo) {
        heardNo = newHeardNo;
    }
    
    /**
     * This is the getLikedNo() method.
     * @return likedNo contains people who do not like song
     */
    public int[] getLikedNo()
    {
        return likedNo;
    }

    /**
     * This is the setLikedNo() method. This is a mutator for likedNo.
     * @param newLikedNo contains people who do not like song
     */
    public void setLikedNo(int [] newLikedNo)
    {
        likedNo = newLikedNo;
    }

    /**
     * This is the getBarPercents(). This is an accessor for the 
     * int[] containing the percentage values(glyph bar sizes) of 
     * heard/liked.
     * 
     * @return the barPercents[] returns the bar percents
     */
    public int[] getBarPercents() {
        return barPercents;
    }


    /**
     * This is the setBarPercents methods. This is a mutator for the int[] 
     * containing the percentage values(glyph bar sizes) of heard/liked.
     * 
     * @param newBarPercents
     *            an int[] containing updated values
     */
    public void setBarPercents(int[] newBarPercents) {
        barPercents = newBarPercents;
    }


    /**
     * This is the equals method.
     * 
     * @param obj
     *            the object to be compared to
     * @return true if equal, false if not equal    
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
            return s1.getTitle().equals(this.getTitle()) && s1.getArtist()
                .equals(this.getArtist()) && s1.getYear() == (this.getYear())
                && s1.getGenre().equals(this.getGenre());
        }
        return false;
    }


    /**
     * This toString() method converts song to string
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("song title " + title.toLowerCase() + "\n");
        result.append("song artist " + artist.toLowerCase() + "\n");
        result.append("song genre " + genre.toLowerCase() + "\n");
        result.append("song year " + year + "\n");
        result.append("heard\n");
        result.append("reading" + barPercents[0] + " art" + barPercents[1]
            + " sports" + barPercents[2] + " music" + barPercents[3] + "\n");
        result.append("likes\n");
        result.append("reading" + barPercents[4] + " art" + barPercents[5]
            + " sports" + barPercents[6] + " music" + barPercents[7] + "\n");
        return result.toString();
    }
}
