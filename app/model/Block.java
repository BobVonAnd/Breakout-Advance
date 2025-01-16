package app.model;
// Purpose: This class is used to create a breakable/killable block in the game.

import javafx.scene.shape.Rectangle;

public class Block extends Object2D {

    private boolean exists;

    private Rectangle rectangle;

    private boolean wall;

    // Whether the block exists or not (true by default).

    public Block (int width, int height, double x, double y, boolean wall) {
        // Initialize a platform using the given parameters, inhereting from the Block class.
        super(width, height, x, y);
        this.wall = wall;
        this.exists = true;
        rectangle = makeGetRectangle();
    }

    public void destroy () {
        // Kill the block by setting exists and visiblity to false, if it's not a wall
        if(!wall)
        {
            this.exists = false;
            rectangle.setVisible(false);
        }
    }

    /* 
    public void revive () {
        // Revive the block by setting exists to true and drawing a colored rectangle over it.
        this.exists = true;
        StdDraw.setPenColor(this.getColor());
        StdDraw.filledRectangle(this.x - 1, this.y - 1, (double) this.getWidth() / 2 - 1, (double) this.getHeight() / 2 - 1);
    }
    */
    

    public boolean exists () {
        // Return whether the block exists or not.
        return this.exists;
    }
}
