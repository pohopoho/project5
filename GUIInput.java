/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * @author Michael Cheung
 * @version 4.19.2019
 *This is the GUIInput class. This class contains the main method for the project.
 */
public class GUIInput {
    /**
     * This is the GUIInput() constructor.
     */
    public GUIInput()
    {
        //This is supposed to be empty
    }
    
    /**
     * This is the main method for GUIInput class.
     * @param args this is the parameter args
     * @throws FileNotFoundException this exception is thrown when file is not found
     * @throws ParseException this is a parse exception
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException
    {
        InputReader reader = new InputReader("MusicSurveyData2018.csv", "SongList2018.csv");
        GUIMusicWindow window = new GUIMusicWindow();
    }

}
