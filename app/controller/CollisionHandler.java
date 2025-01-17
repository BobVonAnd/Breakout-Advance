package app.controller;
import app.model.Ball;
import app.model.Block;
import app.model.Object2D;
import app.model.Platform;

public class CollisionHandler {
    private static Score score = new Score();

    public static boolean checkCollision(Object2D obj1, Object2D obj2) {
        // Check if two objects are colliding by comparing their x and y coordinates.
        return obj1.x - obj1.getWidth() < obj2.x + obj2.getWidth() &&
               obj1.x + obj1.getWidth() > obj2.x &&
               obj1.y - obj1.getHeight() < obj2.y + obj2.getHeight() &&
               obj1.y + obj1.getHeight() > obj2.y;
    }

    public static void handleCollision (Ball ball, Object2D obj) {
        if (obj instanceof Block block && !block.isDestroyed()) {
            // Sets visibilitty to false and then gives a point to the scoringsystem
            block.destroy();
            score.addPoints(1);
        }
        
        // Handle the collision between the ball and obj.
        if (ball.x - ball.getWidth() < obj.x + obj.getWidth() &&
            ball.x + ball.getWidth() > obj.x &&
            ball.y - ball.getHeight() < obj.y + obj.getHeight() &&
            ball.y + ball.getHeight() > obj.y) {
            // If the ball is colliding with the object, bounce the ball in the x or y direction.
            if (ball.x - ball.getWidth() < obj.x + obj.getWidth() &&
                ball.x + ball.getWidth() > obj.x) {
                ball.bounceY();
                if (obj instanceof Platform platform) {
                    ball.setVx(ball.getVx() + platform.getVelocity() * platform.getWeight() * 0.3);
                } else {
                    ((Block) obj).destroy();
                }
            } else {
                ball.bounceX();
            }
        }
    }

    public static int getScore() {
        return score.getScore();
    }

    public static int resetScore() {
        return resetScore();
    }
}
