import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class GameSetup 
{
   
    private int width = 30;
    private int height = 7;
    private int[] pos = new int[] {152, 500};

    private int xSize = 9;
    private int ySize = 4; 

    //objects
    private Block[][] nrOfTargets = new Block[xSize][ySize];
    //private Platform platform;
    private Ball ball;
    private Wall[] wall = new Wall[3];

    private Pane easyPane = new Pane();
    private Pane mediumPane = new Pane();
    private Pane hardPane = new Pane();

    public Pane makeEasyPane()
    {
        for(int i = 0; i < ySize; i++)
        {
            for(int j = 0; j < xSize; j++)
            {
                nrOfTargets[j][i] = new Block(pos[0] + j * 62 , pos[1] - i * 35 , width , height);
                easyPane.getChildren().addAll(nrOfTargets[j][i].getR());
            }
        }

        return easyPane;
    }

    public Pane makeMediumPane()
    {
        Label k = new Label("jj");
        mediumPane.getChildren().addAll(k);

        return mediumPane;
    }
    
    public Pane makeHardPane()
    {
        Label k = new Label("jj");
        
        hardPane.getChildren().addAll(k);

        return hardPane;
    }

    public void drawStartGame()
    {
        drawBlocks();
        drawWalls();
        drawBall();
    }

    private void drawBlocks()
    {
        
        for(int i = 0; i < ySize; i++)
        {
            for(int j = 0; j < xSize; j++)
            {
                nrOfTargets[j][i] = new Block(pos[0] + j * 62 , pos[1] - i * 35 , width , height);
                nrOfTargets[j][i].drawBlock();
            }
        }
    }

    private void drawWalls()
    {  
        wall[0] = new Wall(100, 60, 5, 540);
        wall[1] = new Wall(700, 60, 5, 540);
        wall[2] = new Wall(100, 60, 600, 5);

        for(int i = 0; i < wall.length; i++)
        {
            wall[i].drawWall();
        }

        //StdDraw.filledRectangle(90, 350, 5, 200);
        //StdDraw.filledRectangle(740, 350, 5, 200);
        //StdDraw.filledRectangle(410, 545, 325, 5);
    }
    /* 
    private void drawPlatform()
    {
        StdDraw.setPenColor(StdDraw.CYAN);
        //x, y, w, h, speed
        platform = new Platform(400, 150, 50, 5, 5);
    }
    */

    private void drawBall()
    {
        ball = new Ball(400, 400, 5, 5, 4);
        ball.drawBall();
    }

    public Block[][] getBlocks()
    {
        return nrOfTargets;
    }

    public Wall[] getWalls()
    {
        return wall;
    }

    /* 
    public Platform getPlatform()
    {
        return platform;
    }
    */

    public Ball getBall()
    {
        return ball;
    }

    
    


    
}
