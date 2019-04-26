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
 * @version
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

    public static final int BAR_WIDTH = 8;


    public GUISongShape(int x, int y, int width, int height, Window win, Song song) {
        super(x, y, width, height);
        setBackgroundColor(Color.BLACK);
        setForegroundColor(Color.BLACK);

        songTitle = new TextShape(x - 20, y - 40, song.getTitle());
        songArtist = new TextShape(x - 20, y - 25, song.getArtist());
        songTitle.setBackgroundColor(Color.white);
        songArtist.setBackgroundColor(Color.white);
        songTitle.setX(x - songTitle.getWidth() / 2);
        songArtist.setX(x - songArtist.getWidth() / 2);

        win.addShape(songArtist);
        win.addShape(songTitle);
        // = new Shape(x+5, <y changes>, numberLiked, 5, color); x4
        // = new Shape(x-numberHeard, <y changes>, numberHeard, 5, color) x4

        pHeard = new Shape(x - song.getBarPercents()[0], y, song.getBarPercents()[0], BAR_WIDTH, Color.PINK);
        bHeard = new Shape(x - song.getBarPercents()[1], y + BAR_WIDTH, song.getBarPercents()[1], BAR_WIDTH, Color.BLUE);
        yHeard = new Shape(x - song.getBarPercents()[2], y + (2 * BAR_WIDTH), song.getBarPercents()[2], BAR_WIDTH,
            Color.YELLOW);
        gHeard = new Shape(x - song.getBarPercents()[3], y + (3 * BAR_WIDTH), song.getBarPercents()[3], BAR_WIDTH,
            Color.GREEN);

        pLiked = new Shape(x + 5, y, song.getBarPercents()[4], BAR_WIDTH, Color.PINK);
        bLiked = new Shape(x + 5, y + BAR_WIDTH, song.getBarPercents()[5], BAR_WIDTH, Color.BLUE);
        yLiked = new Shape(x + 5, y + (2 * BAR_WIDTH), song.getBarPercents()[6], BAR_WIDTH,
            Color.YELLOW);
        gLiked = new Shape(x + 5, y + (3 * BAR_WIDTH), song.getBarPercents()[7], BAR_WIDTH,
            Color.GREEN);

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

}
