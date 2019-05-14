package View;

import Controller.FruitFactory;
import Controller.GameObject;
import Model.level1GameActions;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.List;
import java.util.Random;

public class ArcadeMode {
    private int numberOfXs;

    public void setNumberOfXs(int numberOfXs) {
        this.numberOfXs = numberOfXs;
    }

    public Scene getscene (){
        Group root =new Group();
        Scene scene =new Scene(root);
        Canvas canvas = new Canvas(1350, 735);
        root.getChildren().add(canvas);
        Random random = new Random();
        int x = random.nextInt(6)+1;
        int i=0;
        while(i!=x) {
            Image imageX = new Image(getClass().getResource("X.png").toExternalForm());
            ImageView x1 = new ImageView(imageX);
            ImageView x2 = new ImageView(imageX);
            ImageView x3 = new ImageView(imageX);
            GraphicsContext graphics = canvas.getGraphicsContext2D();
            Image background = new Image(getClass().getResource("BG2.jpg").toExternalForm());
            graphics.drawImage(background, 0, 0);
            level1GameActions level1GameActions = new level1GameActions();
            level1GameActions.createGameObject(graphics);

            level1GameActions.setFruits(level1GameActions.getFruits());
            PauseTransition pauseTransition = new PauseTransition(Duration.millis(500));
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(8000));
            TranslateTransition translateTransition1 = new TranslateTransition(Duration.millis(8000));
            FruitFactory fruitFactory = new FruitFactory();
            GameObject fruits = fruitFactory.getFruits();
            ImageView im = new ImageView(fruits.toImage());
            translateTransition.setNode(im);
            root.getChildren().add(im);
            /*FadeTransition ft = new FadeTransition(Duration.millis(3000), x1);
            ft.setFromValue(0.1);
            ft.setToValue(1.0);
            ft.setAutoReverse(false);
            FadeTransition ft2 = new FadeTransition(Duration.millis(3000), x1);
            ft.setFromValue(0.1);
            ft.setToValue(1.0);
            ft2.setAutoReverse(false);
            FadeTransition ft3 = new FadeTransition(Duration.millis(3000), x1);
            ft.setFromValue(0.1);
            ft.setToValue(1.0);
            ft3.setAutoReverse(false);*/

            x1.setX(1100);
            x1.setY(50);
            x2.setX(1200);
            x2.setY(50);
            x3.setX(1300);
            x3.setY(50);
            x1.setVisible(false);
            x2.setVisible(false);
            x3.setVisible(false);
              root.getChildren().addAll(x1,x2,x3);
            if(im.isVisible()==true&&im.getX()==735)
            {
                Xgui(x1,x2,x3);
            }
                  translateTransition1.setNode(im);
            translateTransition.setFromY(730);
            translateTransition.setToY(0);
            translateTransition.setFromX(level1GameActions.getX());
            translateTransition1.setFromY(0);
            translateTransition1.setToY(735);
            translateTransition1.setFromX(level1GameActions.getX());
            SequentialTransition seq = new SequentialTransition(pauseTransition,translateTransition, translateTransition1);
            seq.play();

            level1GameActions.setX(level1GameActions.getX()+100);
            im.setOnMouseClicked(event -> {
                im.setVisible(false);


            });

            i++;
        }

        return scene;
    }
    public void Xgui(ImageView x1,ImageView x2,ImageView x3){


            numberOfXs++;
            System.out.println(numberOfXs);
            setNumberOfXs(numberOfXs);
            if (numberOfXs == 1) {
               x1.setVisible(true);
            }
            if (numberOfXs == 2) {
                x2.setVisible(true);
            }
            if (numberOfXs == 3) {
               x3.setVisible(true);
            }
        }

}
