package Model;

import Controller.GameObject;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;

public class Bomb implements GameObject {
    @Override
    public String objname() {
        return "bomb";
    }

    @Override
    public Enum getObjectType() {
        return null;
    }

    @Override
    public int getXlocation() {
        return 0;
    }

    @Override
    public int getYlocation() {
        return 0;
    }

    @Override
    public int getMaxHeight() {
        return 0;
    }

    @Override
    public int getInitialVelocity() {
        return 0;
    }

    @Override
    public int getFallingVelocity() {
        return 0;
    }

    @Override
    public Boolean isSliced() {
        return null;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        return null;
    }

    @Override
    public void slice() {

    }

    @Override
    public void move(double time) {

    }

    @Override
    public BufferedImage[] getBufferedImages() {
        return new BufferedImage[0];
    }

    @Override
    public Image toImage() {
        BufferedImage bufferedImages[] = getBufferedImages();
        Image image = SwingFXUtils.toFXImage(bufferedImages[0], null);
        return image;
    }

    }
