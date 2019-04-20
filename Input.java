/**
 * 
 */
package prj5;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Michael Cheung (michaelc97)

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * @author Michael Cheung
 * @version
 *
 */
public class Input {
    
    /**
     * constructor
     */
    public Input()
    {
        
    }
    
    
    /**
     * main method
     * @param args command line arguments
     * @throws FileNotFoundException thrown when file name is invalid
     * @throws ParseException thrown when there are not the correct number of csv
     */
    public static void main(String[] args)
    {
        if(args.length == 2)
        {
            try {
                InputReader reader = new InputReader(args[0], args[1]);
            }
            catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else
        {
            try {
                InputReader reader = new InputReader("MusicSurveyData2018.csv", "SongList2018.csv");
            }
            catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }

}
