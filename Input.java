/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * @author Michael Cheung
 * @version
 *
 */
public class Input {
    
    public Input()
    {
        
    }
    
    public static void main(String[] args) throws FileNotFoundException, ParseException
    {
        InputReader reader = new InputReader("MusicSurveyData2018.csv", "SongList2018.csv");
        MusicWindow window = new MusicWindow();
    }

}
