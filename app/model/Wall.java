package app.model;
import org.w3c.dom.css.Rect;

import javafx.scene.shape.Rectangle;
//__________!!!!!!!!!!!!!Scriptet brues ikke!!!!!!!!!!!__________________________
public class Wall {

    private int hight;
    private int width;

    private int[] pos;

    private Rectangle r;


    public Wall(int x, int y, int width, int hight)
    {
        pos = new int[] {x, y};
        this.width = width;
        this.hight = hight;
        drawWall();
    }

    /*
    public void collider()
    {

    }
    */

    public void drawWall()
    {
        r = new Rectangle();
        r.setX(pos[0]);
        r.setY(pos[1]);
        r.setHeight(hight);
        r.setWidth(width);
    }

    public Rectangle getWall()
    {
        return r;
    }
    
    
}
