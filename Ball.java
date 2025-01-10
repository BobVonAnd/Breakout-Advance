import javafx.scene.shape.Circle;
import javafx.scene.Node;

public class Ball 
{

    private int[] pos;
    private int[] vel;
    private int radius;

    private Circle c;

    public Ball(int x, int y, int vx, int vy, int r) {
        pos = new int[] {x, y};
        vel = new int[] {vx, vy};
        radius = r;
    }

    public void drawBall()
    {
        c = new Circle(pos[0],pos[1],radius);
        //StdDraw.filledCircle(pos[0], pos[1], radius);
    }

    public void move() {
        /* 
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledCircle(pos[0], pos[1], radius+1);

        pos[0] += vel[0];
        pos[1] += vel[1];

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(pos[0], pos[1], radius);
        */

        

        c.setTranslateX(vel[0]);
        c.setTranslateY(vel[1]);

    }

    public boolean outOfBounds() {
        return pos[1] < 0;
    }

    public void setPos(int x, int y) {
        pos[0] = x;
        pos[1] = y;
    }

    public void setVel(int vx, int vy) {
        vel[0] = vx;
        vel[1] = vy;
    }

    public int[] getPos() {
        return pos;
    }

    public int[] getVel() {
        return vel;
    }

    public int getRadius() {
        return radius;
    }

    public Circle getCircle()
    {
        return c;
    }
}
