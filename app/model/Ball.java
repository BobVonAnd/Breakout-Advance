package app.model;
// Purpose: This class is used to define the ball moving around the game colliding with other objects.

import app.controller.Game;
import javafx.scene.shape.Circle;


public class Ball extends Object2D{
    //private double minSpeed = 0.2;
    public boolean changedDirX, changedDirY;

    private Circle circle;

    private double speed = 2.5;
    private double nonSpeed = -2.5;
    private double[] speedXY = new double[2];

    private int angle;
 

    public Ball(int radius, int x, int y, double vx, double vy) {
        // Initialize a ball using the given parameters, inhereting from the Object2D class.
        super(radius, radius, x, y);
        this.vx = vx;
        this.vy = vy;
        this.setMass(1.3);
        this.circle = makeGetCircle();

    
    }

    public void move()
    {
        this.circle.setCenterX(circle.getCenterX() + speedXY[0]);
        this.circle.setCenterY(circle.getCenterY() +speedXY[1]);

        this.x = this.circle.getCenterX();
        this.y = this.circle.getCenterY();
    }

    public void setAngle(int angle)
    {
        this.angle = angle;
        switch (angle) {
            case 1:
                speedXY[0] = speed;
                speedXY[1] = nonSpeed;
                break;
            case 2:
                speedXY[0] = speed;
                speedXY[1] = speed;
                break;
            case 3:
                speedXY[0] = nonSpeed;
                speedXY[1] = speed;
                break;
            case 4:
                speedXY[0] = nonSpeed;
                speedXY[1] = nonSpeed;
    
            default:
                break;
        }
    }

   
 

    public boolean outOfBounds() {
        // Check if the ball is out of bounds.
        return this.y < 0;
    }

    public void bounceOffWalls() {
        // Bounce the ball off the walls by reversing the x or y velocity.
        if (this.x <= 0 && this.vx <= 0) {
            this.x = 1 + this.getWidth();
            this.bounceX();
        }
        if (this.x >= Game.width) {
            this.bounceX();
            this.x = Game.width - 1 - this.getWidth();
        }
        if (this.y >= Game.height) {
            this.bounceY();
            this.y = Game.height - 1 - this.getHeight();
        }
    }

    

    public void bounceX() {
        // Bounce the ball in the x direction by reversing the x velocity.
        
        this.speedXY[0] *= -1;
        
        
        
    }

    public void bounceY() {
        // Bounce the ball in the y direction by reversing the y velocity.
        this.speedXY[1] *= -1;
    }

    public double getVx() {
        // Return the x velocity of the ball.
        return this.vx;
    }

    public double getVy() {
        // Return the y velocity of the ball.
        return this.vy;
    }

    public void setVx(double vx) {
        // Set the x velocity of the ball.
        this.vx = vx;
    }

    public void setVy(double vy) {
        // Set the y velocity of the ball.
        this.vy = vy;
    }

    public void setX(int x) {
        // Set the x coordinate of the ball.
        this.x = x;
    }

    public void setY(int y) {
        // Set the y coordinate of the ball.
        this.y = y;
    }

    
}
