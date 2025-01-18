package app.model;
import app.controller.Game;
import javafx.scene.shape.Circle;


public class Ball extends Object2D{


    //public boolean changedDirX, changedDirY;

    private Circle circle;

    //speeds and xy speed
    private double speed = 2.5;
    private double nonSpeed = -2.5;
    private double[] speedXY = new double[2];

    //what direction 
    private int angle;
 

    public Ball(int radius, int x, int y, double vx, double vy) {
        // Initialize a ball using the given parameters, inhereting from the Object2D class.
        super(radius, radius, x, y);
        this.vx = vx;
        this.vy = vy;
       

        this.circle = makeGetCircle();
    }

    //moves ball, and update x and y
    public void move()
    {
        this.circle.setCenterX(circle.getCenterX() + speedXY[0]);
        this.circle.setCenterY(circle.getCenterY() +speedXY[1]);

        this.x = this.circle.getCenterX();
        this.y = this.circle.getCenterY();
    }

    //chances direction
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

    //swiches x direction
    public void bounceX() {
        // Bounce the ball in the x direction by reversing the x velocity.
        
        this.speedXY[0] *= -1;
    }
 
    //swiches y directions
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
