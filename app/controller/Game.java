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
    private GameSetup gameSetup = new GameSetup();

    private CollisionHandler collisionHandler = new CollisionHandler();


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

    public Game(Block[][] blocks, Block[] gameWalls, Platform platform, Ball ball, Scene scene) {

        this.scene = scene;

        
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
        else
        {
            this.ball.move(); 

            //hits gamewalls
            if(this.ball.x < 0)
            {
                this.ball.bounceX();;
            }
            else if(this.ball.x > scene.getWidth())
            {
                this.ball.bounceX();
            }
            else if(this.ball.y > scene.getHeight())
            {
                this.ball.bounceY();
            }
            else if(this.ball.y < 0)
            {
                this.ball.bounceY();
            }

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

            for (Block gameWalls : this.blocks) {
                if (CollisionHandler.checkCollision(this.ball, gameWalls)) {
                    CollisionHandler.handleCollision(this.ball, gameWalls);
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
