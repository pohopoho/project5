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
 * 
 * artist, title, year, and genre.
 *
 * @author Daniel Moreno (danielrm)
 * @version 04/15/2019
 */
public class Sorter {
    private LList<Song> songList;


    /**
     * Constructor
     * 
     * @param songs
     *            the list of songs
     */
    public Sorter(LList<Song> songs) {
        songList = songs;

    }


    /**
     * Sorts the glyphs alphabetically by the names of the artists
     */
    public void sortByArtist() {
        String lowest = new String();
        String comparing = new String();
        for (int i = 1; i <= songList.getLength() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= songList.getLength(); j++) {
                lowest = songList.getEntry(minIndex).getArtist();
                comparing = songList.getEntry(j).getArtist();
                if (comparing.toLowerCase().compareTo(lowest
                    .toLowerCase()) < 0) {
                    minIndex = j;
                }
            }
            Song temp = songList.getEntry(minIndex);
            songList.replace(minIndex, songList.getEntry(i));
            songList.replace(i, temp);
        }
        for (int x = 1; x <= songList.getLength(); x++) {
            System.out.println(songList.getEntry(x).toString());
        }

    }


    /**
     * Sorts the glyphs alphabetically by song title
     */
    public void sortByTitle() {
        String lowest = new String();
        String comparing = new String();
        for (int i = 1; i <= songList.getLength() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j <= songList.getLength(); j++) {
                lowest = songList.getEntry(minIndex).getTitle();
                comparing = songList.getEntry(j).getTitle();
                if (comparing.toLowerCase().compareTo(lowest
                    .toLowerCase()) < 0) {
                    minIndex = j;
                }
            }
            Song temp = songList.getEntry(minIndex);
            songList.replace(minIndex, songList.getEntry(i));
            songList.replace(i, temp);
        }
        for (int x = 1; x <= songList.getLength(); x++) {
            System.out.println(songList.getEntry(x).toString());
        }
    }


    /**
     * Sorts the glyphs by the year the song came out, early songs first
     */
    public void sortByYear() {
        int lowest;
        int comparing;
        for (int i = 1; i <= songList.getLength() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= songList.getLength(); j++) {
                lowest = songList.getEntry(minIndex).getYear();
                comparing = songList.getEntry(j).getYear();
                if (comparing < lowest) {
                    minIndex = j;
                }
            }
            Song temp = songList.getEntry(minIndex);
            songList.replace(minIndex, songList.getEntry(i));
            songList.replace(i, temp);
        }
        for (int x = 1; x <= songList.getLength(); x++) {
            System.out.println(songList.getEntry(x).toString());
        }
    }


    /**
     * Sorts the glyphs by song genre
     */
    public void sortByGenre() {
        String lowest = new String();
        String comparing = new String();
        for (int i = 1; i <= songList.getLength() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= songList.getLength(); j++) {
                lowest = songList.getEntry(minIndex).getGenre();
                comparing = songList.getEntry(j).getGenre();
                if (comparing.compareTo(lowest) < 0) {
                    minIndex = j;
                }
            }
            Song temp = songList.getEntry(minIndex);
            songList.replace(minIndex, songList.getEntry(i));
            songList.replace(i, temp);
        }
        for (int x = 1; x <= songList.getLength(); x++) {
            System.out.println(songList.getEntry(x).toString());
        }
    }


    /**
     * Changes the int[] that contains the size of the bars in the songs in the
     * songList
     * 
     */
    public void repByHobby(Song song) {
        int[] temp = new int[8]; // 0-3 is for heard Bar pecentages, 4-7 is for
                                 // liked
        int[] tempHeardYes, tempHeardNo, tempLikedYes, tempLikedNo;
        int totalAnsweredHeard, totalAnsweredLiked;

        // retrieve arrays from the song parameter and store them in temp
        // variables
        tempHeardYes = song.getHeardYes();
        tempHeardNo = song.getHeardNo();
        tempLikedYes = song.getLikedYes();
        tempLikedNo = song.getLikedNo();

        // since this is repByHobby, index can only be 0, 1, 2, 3
        for (int j = 0; j < 4; j++) {
            // total answered for heard is equal to
            // total # who answered yes + total # who answered no
            totalAnsweredHeard = tempHeardYes[j] + tempHeardNo[j];
            // total answered for liked is equal to
            // total # who answered yes + total # who answered no
            totalAnsweredLiked = tempLikedYes[j] + tempLikedNo[j];
            // this if statement catches divide by zero
            if (totalAnsweredHeard != 0) {
                // System.out.println("Heard");
                // calls a helper method for calculating percentage
                double percentHeard = calc(tempHeardYes[j], totalAnsweredHeard)
                    * 100;
                temp[j] = (int)percentHeard;
            }
            else {
                // System.out.println("Heard");
                // System.out.println("zero");
                temp[j] = 0;
            }
            // this if statement catches divide by zero
            if (totalAnsweredLiked != 0) {
                // System.out.println("Liked");
                // calls a helper method for calculating percentage
                double percentLiked = calc(tempLikedYes[j], totalAnsweredLiked)
                    * 100;
                temp[j + 4] = (int)percentLiked;
            }
            else {
                // System.out.println("Liked");
                // System.out.println("zero");
                temp[j + 4] = 0;
            }
        }
        //assigns the temp arrays 
        song.setBarPercents(temp);
    }


    private double calc(int numerator, int denominator) {
        double num = (double)numerator;
        double den = (double)denominator;
        // System.out.println(num + " h " + den);
        // System.out.println((num/den));
        return num / den;
    }
}
