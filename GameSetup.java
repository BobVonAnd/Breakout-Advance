import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class GameSetup 
{

   

    private int width = 59;
    private int height = 25;
    private int[] pos = new int[] {0, 150};

    private int xSize = 10;
    private int ySize = 3; 

    //objects
    private Block[][] nrOfTargets = new Block[xSize][ySize];

    //private Platform platform;
    private Ball ball;
    private Wall[] wall = new Wall[3];

    private Pane easyPane = new Pane();
    private Pane mediumPane = new Pane();
    private Pane hardPane = new Pane();

    private int multiplayerX = 605;
    private int notSelected = 0;


    //Easy gamemode_______________________________________________________________________________
    
    public Pane makeEasyPane(boolean multiplayerSelected)
    {
        drawEasy(notSelected);

        if(multiplayerSelected)
        {
            drawEasy(multiplayerX);
        }

        return easyPane;
    }

    private void drawEasy(int x)
    {
        for(int i = 0; i < ySize; i++)
        {
            for(int j = 0; j < xSize; j++)
            {
                nrOfTargets[j][i] = new Block(pos[0] + j * 60 + x, pos[1] - i * 35 , width , height);
                easyPane.getChildren().add(nrOfTargets[j][i].getR());
            }
        }
        //Platform____________________________________________
        Block platform = new Block(250 + x, 450, 100, 10);

        //Ball________________________________________________
        Ball ball = new Ball(297 + x, 445, 2, 2, 6);
        easyPane.getChildren().addAll(platform.getR(), ball.getCircle());
    }


    //Medium gamemode_______________________________________________________________________
    

    public Pane makeMediumPane(boolean multiplayerSelected)
    {
        drawMedium(notSelected);

       if(multiplayerSelected)
       {
            drawMedium(multiplayerX);
       }

        return mediumPane;
    }

    private void drawMedium(int x)
    {
        Label k = new Label("jj");
        mediumPane.getChildren().addAll(k);
    }
    

    //Hard gamemode__________________________________________________________________________
    public Pane makeHardPane(boolean multiplayerSelected)
    {
        drawHard(notSelected);

        if(multiplayerSelected)
        {
            drawHard(multiplayerX);
        }

        return hardPane;
    }

    private void drawHard(int x)
    {
        Label k = new Label("jj");
        
        hardPane.getChildren().addAll(k);
    }


    /* 
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
    

    private void drawBall()
    {
        ball = new Ball(400, 400, 5, 5, 4);
        ball.drawBall();
    }
    */
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
