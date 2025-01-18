package app.model;
// Purpose: Define the Object2D class, which represents any object within the game.
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;


public class Object2D {

    //nodes
    private Rectangle r;
    private Circle c;

    private int width, height;
    // Width and height of the object within the game space.

    public double x, y;
    // Position of the center point of the object.
    
    public double vx, vy;
    // Velocity of the object in the x and y directions.

    public Object2D(int width, int height, double x, double y){
        // Initialize a block using the given parameters.
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
       
    }
    public Rectangle makeGetRectangle()
    {
        return this.r = new Rectangle(this.x, this.y, this.width, this.height);  
    }

    public Circle makeGetCircle()
    {
        return this.c = new Circle(this.x, this.y, this.width);
    }

    public double getY() {
        // Return the y coordinate of the object.
        return this.y;
    }

    public double getX() {
        // Return the x coordinate of the object.
        return this.x;
    }

    public Rectangle getRectangle()
    {
        return this.r;
    }

    public Circle getCircle()
    {
        return this.c;
    }

    public void setX(int x) {
        // Set the x coordinate of the object.
        this.x = x;
    }

    public void setY(int y) {
        // Set the y coordinate of the object.
        this.y = y;
    }

    public int getWidth() {
        // Return the width of the block.
        return width;
    }

    public int getHeight() {
        // Return the height of the block.
        return height;
    }
    
}
