import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;



public class Platform extends Object2D {

    private EventHandler<KeyEvent> move = event -> drawHandler(event);

    private int velocity = 0;
    private final double weight = 1.8;
    private final double topSpeed = 15.0;
    private final double friction = 0.4;

    private Rectangle rectangle;

    private Option option = new Option();


    // Konstruktør for platformens dimensioner
    public Platform(int weight, int height, int x, int y, Scene scene) {
        
        super(weight, height, x, y);
        this.rectangle = makeGetRectangle();

        option.getGamScene().addEventFilter(KeyEvent.KEY_PRESSED, move);
    }

    public void moveX (int dx) {
        // Increase the platform velocity by dx.
        if (this.velocity + dx <= this.topSpeed && this.velocity + dx >= -this.topSpeed) {
            this.velocity += dx;
        }
    }

    public void drawHandler(KeyEvent event)
    {
        if(event.getCode() == KeyCode.LEFT)
        {
            System.out.println("hej");
            this.moveX(-2);
            draw();
        }
        if(event.getCode() == KeyCode.RIGHT)
        {
            System.out.println("mm");
            this.moveX(2);
            draw();
        }
    }

    @Override
    public void draw() {
        // Checker om højre og venstre knapperne er trykket, for at få platformen til at flytte sig

        
        // Move the platform by adding the velocity to the x coordinate.
        this.x += this.velocity;
        this.velocity -= this.weight / this.velocity * 0.5;
        if (Math.abs(this.velocity) < this.friction) {
            this.velocity = 0;
        }
        
        /*
        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
            this.moveX(-2);
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
            this.moveX(2);
        }

        

        // Sørger for at platformen ikke går ud af bounds
        if (this.getX() - this.getWidth() / 2 < 0) {
            this.setX(this.getWidth() / 2);
        }
        if (this.getX() + this.getWidth() / 2 > Game.width) {
            this.setX(Game.width - this.getWidth() / 2);
        }
        */

        //StdDraw.filledRectangle(this.getX(), this.getY(), this.getWidth() / 2, this.getHeight() / 2);
        this.rectangle.setLayoutX(this.x);
        this.rectangle.setLayoutY(this.y);
        
        System.out.println(this.rectangle.getLayoutX() + " " + this.rectangle.getLayoutY());
        System.out.println("x:" + this.getX() + " y:" + this.getY());
        System.out.println("width:" + this.getWidth() / 2 + " height:" + this.getHeight() / 2);
    }

    public int getVelocity() {
        return this.velocity;
    }

    public double getWeight() {
        return this.weight;
    }
}
