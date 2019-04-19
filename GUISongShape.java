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
 * @version 04.19.2019
 *          This is the GUISongShape class. This class creates glyph shapes
 *          based on the data.
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


    /**
     * This is the GUISongShape constructor.
     * 
     * @param x
     *            this is the x parameter
     * @param y
     *            this is the y parameter
     * @param width
     *            this is the width parameter
     * @param height
     *            this is the height parameter
     * @param win
     *            this is the win parameter
     */
    public GUISongShape(int x, int y, int width, int height, Window win) {
        super(x, y, width, height);
        setBackgroundColor(Color.BLACK);
        setForegroundColor(Color.BLACK);

        songTitle = new TextShape(x - 20, y - 40, "Title");
        songArtist = new TextShape(x - 20, y - 25, "Artist");
        songTitle.setBackgroundColor(Color.white);
        songArtist.setBackgroundColor(Color.white);
        songTitle.setX(x - songTitle.getWidth() / 2);
        songArtist.setX(x - songArtist.getWidth() / 2);

        win.addShape(songArtist);
        win.addShape(songTitle);
        // = new Shape(x+5, <y changes>, numberLiked, 5, color); x4
        // = new Shape(x-numberHeard, <y changes>, numberHeard, 5, color) x4

        pHeard = new Shape(x - 50, y, 50, BAR_WIDTH, Color.PINK);
        bHeard = new Shape(x - 33, y + BAR_WIDTH, 33, BAR_WIDTH, Color.BLUE);
        yHeard = new Shape(x - 45, y + (2 * BAR_WIDTH), 45, BAR_WIDTH,
            Color.YELLOW);
        gHeard = new Shape(x - 61, y + (3 * BAR_WIDTH), 61, BAR_WIDTH,
            Color.GREEN);

        pLiked = new Shape(x + 5, y, 40, BAR_WIDTH, Color.PINK);
        bLiked = new Shape(x + 5, y + BAR_WIDTH, 28, BAR_WIDTH, Color.BLUE);
        yLiked = new Shape(x + 5, y + (2 * BAR_WIDTH), 20, BAR_WIDTH,
            Color.YELLOW);
        gLiked = new Shape(x + 5, y + (3 * BAR_WIDTH), 14, BAR_WIDTH,
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
