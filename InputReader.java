/**
 * 
 */
package prj5;

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

    public InputReader(String surveyFile, String songInfoFile) throws FileNotFoundException, ParseException
    {
        songList = readSongInfoFile(songInfoFile);
        readSurveyFile(surveyFile);
    }
    
    private LList<Song> readSongInfoFile(String fileName) throws FileNotFoundException, ParseException
    {
        LList<Song> temp = new LList<Song>();
        File inputFile = new File(fileName);
        Scanner file = new Scanner(inputFile);
        String[] parse = new String[4];
        file.nextLine();
        while(file.hasNextLine())
        {
            parse = file.nextLine().split(", *");
            if(parse.length != 4)
            {
                file.close();
                throw new ParseException("There are not 4 comma separated values", 1);
            }
            temp.add(new Song(parse[0], parse[1], Integer.valueOf(parse[2]), parse[3]));
        }
        
        file.close();
        return temp;
    }
    
    @SuppressWarnings("unused")
    private void readSurveyFile(String fileName) throws FileNotFoundException, ParseException
    {
        File inputFile = new File(fileName);
        Scanner file = new Scanner(inputFile);
        String[] parse = new String[149];
        file.nextLine();
        int totalStudents = 0;
        int[] tempHeardYes;
        int[] tempLikedYes;
        int[] tempHeardNo;
        int[] tempLikedNo;
        int mIndex = 0;
        while(file.hasNextLine())
        {
            parse = file.nextLine().split(", *");

            switch(parse[2])
            {
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
            switch(parse[3])
            {
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
            switch(parse[4])
            {
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
            }
            int songTracker = 0;
            for(int i = 5; i < 149; i += 2)
            {
                tempHeardYes = songList.getEntry(songTracker).getHeardYes();
                tempLikedYes = songList.getEntry(songTracker).getLikedYes();
                tempHeardNo = songList.getEntry(songTracker).getHeardNo();
                tempLikedNo = songList.getEntry(songTracker).getLikedNo();
                
                if(parse[i].equals("Yes"))
                {
                    tempHeardYes[mIndex] += 1;
                    songList.getEntry(songTracker).setHeardYes(tempHeardYes);
                }
                else if(parse[i].equals("No"))
                {
                    tempHeardNo[mIndex] += 1;
                    songList.getEntry(songTracker).setHeardNo(tempHeardNo);
                }
                if(parse[i+1].equals("Yes"))
                {
                    tempLikedYes[mIndex] += 1;
                    songList.getEntry(songTracker).setLikedYes(tempLikedYes);
                }
                else if(parse[i+1].equals("No"))
                {
                    tempLikedNo[mIndex] += 1;
                    songList.getEntry(songTracker).setLikedNo(tempLikedNo);
                }
                songTracker++;
            }
           
           totalStudents++;
        }
        file.close();
    }
}

