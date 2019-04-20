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
     * Selection Sorts the songs alphabetically by the names of the artists
     */
    public void sortByArtist() {
        String lowest;
        String comparing;
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
     * Selection Sorts the songs alphabetically by song title
     */
    public void sortByTitle() {
        String lowest;
        String comparing;
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
     * Selection Sorts the songs by the year the song came out, early songs
     * first
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
     * Selection Sorts the songs by song genre
     */
    public void sortByGenre() {
        String lowest;
        String comparing;
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
     */
    public void repByHobby() {
        int totalAnsweredHeard;
        int totalAnsweredLiked;
        Song tempSong;
        for (int i = 1; i <= songList.getLength(); i++) {
            tempSong = songList.getEntry(i);
            // since this is repByHobby, index can only be 0, 1, 2, 3
            for (int j = 0; j < 4; j++) {
                // total answered for heard is equal to
                // total # who answered yes + total # who answered no
                totalAnsweredHeard = tempSong.getHeardYes()[j] + tempSong
                    .getHeardNo()[j];
                // total answered for liked is equal to
                // total # who answered yes + total # who answered no
                totalAnsweredLiked = tempSong.getLikedYes()[j] + tempSong
                    .getLikedNo()[j];
                // this if statement catches divide by zero
                if (totalAnsweredHeard != 0) {
                    // calls a helper method for calculating percentage
                    double percentHeard = calc(tempSong.getHeardYes()[j],
                        totalAnsweredHeard);
                    tempSong.getBarPercents()[j] = (int)percentHeard;
                }
                else {
                    tempSong.getBarPercents()[j] = 0;
                }
                // this if statement catches divide by zero
                if (totalAnsweredLiked != 0) {
                    // calls a helper method for calculating percentage
                    double percentLiked = calc(tempSong.getLikedYes()[j],
                        totalAnsweredLiked);
                    tempSong.getBarPercents()[j + 4] = (int)percentLiked;
                }
                else {
                    tempSong.getBarPercents()[j + 4] = 0;
                }
            }
            songList.replace(i, tempSong);
        }

    }


    /**
     * helper method for calculating percentage
     * 
     * @param numerator
     *            numerator for division
     * @param denominator
     *            denominator for division
     * 
     * @return a percentage
     */
    private double calc(int numerator, int denominator) {
        double num = (double)numerator;
        double den = (double)denominator;
        return (num / den) * 100;
    }
}
