package Model;

import Controller.FruitFactory;
import Controller.GameActions;
import Controller.GameObject;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Fruits implements GameObject {
    double x;

    public enum FallingObjectType {
        FRUIT,BOMB
    }

    @Override
    public Enum getObjectType() {
       return FallingObjectType.FRUIT;
    }

    @Override
    public abstract int getXlocation();

    @Override
    public abstract int getYlocation();

    @Override
    public abstract int getMaxHeight();

    @Override
    public abstract int getInitialVelocity();

    @Override
    public abstract int getFallingVelocity();
    @Override
    public Boolean isSliced() {
        return true;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        return false;}

    @Override
    public void slice() {

    }

    @Override
    public void move(double time) {

    }

    @Override
    public abstract BufferedImage[] getBufferedImages();

    @Override
    public abstract Image toImage();
    public GameObject createGameObject (){
        FruitFactory fruitFactory = new FruitFactory();
       GameObject g =  fruitFactory.getFruits();
       return g;
    }
    public void updateObjectsLocations (){

    }
    public void sliceObjects (){

    }
    public void saveGame (){

    }
    public void loadGame (){

    }
    public void ResetGame (){

    }
}
