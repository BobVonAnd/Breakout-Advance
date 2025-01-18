package app.visuel;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import app.model.Ball;
import app.model.Block;
import app.model.Platform;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;


public class GameSetup 
{
    // update scoringssystem
    private AnimationTimer timer;

    //dimentions of blocks
    private int width = 59;
    private int height = 25;
    private int[] pos = new int[] {0, 50};


    //[0] wall, [1] not a wall
    private boolean[] isWall = new boolean[] {true, false};

    //objects
    private Block[][] blocks;
    private Ball ball;
    private Platform platform;

    //Panes
    private Pane easyPane = new Pane();
    private Pane mediumPane = new Pane();
    private Pane hardPane = new Pane();

    private Scene gameScene;

    //bonus scene size
    private int multiplayerX = 605;
    private int notSelected = 0;

    //backgound color
    private BackgroundFill backgroundFill = 
    new BackgroundFill(Color.valueOf("#D3D3D3"), null, null);
    private Background background = new Background(backgroundFill);

    private boolean multiplayer;
    private int gameWidth;
    private int gameHeight;

    //nm
    private int[] yx;

    private Label scoreLabel = new Label("Score: 0");

    //emty construkctor
    public GameSetup()
    {

    }

    //construcktor
    public GameSetup(int gameWidth, int gameHeight, boolean multiplayer, int[] nm)
    {
        this.multiplayer = multiplayer;
        if(multiplayer)
        {
            this.gameWidth = gameWidth + multiplayerX;
        }
        else
        {
            this.gameWidth = gameWidth;
        }
        this.gameHeight = gameHeight;
        this.yx = nm;
        this.blocks = new Block[yx[1]][yx[0]];
        
        colculateSpace();
    }

    //colculates the width of blocks
    private void colculateSpace()
    {
        width = gameWidth/yx[1];
        pos[0] =- width;
        pos[1] = pos[1] + 25 * yx[0];
    }

    //Easy gamemode_______________________________________________________________________________
    
    public Scene makeEasyPane()
    {
        easyPane.setBackground(background);
        gameScene = new Scene(easyPane, gameWidth, gameHeight);

        // Scorelabel
        scoreLabel.setLayoutX(10); 
        scoreLabel.setLayoutY(10);
        easyPane.getChildren().add(scoreLabel); 
       
        

        drawEasy(notSelected);

        //does a copy of the singleplayer game
        if(multiplayer)
        {
            drawEasy(multiplayerX);
        }
        startGameLoop();
        return gameScene;
    }

    //creates all objects/nodes in the game
    private void drawEasy(int x)
    {
        //y row
        for(int i = 0; i < yx[0]; i++)
        {
            //x row
            for(int j = 1; j < yx[1]+1; j++)
            {   
                this.blocks[j-1][i] = new Block(width, height, pos[0] + j * width+1 + x, pos[1] - i * 26 , isWall[1]);
                easyPane.getChildren().add(blocks[j-1][i].getRectangle());
            }
        }

       
       
       
        //Platform____________________________________________
        this.platform = new Platform(100, 10, 250+x, 450, gameScene);

        //Ball________________________________________________
        this.ball = new Ball(6, 297 + x, 444, 5, 5);
        easyPane.getChildren().addAll(platform.getRectangle(), ball.getCircle());

        updateScore(); 
    }


    //Medium gamemode_______________________________________________________________________
    
    //copy of easymode (medium hasn't been made yet)
    public void makeMediumPane()
    {
        // Scorelabel
        scoreLabel.setLayoutX(10); 
        scoreLabel.setLayoutY(10);
        mediumPane.getChildren().add(scoreLabel); 
        
        drawMedium(notSelected);

       if(multiplayer)
       {
            drawMedium(multiplayerX);
       }
    }

    //creates all objects/nodes in the game
    private void drawMedium(int x)
    {
        Label k = new Label("jj");
        k.setLayoutX(200+x);
        mediumPane.getChildren().addAll(k);

        updateScore(); 
    }
    

    //Hard gamemode__________________________________________________________________________
    //copy of easymode (medium hasn't been made yet)
    public Pane makeHardPane()
    {
        // Scorelabel
        scoreLabel.setLayoutX(10); 
        scoreLabel.setLayoutY(10);
        hardPane.getChildren().add(scoreLabel); 

        drawHard(notSelected);

        if(multiplayer)
        {
            drawHard(multiplayerX);
        }

        return hardPane;
    }
    //creates all objects/nodes in the game
    private void drawHard(int x)
    {
        Label k = new Label("jj");
        
        hardPane.getChildren().addAll(k);

        updateScore(); 
    }

    //updates score
    private void startGameLoop() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateScore(); 
            }
        };
        timer.start();
    }
    //stops updateing score
    private void stopGameLoop() {
        if (timer != null) {
            timer.stop();
        }
    }
    //updates score
    private void updateScore()
    {
        scoreLabel.setText("Score: " + app.controller.CollisionHandler.getScore()); 
    }

    //getmethods
    public Scene getScene()
    {
        return gameScene;
    }

    public Block[][] getBlocks()
    {
        return blocks;
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
