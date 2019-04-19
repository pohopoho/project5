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
     * @param songInfoFile
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
    }


    /**
     * helper method fro reading song info file
     * 
     * @param fileName
     * @return
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
     * helper method for reading survey file
     * 
     * @param fileName
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @SuppressWarnings("unused")
    private void readSurveyFile(String fileName)
        throws FileNotFoundException,
        ParseException {
        File inputFile = new File(fileName);
        Scanner file = new Scanner(inputFile);
        String[] parse = new String[149];
        file.nextLine();
        int totalStudents = 0;
        int[] tempHeardYes;
        int[] tempLikedYes;
        int[] tempHeardNo;
        int mIndex = 0;
        while (file.hasNextLine()) {
            parse = file.nextLine().split(", *", -1);
            // if (parse.length != 149) {
            // file.close();
            // throw new ParseException(
            // "There are not 149 comma separated values", 1);
            // }
            if (parse[2].length() > 0 && parse[3].length() > 0 && parse[4]
                .length() > 0) {
                switch (parse[2]) {
                    case "Computer Science":
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
                int songTracker = 1;
                for (int i = 5; i < parse.length; i += 2) {
                    tempHeardYes = songList.getEntry(songTracker).getHeardYes();
                    tempLikedYes = songList.getEntry(songTracker).getLikedYes();
                    tempHeardNo = songList.getEntry(songTracker).getHeardNo();

                    if (parse[i].equals("Yes")) {
                        tempHeardYes[mIndex] += 1;
                        songList.getEntry(songTracker).setHeardYes(
                            tempHeardYes);
                    }
                    else if (parse[i].equals("No")) {
                        tempHeardNo[mIndex] += 1;
                        songList.getEntry(songTracker).setHeardNo(tempHeardNo);
                    }
                    if (parse[i + 1].equals("Yes")) {
                        tempLikedYes[mIndex] += 1;
                        songList.getEntry(songTracker).setLikedYes(
                            tempLikedYes);
                    }
                    songTracker++;
                }
                switch (parse[3]) {
                    case "Northeast":
                        mIndex = 8;
                        break;
                    case "Southeast":
                        mIndex = 9;
                        break;
                    case "United States (other than Southeast or Northwest)":
                        mIndex = 10;
                        break;
                    case "Outside of United States":
                        mIndex = 11;
                        break;
                }
                songTracker = 1;
                for (int i = 5; i < parse.length; i += 2) {
                    tempHeardYes = songList.getEntry(songTracker).getHeardYes();
                    tempLikedYes = songList.getEntry(songTracker).getLikedYes();
                    tempHeardNo = songList.getEntry(songTracker).getHeardNo();

                    if (parse[i].equals("Yes")) {
                        tempHeardYes[mIndex] += 1;
                        songList.getEntry(songTracker).setHeardYes(
                            tempHeardYes);
                    }
                    else if (parse[i].equals("No")) {
                        tempHeardNo[mIndex] += 1;
                        songList.getEntry(songTracker).setHeardNo(tempHeardNo);
                    }
                    if (parse[i + 1].equals("Yes")) {
                        tempLikedYes[mIndex] += 1;
                        songList.getEntry(songTracker).setLikedYes(
                            tempLikedYes);
                    }

                    songTracker++;
                }
                switch (parse[4]) {
                    case "reading":
                        mIndex = 0;
                        break;
                    case "art":
                        mIndex = 1;
                        break;
                    case "sports":
                        mIndex = 2;
                        break;
                    case "music":
                        mIndex = 3;
                        break;
                }

                songTracker = 1;
                for (int i = 5; i < parse.length; i += 2) {
                    tempHeardYes = songList.getEntry(songTracker).getHeardYes();
                    tempLikedYes = songList.getEntry(songTracker).getLikedYes();
                    tempHeardNo = songList.getEntry(songTracker).getHeardNo();

                    if (parse[i].equals("Yes")) {
                        tempHeardYes[mIndex] += 1;
                        songList.getEntry(songTracker).setHeardYes(
                            tempHeardYes);
                    }
                    else if (parse[i].equals("No")) {
                        tempHeardNo[mIndex] += 1;
                        songList.getEntry(songTracker).setHeardNo(tempHeardNo);
                    }
                    if (parse[i + 1].equals("Yes")) {
                        tempLikedYes[mIndex] += 1;
                        songList.getEntry(songTracker).setLikedYes(
                            tempLikedYes);
                    }

                    songTracker++;

                }
            }

            totalStudents++;
        }
        file.close();
    }
}
