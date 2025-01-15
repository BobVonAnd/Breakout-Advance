import java.awt.Color;
import java.awt.event.KeyEvent;

public class Platform extends Object2D {
    private int velocity = 0;
    private final double weight = 1.8;
    private final double topSpeed = 15.0;
    private final double friction = 0.4;

    // Konstruktør for platformens dimensioner
    public Platform(int weight, int height, int x, int y, Color color) {
        super(weight, height, x, y, color);
    }

    public void moveX (int dx) {
        // Increase the platform velocity by dx.
        if (this.velocity + dx <= this.topSpeed && this.velocity + dx >= -this.topSpeed) {
            this.velocity += dx;
        }
    }

    @Override
    public void draw() {
        // Checker om højre og venstre knapperne er trykket, for at få platformen til at flytte sig
        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
            this.moveX(-2);
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
            this.moveX(2);
        }

        // Move the platform by adding the velocity to the x coordinate.
        this.x += this.velocity;
        this.velocity -= this.weight / this.velocity * 0.5;
        if (Math.abs(this.velocity) < this.friction) {
            this.velocity = 0;
        }

        // Sørger for at platformen ikke går ud af bounds
        if (this.getX() - this.getWidth() / 2 < 0) {
            this.setX(this.getWidth() / 2);
        }
        if (this.getX() + this.getWidth() / 2 > Game.width) {
            this.setX(Game.width - this.getWidth() / 2);
        }

        StdDraw.setPenColor(this.getColor());
        StdDraw.filledRectangle(this.getX(), this.getY(), this.getWidth() / 2, this.getHeight() / 2);
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
