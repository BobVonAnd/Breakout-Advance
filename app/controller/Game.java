package app.controller;
import app.model.Ball;
import app.model.Block;
import app.model.Platform;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;

public class Game 
{
    //nodes objects
    private final Block[] blocks;
    private final Platform platform;
    private final Ball ball;
   

    private boolean gameOver;

    private Scene scene;

    //doesn't work with multiplayer button
    public static final int width = 600;
    public static final int height = 600;

    private boolean gameStarted = false;


    public Game(Block[][] blocks, Platform platform, Ball ball, Scene scene) {

        //makes blocks[][] -> blocks[]
        //and swiches n and m dependen on which is biggest in value.
        this.blocks = new Block[blocks.length * blocks[0].length];
        
        if(blocks[0].length < blocks.length)
        {
            for(int i = 0; i < blocks[0].length; i++)
            {
                for(int j = 0; j < blocks.length; j++)
                {
                    if(!(i == 0) && !(j == 0))
                    {
                        //System.out.println(i*blocks.length + j);
                        this.blocks[i*blocks.length + j] = blocks[j][i];
                    }
                    else if(!(i == 0) && j == 0)
                    {
                        //System.out.println(i*blocks.length);
                        this.blocks[i*blocks.length] = blocks[j][i];
                    }
                    else
                    {
                        //System.out.println(i*blocks[0].length +j);
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
                        //System.out.println(i*blocks[0].length + j);
                        this.blocks[i*blocks[0].length + j] = blocks[i][j];
                    }
                    else if(!(i == 0) && j == 0)
                    {
                        
                        //System.out.println(i*blocks[0].length);
                        this.blocks[i*blocks[0].length] = blocks[i][j];
                    }
                    else
                    {
                        //System.out.println(i*blocks[0].length +j);
                        this.blocks[i*blocks[0].length +j] = blocks[i][j];
                    }
                }
            }
        }
        

        this.scene = scene;
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
        else if(!gameOver)
        {
            //moves ball
            this.ball.move(); 

            //makes sure platform can't get out of the gamebounderies
            if(this.platform.x < 0)
            {
                this.platform.setX(0);
            }
            else if(this.platform.x + this.platform.getWidth() > scene.getWidth())
            {
                this.platform.setX((int)(scene.getWidth() - this.platform.getWidth()));
            }

            //hits game bounderies (top, right and left side)
            if(this.ball.x < 0)
            {
                this.ball.bounceX();
            }
            else if(this.ball.x > scene.getWidth())
            {
                this.ball.bounceX();
            }
            else if(this.ball.y <= 0)
            {
                this.ball.bounceY();
            }

            //checkes for collision between ball and platform
            if (CollisionHandler.checkCollision(this.ball, this.platform)) {
                CollisionHandler.handleCollision(this.ball, this.platform);
            }
            //checkes for collision between ball and block
            for (Block block : this.blocks) {
                if (CollisionHandler.checkCollision(this.ball, block) && block.exists()) {
                    CollisionHandler.handleCollision(this.ball, block);
                }
            }

            //checkes for collision between ball and buttem gamebonderi
            if (this.ball.y > scene.getHeight()) {
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
