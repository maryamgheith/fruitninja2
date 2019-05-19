package Model;

import java.util.Observable;

public class Score extends Observable {
    int score;
    ScoreLabel scoreLabel;
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
