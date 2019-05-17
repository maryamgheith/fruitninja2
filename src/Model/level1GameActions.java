package Model;

import Controller.BombFactory;
import Controller.FruitFactory;
import Controller.GameActions;
import Controller.GameObject;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;
import java.util.Random;

public class level1GameActions implements GameActions {
    double x;
    double y;
    List<GameObject> fruits;

    public List<GameObject> getFruits() {
        return fruits;
    }

    public void setFruits(List<GameObject> fruits) {
        this.fruits = fruits;
    }

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
        setX(800);
        setFruits(fruits);
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
        setX(x);
        setY(y);

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
}
