/**
 * 
 */
package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Michael Cheung (michaelc97)

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * @author Michael Cheung
 * @version 4/16/2019
 *
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

    // Glyph Shapes
    private LList<GUISongShape> glyphs;
    // private LListIterator iterator;

    // Public constants

    // Sorter
    private Sorter collection;

    // Page variable
    private int page;
    
    //FirstClick variable


    /**
     * Constructor
     */
    public GUIMusicWindow(Sorter sorter) {
        collection = sorter;
        window = new Window("Project 5");
        glyphs = new LList<GUISongShape>();
        buildGlyphs();

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

        prev.disable();
        page = 0;
    }


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


    private void buildLegend() {
        // Legend
        legendBox = new Shape(570, 120, 150);
        legendBox.setForegroundColor(Color.BLACK);
        legendBox.setBackgroundColor(Color.white);

        window.addShape(legendBox);
        window.moveToFront(legendBox);

        legendTitle = new TextShape(580, 125, "");
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

        pinkText = new TextShape(585, 140, "");
        pinkText.setForegroundColor(Color.pink);
        pinkText.setBackgroundColor(Color.WHITE);
        window.addShape(pinkText);
        window.moveToFront(pinkText);
        blueText = new TextShape(585, 155, "");
        blueText.setForegroundColor(Color.blue);
        blueText.setBackgroundColor(Color.WHITE);
        window.addShape(blueText);
        window.moveToFront(blueText);
        yellowText = new TextShape(585, 170, "");
        yellowText.setForegroundColor(Color.YELLOW);
        yellowText.setBackgroundColor(Color.WHITE);
        window.addShape(yellowText);
        window.moveToFront(yellowText);
        greenText = new TextShape(585, 185, "");
        greenText.setForegroundColor(Color.green);
        greenText.setBackgroundColor(Color.white);
        window.addShape(greenText);
        window.moveToFront(greenText);

        divider = new Shape(645, 235, 5, 25, Color.BLACK);
        window.addShape(divider);
        window.moveToFront(divider);
    }


    /**
     * provides functionality for the previous button
     * 
     * @param button
     */
    public void clickedPrev(Button button) {
        next.enable();
        // remove the current shapes
        for (int i = (page * 9) + 1; i <= (page * 9) + 9; i++) {
            glyphs.getEntry(i).removeFromWin(window);
        }
        page--;
        // add the shapes after decrementing page
        for (int j = (page * 9) + 1; j <= (page * 9) + 9; j++) {
            glyphs.getEntry(j).addToWin(window);
        }
        if (page == 0) {
            button.disable();
        }

    }


    /**
     * provides functionality for the next button
     * 
     * @param button
     */
    public void clickedNext(Button button) {
        prev.enable();
        // remove the current shapes
        for (int i = (page * 9) + 1; i <= (page * 9) + 9; i++) {
            glyphs.getEntry(i).removeFromWin(window);
        }
        page++;
        // add the shapes after incrementing page
        for (int j = (page * 9)+ 1; j <= (page * 9) + 9; j++) {
            if (j <= glyphs.getLength()) {
                glyphs.getEntry(j).addToWin(window);
            }
        }
        if ((page + 1) * 9 >= glyphs.getLength()) {
            button.disable();
        }

    }


    /**
     * provides functionality for the sortByArtist button
     * 
     * @param button
     */
    public void clickedSortByArtist(Button button) {
        collection.sortByArtist();
        buildGlyphs();
        updatePage();
    }


    /**
     * provides functionality for the sortByTitle button
     * 
     * @param button
     */
    public void clickedSortByTitle(Button button) {
        collection.sortByTitle();
        buildGlyphs();
        updatePage();
    }


    /**
     * provides functionality for the sortByYear button
     * 
     * @param button
     */
    public void clickedSortByYear(Button button) {
        collection.sortByYear();
        buildGlyphs();
        updatePage();
    }


    /**
     * provides functionality for the sortByGenre button
     * 
     * @param button
     */
    public void clickedSortByGenre(Button button) {
        collection.sortByGenre();
        buildGlyphs();
        updatePage();
    }


    /**
     * provides functionality for the repByHobby button
     * 
     * @param button
     */
    public void clickedRepByHobby(Button button) {
        legendTitle.setText("Hobby Legend");
        pinkText.setText("Read");
        blueText.setText("Art");
        yellowText.setText("Sports");
        greenText.setText("Music");
        collection.repByHobby();
        buildGlyphs();
        updatePage();
    }


    /**
     * provides functionality for the repByMajor button
     * 
     * @param button
     */
    public void clickedRepByMajor(Button button) {
        legendTitle.setText("Major Legend");
        pinkText.setText("Comp Sci");
        blueText.setText("Other Eng");
        yellowText.setText("Math/CMDA");
        greenText.setText("Other");
        collection.repByMajor();
        buildGlyphs();
        updatePage();
    }


    /**
     * provides functionality for the repByRegion button
     * 
     * @param button
     */
    public void clickedRepByRegion(Button button) {
        legendTitle.setText("Region Legend");
        pinkText.setText("Northeast US");
        blueText.setText("Southeast US");
        yellowText.setText("Rest of US");
        greenText.setText("Outside of US");
        collection.repByRegion();
        buildGlyphs();
        updatePage();
    }


    /**
     * provides functionality for the quit button
     * 
     * @param button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * builds glyphs
     */
    private void buildGlyphs() {
        int xPosition = 1;
        int yPosition = 1;
        int yTracker = 1;
        glyphs.clear();
        for (int i = 1; i <= collection.getSongList().getLength(); i++) {
            glyphs.add(new GUISongShape((xPosition * 100) + (xPosition - 1)
                * 90, yPosition * 45, 5, 32, collection.getSongList().getEntry(
                    i)));
            if (xPosition % 3 == 0) {
                xPosition = 1;
            }
            else {
                xPosition++;
            }
            if (yTracker == 3) {
                yTracker = 1;
                if (yPosition == 1) {
                    yPosition = 3;
                }
                else if (yPosition == 3) {
                    yPosition = 5;
                }
                else {
                    yPosition = 1;
                }
            }
            else {
                yTracker++;
            }
            //glyphs.getEntry(i).addToWin(window);
        }
    }


    private void updatePage() {
        for(int i = (page * 9) + 1; i <= (page * 9) + 9; i++)
        {
            glyphs.getEntry(i).removeFromWin(window);
        }
        for(int j = (page * 9) + 1; j <= (page * 9) + 9; j++)
        {
            if(j <= glyphs.getLength())
            {
                glyphs.getEntry(j).addToWin(window);
            }
        }
    }

}
