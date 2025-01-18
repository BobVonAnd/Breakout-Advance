package app.model;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;

public class Platform extends Object2D {

    private EventHandler<KeyEvent> move = event -> drawHandler(event);

    //has the first arrow key press been made
    private boolean firstMoveMade = false;

    private int velocity = 0;

    private int angle;

    private final double weight = 1.8;
    private final double topSpeed = 15.0;

    private Rectangle rectangle;

    //private Option option = new Option();


    // Konstruktør for platformens dimensioner
    public Platform(int weight, int height, int x, int y, Scene scene) {
        
        super(weight, height, x, y);
        this.rectangle = makeGetRectangle();

        scene.addEventFilter(KeyEvent.KEY_PRESSED, move);
    }

    public void moveX (int dx) {
        // Increase the platform velocity by dx.
        if (this.velocity + dx <= this.topSpeed && this.velocity + dx >= -this.topSpeed) {
            this.velocity += dx;
        }
    }
    public void move(int speed)
    {
        this.rectangle.setX(this.x + speed);
        this.x = this.rectangle.getX();
    }

    //detect arrowkey presses
    public void drawHandler(KeyEvent event)
    {
        if(event.getCode() == KeyCode.LEFT)
        {
            if(!firstMoveMade)
            {
                firstMoveMade = true;
                angle = 4;
            }
            
            move(-40);
        }
        if(event.getCode() == KeyCode.RIGHT)
        {
            if(!firstMoveMade)
            {
                firstMoveMade = true;
                angle = 1;
            }
            move(40);
        }
    }

   

    public int getVelocity() {
        return this.velocity;
    }

    public double getWeight() {
        return this.weight;
    }

    public boolean firstMove()
    {
        return firstMoveMade;
    }
    public int rightLeft()
    {
        return angle;
    }

    public Bounds getPlatformBounds()
    {
        return rectangle.getBoundsInParent();
    }
}
