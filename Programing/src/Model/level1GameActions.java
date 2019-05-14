package Model;

import Controller.FruitFactory;
import Controller.GameActions;
import Controller.GameObject;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

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
    public void createGameObject(GraphicsContext graphics1) {
        FruitFactory fruitFactory = new FruitFactory();
        GameObject f = fruitFactory.getFruits();
        double x =getX();
        double y = getY();
        System.out.println(f);
        /*for (int i = 0; i < f.size() ; i++) {
            //graphics1.drawImage(f.get(i).toImage(),getX(),getY());
            x+=200;
            setX(x);
        }
*/
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
