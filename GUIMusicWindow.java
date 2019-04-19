/**
 * 
 */
package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * @author Michael Cheung
 * @version 4.16.2019
 *          This is the GUIMusicWindow class. This class is used to create the
 *          visual
 *          representation of the data.
 */
public class GUIMusicWindow {

    // Windows
    private Window window;

    // Top Buttons
    private Button prev;
    private Button next;
    private Button sArtist;
    private Button sTitle;
    private Button sYear;
    private Button sGenre;

    // Bottom Buttons
    private Button rHobby;
    private Button rMajor;
    private Button rRegion;
    private Button quit;

    // Legend
    private Shape legendBox;
    private TextShape legendTitle;
    private TextShape legendBottom1;
    private TextShape legendBottom2;
    private TextShape pinkText;
    private TextShape blueText;
    private TextShape yellowText;
    private TextShape greenText;
    private Shape divider;

    // Glyph Shape
    // private GUISongShape glyph;

    // Public constants


    /**
     * This is the constructor of GUIMusicWindow.
     */
    public GUIMusicWindow() {
        window = new Window("Project 5");

        // Initialize top buttons
        prev = new Button("<-- Prev");
        next = new Button("Next -->");
        sArtist = new Button("Sort by Artist Name");
        sTitle = new Button("Sort by Song Title");
        sYear = new Button("Sort by Release Year");
        sGenre = new Button("Sort by Genre");

        // Initialize bottom buttons
        rHobby = new Button("Represent by Hobby");
        rMajor = new Button("Represent by Major");
        rRegion = new Button("Represent by Region");
        quit = new Button("Quit");

        // Link buttons
        linkButtons();

        // Build legend
        buildLegend();

        for (int i = 1; i < 4; i++) {
            window.addShape(new GUISongShape(i * 150, 50, 5, 32, window));
        }
        // glyph = new SongShape(200, 200, 5, 32, window);
        // window.addShape(glyph);
        // window.moveToFront(glyph);

    }


    /**
     * This is the linkButtons() method.
     */
    private void linkButtons() {
        prev.onClick(this, "clickedPrev");
        next.onClick(this, "clickedNext");
        sArtist.onClick(this, "clickedSortByArtist");
        sTitle.onClick(this, "clickedSortByTitle");
        sYear.onClick(this, "clickedSortByYear");
        sGenre.onClick(this, "clickedSortByGenre");

        window.addButton(prev, WindowSide.NORTH);
        window.addButton(sArtist, WindowSide.NORTH);
        window.addButton(sTitle, WindowSide.NORTH);
        window.addButton(sYear, WindowSide.NORTH);
        window.addButton(sGenre, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);

        rHobby.onClick(this, "clickedRepByHobby");
        rMajor.onClick(this, "clickedRepByMajor");
        rRegion.onClick(this, "clickedRepByRegion");
        quit.onClick(this, "clickedQuit");

        window.addButton(rHobby, WindowSide.SOUTH);
        window.addButton(rMajor, WindowSide.SOUTH);
        window.addButton(rRegion, WindowSide.SOUTH);
        window.addButton(quit, WindowSide.SOUTH);
    }


    /**
     * This is the buildLegend() method.
     */
    private void buildLegend() {
        // Legend
        legendBox = new Shape(570, 120, 150);
        legendBox.setForegroundColor(Color.BLACK);
        legendBox.setBackgroundColor(Color.white);

        window.addShape(legendBox);
        window.moveToFront(legendBox);

        legendTitle = new TextShape(620, 125, "Legend");
        legendTitle.setBackgroundColor(Color.white);
        window.addShape(legendTitle);
        window.moveToFront(legendTitle);

        legendBottom1 = new TextShape(600, 210, "   Song Title");
        legendBottom1.setBackgroundColor(Color.white);
        window.addShape(legendBottom1);
        window.moveToFront(legendBottom1);

        legendBottom2 = new TextShape(600, 240, "Heard   Liked");
        legendBottom2.setBackgroundColor(Color.white);
        window.addShape(legendBottom2);
        window.moveToFront(legendBottom2);

        pinkText = new TextShape(585, 140, "Pink");
        pinkText.setForegroundColor(Color.pink);
        pinkText.setBackgroundColor(Color.WHITE);
        window.addShape(pinkText);
        window.moveToFront(pinkText);
        blueText = new TextShape(585, 155, "Blue");
        blueText.setForegroundColor(Color.blue);
        blueText.setBackgroundColor(Color.WHITE);
        window.addShape(blueText);
        window.moveToFront(blueText);
        yellowText = new TextShape(585, 170, "Yellow");
        yellowText.setForegroundColor(Color.YELLOW);
        yellowText.setBackgroundColor(Color.WHITE);
        window.addShape(yellowText);
        window.moveToFront(yellowText);
        greenText = new TextShape(585, 185, "Green");
        greenText.setForegroundColor(Color.green);
        greenText.setBackgroundColor(Color.white);
        window.addShape(greenText);
        window.moveToFront(greenText);

        divider = new Shape(645, 235, 5, 25, Color.BLACK);
        window.addShape(divider);
        window.moveToFront(divider);
    }


    /**
     * This clickedPrev() method provides functionality for the previous button.
     * 
     * @param button
     *            this is the button parameter
     */
    public void clickedPrev(Button button) {

    }


    /**
     * This clickedNext() method provides functionality for the next button.
     * 
     * @param button
     *            this is the button parameter
     */
    public void clickedNext(Button button) {

    }


    /**
     * This method clickedSortByArtist() provides functionality for the
     * sortByArtist button.
     * 
     * @param button
     *            this is the button parameter
     */
    public void clickedSortByArtist(Button button) {
        // This is supposed to be empty
    }


    /**
     * This clickedSortByTitle() method provides functionality for the
     * sortByTitle button.
     * 
     * @param button
     *            this is the button parameter
     */
    public void clickedSortByTitle(Button button) {
        // This is supposed to be empty
    }


    /**
     * This clickedSortByYear() method provides functionality for the sortByYear
     * button.
     * 
     * @param button
     *            the parameter for button
     */
    public void clickedSortByYear(Button button) {
        // This is supposed to be empty
    }


    /**
     * This clickedSortByGenre() method provides functionality for the
     * sortByGenre button.
     * 
     * @param button
     *            this is the parameter for button
     */
    public void clickedSortByGenre(Button button) {
        // This is supposed to be empty
    }


    /**
     * This clickedRepByHobby() method provides functionality for the repByHobby
     * button.
     * 
     * @param button
     *            this is the parameter for button
     */
    public void clickedRepByHobby(Button button) {
        // This is supposed to be empty
    }


    /**
     * This clickedRepByMajor() method provides functionality for the repByMajor
     * button.
     * 
     * @param button
     *            this is the parameter for button.
     */
    public void clickedRepByMajor(Button button) {
        // This is supposed to be empty
    }


    /**
     * This clickedRepByRegion() method provides functionality for the
     * repByRegion button.
     * 
     * @param button
     *            this is the parameter for button.
     */
    public void clickedRepByRegion(Button button) {
        // This is supposed to be empty
    }


    /**
     * This clickedQuit() method provides functionality for the quit button.
     * 
     * @param button
     *            this is the parameter for button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }

}
