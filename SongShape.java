/**
 * 
 */
package prj5;

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;

/**
 * @author Michael Cheung
 * @version
 *
 */
public class SongShape extends Shape{
    
    private TextShape songTitle;
    private TextShape songArtist;
    
    public SongShape(int x, int y)
    {
        
        songArtist = new TextShape(x, y - 15, "Artist");
        songTitle = new TextShape(x, y - 30, "Title");
        
    }

}
