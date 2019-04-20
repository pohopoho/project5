/**
 * 
 */
package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Michael Cheung (michaelc97)

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * @author Michael Cheung
 * @version 4/16/2019
 *
 */
public class InputReader {

    private LList<Song> songList;


    /**
     * constructor
     * 
     * @param surveyFile
     *            the survey file name
     * @param songInfoFile
     *            the song info file name
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public InputReader(String surveyFile, String songInfoFile)
        throws FileNotFoundException,
        ParseException {
        songList = readSongInfoFile(songInfoFile);
        readSurveyFile(surveyFile);
        Sorter sorter = new Sorter(songList);
        sorter.repByHobby();
        sorter.sortByGenre();
        sorter.sortByTitle();
        GUIMusicWindow mWin = new GUIMusicWindow();
    }


    /**
     * helper method for reading song info file
     * 
     * @param fileName
     *            the name of the song info file
     * @return a LList of songs
     * @throws FileNotFoundException
     * @throws ParseException
     */
    private LList<Song> readSongInfoFile(String fileName)
        throws FileNotFoundException,
        ParseException {
        LList<Song> temp = new LList<Song>();
        File inputFile = new File(fileName);
        Scanner file = new Scanner(inputFile);
        String[] parse = new String[4];
        file.nextLine();
        while (file.hasNextLine()) {
            parse = file.nextLine().split(", *");
            if (parse.length != 4) {
                file.close();
                throw new ParseException(
                    "There are not 4 comma separated values", 1);
            }
            temp.add(new Song(parse[0], parse[1], Integer.valueOf(parse[2]),
                parse[3]));
        }

        file.close();
        return temp;
    }


    /**
     * helper method for reading survey file and filling the heard and liked
     * arrays for songs in the songList
     * 
     * @param fileName
     *            the name of the survey file
     * @throws FileNotFoundException
     * @throws ParseException
     */
    private void readSurveyFile(String fileName)
        throws FileNotFoundException,
        ParseException {
        File inputFile = new File(fileName);
        Scanner file = new Scanner(inputFile);
        String[] parse;
        file.nextLine();
        // temp arrays created in order to edit values
        int[] tempHeardYes, tempLikedYes, tempHeardNo, tempLikedNo;
        int mIndex = 0; // major index
        int rIndex = 0; // region index
        int hIndex = 0; // hobby index
        while (file.hasNextLine()) {
            parse = file.nextLine().split(", *", -1);
            if (parse[2].length() > 0 && parse[3].length() > 0 && parse[4]
                .length() > 0) {
                // look at index 2 of the line (major)
                switch (parse[2]) {
                    case "Computer Science":
                        // index for the appropriate index for accessing heard
                        // and like arrays
                        mIndex = 4;
                        break;
                    case "Other Engineering":
                        mIndex = 5;
                        break;
                    case "Math or CMDA":
                        mIndex = 6;
                        break;
                    case "Other":
                        mIndex = 7;
                        break;
                }
                switch (parse[3]) {
                    case "Northeast":
                        rIndex = 8;
                        break;
                    case "Southeast":
                        rIndex = 9;
                        break;
                    case "United States (other than Southeast or Northwest)":
                        rIndex = 10;
                        break;
                    case "Outside of United States":
                        rIndex = 11;
                        break;
                }
                switch (parse[4]) {
                    case "reading":
                        hIndex = 0;
                        break;
                    case "art":
                        hIndex = 1;
                        break;
                    case "sports":
                        hIndex = 2;
                        break;
                    case "music":
                        hIndex = 3;
                        break;
                }
                // songTracker is the list index
                int songTracker = 1;
                // increments by 2 because each iteration handles one pair of
                // responses
                for (int i = 5; i < parse.length; i += 2) {

                    // retrieve the arrays for the appropriate songs
                    tempHeardYes = songList.getEntry(songTracker).getHeardYes();
                    tempLikedYes = songList.getEntry(songTracker).getLikedYes();
                    tempHeardNo = songList.getEntry(songTracker).getHeardNo();
                    tempLikedNo = songList.getEntry(songTracker).getLikedNo();

                    // if they answered YES in the HEARD column, increment
                    // arrays, index are based
                    // on their major, region, hobby
                    if (parse[i].equals("Yes")) {
                        tempHeardYes[mIndex] += 1;
                        tempHeardYes[rIndex] += 1;
                        tempHeardYes[hIndex] += 1;
                        songList.getEntry(songTracker).setHeardYes(
                            tempHeardYes);
                    }
                    // if they answered NO in the HEARD column, increment
                    // arrays, index are based
                    // on their major, region, hobby
                    else if (parse[i].equals("No")) {
                        tempHeardNo[mIndex] += 1;
                        tempHeardNo[rIndex] += 1;
                        tempHeardNo[hIndex] += 1;
                        songList.getEntry(songTracker).setHeardNo(tempHeardNo);
                    }

                    // if they answered YES in the LIKED column, increment
                    // arrays, index are based
                    // on their major, region, hobby
                    if (parse[i + 1].equals("Yes")) {
                        tempLikedYes[mIndex] += 1;
                        tempLikedYes[rIndex] += 1;
                        tempLikedYes[hIndex] += 1;
                        songList.getEntry(songTracker).setLikedYes(
                            tempLikedYes);
                    }
                    // if they answered NO in the LIKED column, increment
                    // arrays, index are based
                    // on their major, region, hobby
                    else if (parse[i + 1].equals("No")) {
                        tempLikedNo[mIndex] += 1;
                        tempLikedNo[rIndex] += 1;
                        tempLikedNo[hIndex] += 1;
                        songList.getEntry(songTracker).setLikedNo(tempLikedNo);
                    }
                    // increment the song number in the list
                    songTracker++;
                }

            }

        }
        file.close();
    }
}
