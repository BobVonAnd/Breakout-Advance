package app.controller;
public class Score {
    private int score;

    // Constructor to initialize score
    public Score() {
        this.score = 0;
    }

    // Method to add points to the score
    public void addPoints(int points) {
        score += points;
    }

    // Method to reset the score
    public void resetScore() {
        score = 0;
    }

    // Method to retrieve the current score
    public int getScore() {
        return score;
    }
}
