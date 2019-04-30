/**
 * 
 */
package prj5;

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

/**
 * @author Michael Cheung
 * @version 4/26/2019
 *
 */
public class GUISongShape extends Shape {

    private TextShape songTitle;
    private TextShape songArtist;

    private Shape pHeard;
    private Shape pLiked;
    private Shape bHeard;
    private Shape bLiked;
    private Shape yHeard;
    private Shape yLiked;
    private Shape gHeard;
    private Shape gLiked;
    
    private Song song;

    public static final int BAR_WIDTH = 8;


    public GUISongShape(int x, int y, int width, int height, Song song) {
        super(x, y, width, height);
        setBackgroundColor(Color.BLACK);
        setForegroundColor(Color.BLACK);
        this.song = song;
        songTitle = new TextShape(x - 20, y - 40, this.song.getTitle());
        songArtist = new TextShape(x - 20, y - 25, this.song.getArtist());
        songTitle.setBackgroundColor(Color.white);
        songArtist.setBackgroundColor(Color.white);
        songTitle.setX(x - songTitle.getWidth() / 2);
        songArtist.setX(x - songArtist.getWidth() / 2);


        // = new Shape(x+5, <y changes>, numberLiked, 5, color); x4
        // = new Shape(x-numberHeard, <y changes>, numberHeard, 5, color) x4

        pHeard = new Shape(x - this.song.getBarPercents()[0], y, this.song.getBarPercents()[0], BAR_WIDTH, Color.PINK);
        bHeard = new Shape(x - this.song.getBarPercents()[1], y + BAR_WIDTH, this.song.getBarPercents()[1], BAR_WIDTH, Color.BLUE);
        yHeard = new Shape(x - this.song.getBarPercents()[2], y + (2 * BAR_WIDTH), this.song.getBarPercents()[2], BAR_WIDTH,
            Color.YELLOW);
        gHeard = new Shape(x - this.song.getBarPercents()[3], y + (3 * BAR_WIDTH), this.song.getBarPercents()[3], BAR_WIDTH,
            Color.GREEN);

        pLiked = new Shape(x + 5, y, this.song.getBarPercents()[4], BAR_WIDTH, Color.PINK);
        bLiked = new Shape(x + 5, y + BAR_WIDTH, this.song.getBarPercents()[5], BAR_WIDTH, Color.BLUE);
        yLiked = new Shape(x + 5, y + (2 * BAR_WIDTH), this.song.getBarPercents()[6], BAR_WIDTH,
            Color.YELLOW);
        gLiked = new Shape(x + 5, y + (3 * BAR_WIDTH), this.song.getBarPercents()[7], BAR_WIDTH,
            Color.GREEN);


    }
    
    public void addToWin(Window win)
    {
        
        win.addShape(songArtist);
        win.addShape(songTitle);
        win.addShape(pHeard);
        win.addShape(bHeard);
        win.addShape(yHeard);
        win.addShape(gHeard);
        win.addShape(pLiked);
        win.addShape(bLiked);
        win.addShape(yLiked);
        win.addShape(gLiked);
        win.addShape(this);
    }
    
    public void removeFromWin(Window win)
    {
        win.removeShape(songArtist);
        win.removeShape(songTitle);
        win.removeShape(pHeard);
        win.removeShape(bHeard);
        win.removeShape(yHeard);
        win.removeShape(gHeard);
        win.removeShape(pLiked);
        win.removeShape(bLiked);
        win.removeShape(yLiked);
        win.removeShape(gLiked);
        win.removeShape(this);
    }

}
