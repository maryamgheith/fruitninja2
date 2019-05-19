package Model;

import Controller.BombFactory;
import Controller.FruitFactory;
import Controller.GameActions;
import Controller.GameObject;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;
import java.util.Random;

public class level1GameActions implements GameActions,Observer {
    int score;
    double x;
    double y;
    List<GameObject> fruits;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public level1GameActions(){
        this.score = score;
    }
    @Override
    public GameObject createGameObject(GraphicsContext graphics1) {
        FruitFactory fruitFactory = new FruitFactory();
        BombFactory bombFactory =  new BombFactory();
        GameObject f = fruitFactory.getFruits();
        GameObject b = bombFactory.GetBombs();
        Random random = new Random();
        int x = random.nextInt(4)+1;
        if(x%3==0)
            return b;
        else return f;
    }

    @Override
    public void updateObjectsLocations() {

    }

    @Override
    public void sliceObjects() {

    }

    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }

    @Override
    public void ResetGame() {

    }

    @Override
    public void update(int score) {
        score+=10;
    }
}