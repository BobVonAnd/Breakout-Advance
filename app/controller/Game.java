package app.controller;
import app.model.Ball;
import app.model.Block;
import app.model.Platform;
import app.visuel.GameSetup;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Game 
{
    //private final int numberOfBlocks = 10;
    private final Block[] blocks;
    private final Platform platform;
    private final Ball ball;
   

    private boolean gameOver;

    private Scene scene;

    //skal fixes
    public static final int width = 600;
    public static final int height = 600;

    private boolean gameStarted = false;

    public Game(Block[][] blocks, Platform platform, Ball ball, Scene scene) {

        this.scene = scene;
        
        
        // Initialize the game by creating an array of blocks and defining the platform and ball.
        
        //makes blocks[][] -> blocks[]
        this.blocks = new Block[blocks.length * blocks[0].length];

        System.out.println(blocks[0].length + " " + blocks.length);

        
        if(blocks[0].length < blocks.length)
        {
            for(int i = 0; i < blocks[0].length; i++)
            {
                for(int j = 0; j < blocks.length; j++)
                {
                    //System.out.println("i " + i);
                    if(!(i == 0) && !(j == 0))
                    {
                        System.out.println(i*blocks.length + j);
                        this.blocks[i*blocks.length + j] = blocks[j][i];
                    }
                    else if(!(i == 0) && j == 0)
                    {
                        System.out.println(i*blocks.length);
                        this.blocks[i*blocks.length] = blocks[j][i];
                    }
                    else
                    {
                        System.out.println(i*blocks[0].length +j);
                        this.blocks[i*blocks[0].length +j] = blocks[j][i];
                    }
                
                }
            }
        }
        else
        {
            for(int i = 0; i < blocks.length; i++)
            {
                for(int j = 0; j < blocks[0].length; j++)
                {

                    if(!(i == 0) && !(j == 0))
                    {
                        System.out.println("bob");
                        System.out.println(i*blocks[0].length + j);
                        this.blocks[i*blocks[0].length + j] = blocks[i][j];
                    }
                    else if(!(i == 0) && j == 0)
                    {
                        System.out.println("hej");
                        System.out.println(i*blocks[0].length);
                        this.blocks[i*blocks[0].length] = blocks[i][j];
                    }
                    else
                    {
                        System.out.println(i*blocks[0].length +j);
                        this.blocks[i*blocks[0].length +j] = blocks[i][j];
                    }
                }
            }
        }
        


        this.platform = platform;
        this.ball = ball;
        this.gameOver = false;


        startGame();

    }

    //Loop
    private void startGame()
    {
        
        new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                
                updateBall();
                
            }
        }.start();
        
        
    }

    private void updateBall()
    {
        //makes sure that the ball doesn't move until before the platform.
        //sets the angle of the ball.
        if(!gameStarted)
        {
            gameStarted = this.platform.firstMove();
            this.ball.setAngle(this.platform.rightLeft());
        }
        //moves ball and checks for collitionens
        else if(!gameOver)
        {
            this.ball.move(); 


            if(this.platform.x < 0)
            {
                this.platform.setX(0);
            }
            else if(this.platform.x + this.platform.getWidth() > scene.getWidth())
            {
                this.platform.setX((int)(scene.getWidth() - this.platform.getWidth()));
            }

            //hits gamewalls
            if(this.ball.x < 0)
            {
                this.ball.bounceX();
            }
            else if(this.ball.x > scene.getWidth())
            {
                this.ball.bounceX();
            }
            else if(this.ball.y < 0)
            {
                this.ball.bounceY();
            }

            if (CollisionHandler.checkCollision(this.ball, this.platform)) {
                CollisionHandler.handleCollision(this.ball, this.platform);
            }
    
            for (Block block : this.blocks) {
                if (CollisionHandler.checkCollision(this.ball, block) && block.exists()) {
                    CollisionHandler.handleCollision(this.ball, block);
                }
            }

            if (this.ball.y < 0) {
                this.gameOver = true;
            }
    
            // Check if all the blocks have been destroyed and end the game if they have.
            boolean allBlocksDestroyed = true;
            for (Block block : this.blocks) {
                if (block.exists()) {
                    allBlocksDestroyed = false;
                }
            }

            if (allBlocksDestroyed) {
                this.gameOver = true;
               
            }
        }
          
    }


    public void firstMove()
    {
        gameStarted = true;
    }
    
}
