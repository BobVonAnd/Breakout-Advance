import javafx.scene.shape.*;
public class Block 
{
    private int[] pos;
    private int width, height;
    private Rectangle r;

    
    public Block(int x, int y, int w, int h) 
    {
        pos = new int[] {x, y};
        width = w;
        height = h;
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
