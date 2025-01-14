import javafx.scene.paint.Color;
import javafx.scene.shape.*;
public class Block 
{
    private int[] pos;
    private int width, height;
    private Rectangle r;
    private Color color;

    
    public Block(int x, int y, int w, int h) 
    {
        pos = new int[] {x, y};
        width = w;
        height = h;
        this.color = Color.BLACK;
        drawBlock();
    }

    public Block(int x, int y, int w, int h, Color color) 
    {
        pos = new int[] {x, y};
        width = w;
        height = h;
        this.color = color;
        drawBlock();
    }

    public int[] getPos() 
    {
        return pos;
    }

    public int getWidth() 
    {
        return width;
    }

    public int getHeight() 
    {
        return height;
    }

    public void drawBlock() 
    {
        r = new Rectangle();  
        r.setX(pos[0]);
        r.setY(pos[1]);
        r.setHeight(height);
        r.setWidth(width);
    }

    public Rectangle getR()
    {
        return r;
    }
}
