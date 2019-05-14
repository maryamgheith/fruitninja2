package Model;

import Controller.GameObject;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Banana extends Fruits {


    @Override
    public String objname() {
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
    public BufferedImage[] getBufferedImages() {
        BufferedImage[] images = new BufferedImage[1];
        images[0] = null;
        try {
            images[0] = ImageIO.read(new File("C:\\Users\\User\\Desktop\\Programing\\src\\pictures\\banana-hd.png"));
        } catch (IOException ex) {
            System.out.println("Image failed to load. banana");
        }
        return images;

    }

    @Override
    public Image toImage() {
        BufferedImage buffered[] = getBufferedImages();
        Image image = SwingFXUtils.toFXImage(buffered[0], null);
        return image;
    }

}
