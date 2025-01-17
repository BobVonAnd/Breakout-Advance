package app.controller;
import javafx.scene.shape.Rectangle;
import app.model.Ball;
import app.model.Block;
import app.model.Platform;
import app.visuel.GameSetup;
import javafx.animation.AnimationTimer;
import javafx.scene.shape.Circle;

public class Game 
{
    private GameSetup gameSetup = new GameSetup();


    //private final int numberOfBlocks = 10;
    private final Block[] blocks;
    private final Platform platform;
    private final Ball ball;
    private boolean gameOver;

    //skal fixes
    public static final int width = 600;
    public static final int height = 600;

    private boolean gameStarted = false;

    public Game(Block[][] blocks, Platform platform, Ball ball) {
        // Initialize the game by creating an array of blocks and defining the platform and ball.
        
        //makes blocks[][] -> blocks[]
        this.blocks = new Block[blocks.length * blocks[0].length];

        for(int i = 0; i < blocks[0].length; i++)
        {
            for(int j = 0; j < blocks.length; j++)
            {
                this.blocks[i*blocks[0].length +j] = blocks[j][i];
            }
        }
        this.platform = platform;
        this.ball = ball;
        this.gameOver = false;
        startGame();
    }


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
        if(!gameStarted)
        {
            gameStarted = this.platform.firstMove();
            this.ball.setAngle(this.platform.rightLeft());
        }
        else
        {
            this.ball.move(); 

            if (CollisionHandler.checkCollision(this.ball, this.platform)) {
                CollisionHandler.handleCollision(this.ball, this.platform);
                System.out.println("Ball collided with platform.");
            }
    
            for (Block block : this.blocks) {
                if (CollisionHandler.checkCollision(this.ball, block) && block.exists()) {
                    CollisionHandler.handleCollision(this.ball, block);
                    System.out.println("Ball collided with block.");
                }
            }

            if (this.ball.outOfBounds()) {
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
    









    private void gameLoop() {

        // Check if the user has pressed a or d and move the platform accordingly.
        //if (StdDraw.isKeyPressed(65)) {
        //    this.platform.moveX(-2);
        //}
        //if (StdDraw.isKeyPressed(68)) {
        //    this.platform.moveX(2);
        //}

        // Check for collisions with the ball and the walls and bounce the ball.

        while(true)
        {
            this.ball.bounceOffWalls();
        
            // Check for collisions with the platform and blocks and move the ball.
            if (CollisionHandler.checkCollision(this.ball, this.platform)) {
                CollisionHandler.handleCollision(this.ball, this.platform);
                System.out.println("Ball collided with platform.");
            }
    
            for (Block block : this.blocks) {
                if (CollisionHandler.checkCollision(this.ball, block) && block.exists()) {
                    CollisionHandler.handleCollision(this.ball, block);
                    System.out.println("Ball collided with block.");
                }
            }
            
    
            //this.ball.draw();
    
    
            // Draw the platform and ball.
            /* 
            StdDraw.show(0);
            StdDraw.clear(StdDraw.WHITE);
            this.ball.draw();
            this.platform.draw();
            for (Block block : this.blocks) {
                if (block.exists()) {
                    block.draw();
                }
            }
            */
    
            // Check if the ball is out of bounds and end the game if it is.
            if (this.ball.outOfBounds()) {
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
    
            // Call the game loop again after a short delay if the game is not over.
            
            
            

            /* 
            if (!this.gameOver) {
                gameLoop();
            }
                */
        }
        
    }
    

    
    
}
