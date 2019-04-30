// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Michael Cheung (michaelc97)
/**
 * 
 * 
 */
package prj5;

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

/**
 * This class is the GUISongShape class. It contains the methods for the
 * implementation of a glyph. It sets the correct titles and bar lengths for a
 * song.
 * 
 * @author Michael Cheung
 * @version 4/26/2019
 *
 */
public class GUISongShape extends Shape {
    /**
     * These are the private fields for the song shape. They hold all the
     * attributes for a glyph: its title, the appropriate text (genre, year, or
     * artist), and the percentages of heard and liked responses
     */
    private TextShape songTitle;
    private TextShape songText;

    private Shape pHeard;
    private Shape pLiked;
    private Shape bHeard;
    private Shape bLiked;
    private Shape yHeard;
    private Shape yLiked;
    private Shape gHeard;
    private Shape gLiked;

    private int x;
    private Song song;

    public static final int BAR_WIDTH = 8;


    /**
     * This is the parameterized constructor for the class. It initializes the
     * private fields.
     * 
     * @param x
     *            the x coordinate the shape starts at
     * @param y
     *            the y coordinate the shape starts at
     * @param width
     *            the width of the shape
     * @param height
     *            the height of the shape
     * @param song
     *            the song
     */
    public GUISongShape(int x, int y, int width, int height, Song song) {
        super(x, y, width, height);
        setBackgroundColor(Color.BLACK);
        setForegroundColor(Color.BLACK);
        this.song = song;
        this.x = x;
        songTitle = new TextShape(x - 20, y - 40, this.song.getTitle());
        songText = new TextShape(x - 20, y - 25, "by " + this.song.getArtist());
        songTitle.setBackgroundColor(Color.white);
        songText.setBackgroundColor(Color.white);
        songTitle.setX(x - songTitle.getWidth() / 2);
        songText.setX(x - songText.getWidth() / 2);

        // = new Shape(x+5, <y changes>, numberLiked, 5, color); x4
        // = new Shape(x-numberHeard, <y changes>, numberHeard, 5, color) x4

        pHeard = new Shape(x - this.song.getBarPercents()[0], y, this.song
            .getBarPercents()[0], BAR_WIDTH, Color.PINK);
        bHeard = new Shape(x - this.song.getBarPercents()[1], y + BAR_WIDTH,
            this.song.getBarPercents()[1], BAR_WIDTH, Color.BLUE);
        yHeard = new Shape(x - this.song.getBarPercents()[2], y + (2
            * BAR_WIDTH), this.song.getBarPercents()[2], BAR_WIDTH,
            Color.YELLOW);
        gHeard = new Shape(x - this.song.getBarPercents()[3], y + (3
            * BAR_WIDTH), this.song.getBarPercents()[3], BAR_WIDTH,
            Color.GREEN);

        pLiked = new Shape(x + 5, y, this.song.getBarPercents()[4], BAR_WIDTH,
            Color.PINK);
        bLiked = new Shape(x + 5, y + BAR_WIDTH, this.song.getBarPercents()[5],
            BAR_WIDTH, Color.BLUE);
        yLiked = new Shape(x + 5, y + (2 * BAR_WIDTH), this.song
            .getBarPercents()[6], BAR_WIDTH, Color.YELLOW);
        gLiked = new Shape(x + 5, y + (3 * BAR_WIDTH), this.song
            .getBarPercents()[7], BAR_WIDTH, Color.GREEN);

    }


    /**
     * This method adds the parts of the glyph to the window.
     * 
     * @param win
     *            the window the shapes need to be added to
     */
    public void addToWin(Window win) {

        win.addShape(songText);
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


    /**
     * This method removes all the shapes from the window
     * 
     * @param win
     *            the window the shapes to be removed from
     */
    public void removeFromWin(Window win) {
        win.removeShape(songText);
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


    /**
     * This method updates the text if the sort by artist button gets clicked
     */
    public void setTextArtist() {
        songText.setText("by " + song.getArtist());
        songText.setX(x - songText.getWidth() / 2);
    }


    /**
     * This method updates the text of the glyph to display the year if the
     * sort by year button is clicked
     */
    public void setTextYear() {
        songText.setText("year: " + Integer.toString(song.getYear()));
        songText.setX(x - songText.getWidth() / 2);
    }


    /**
     * This method updates the text of the glyph to display the genre if the
     * sort by genre button is clicked
     */
    public void setTextGenre() {
        songText.setText("genre: " + song.getGenre());
        songText.setX(x - songText.getWidth() / 2);
    }

}
