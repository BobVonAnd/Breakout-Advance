package app.visuel;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import app.model.Ball;
import app.model.Block;
import app.model.Platform;
import app.model.Wall;
import javafx.scene.Scene;






public class GameSetup 
{

    //private Color c = new Color(0, 0, 0, 0);

    private int width = 59;
    private int height = 25;
    private int[] pos = new int[] {0, 150};

    private int xSize = 10;
    private int ySize = 3; 

    //[0] wall, [1] not a wall
    private boolean[] isWall = new boolean[] {true, false};

    //objects
    private Block[] blocks = new Block[xSize*ySize];
    private Ball ball;
    private Wall[] wall = new Wall[3];
    private Platform platform;


    private Pane easyPane = new Pane();
    private Pane mediumPane = new Pane();
    private Pane hardPane = new Pane();

    private Scene gameScene;

    private int multiplayerX = 605;
    private int notSelected = 0;

    private boolean multiplayer;
    private int gameWidth;
    private int gameHeight;


    public GameSetup()
    {

    }

    public GameSetup(int gameWidth, int gameHeight, boolean multiplayer)
    {
        this.multiplayer = multiplayer;
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
    }


    //Easy gamemode_______________________________________________________________________________
    
    public Scene makeEasyPane()
    {
        gameScene = new Scene(easyPane, gameWidth, gameHeight);
        drawEasy(notSelected);

        if(multiplayer)
        {
            drawEasy(multiplayerX);
        }
        return gameScene;
    }

    private void drawEasy(int x)
    {
        for(int i = 0; i < ySize; i++)
        {
            for(int j = 0; j < xSize; j++)
            {
                this.blocks[i*xSize+j] = new Block(width, height, pos[0] + j * 60 + x, pos[1] - i * 35 , isWall[1]);
                easyPane.getChildren().add(blocks[xSize*i+j].getRectangle());
            }
        }
        //Platform____________________________________________
        this.platform = new Platform(100, 10, 250+x, 450, gameScene);

        //Ball________________________________________________
        this.ball = new Ball(6, 297 + x, 345, 2, 2);
        easyPane.getChildren().addAll(platform.getRectangle(), ball.getCircle());
    }


    //Medium gamemode_______________________________________________________________________
    

    public void makeMediumPane()
    {
        drawMedium(notSelected);

       if(multiplayer)
       {
            drawMedium(multiplayerX);
       }
    }

    private void drawMedium(int x)
    {
        Label k = new Label("jj");
        k.setLayoutX(200+x);
        mediumPane.getChildren().addAll(k);
    }
    

    //Hard gamemode__________________________________________________________________________
    public Pane makeHardPane()
    {
        drawHard(notSelected);

        if(multiplayer)
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


    public Scene getScene()
    {
        return gameScene;
    }

    public Block[] getBlocks()
    {
        return blocks;
    }

    public Wall[] getWalls()
    {
        return wall;
    }

    
    public Platform getPlatform()
    {
        return platform;
    }
    

    public Ball getBall()
    {
        return ball;
    }

    
    


    
}
