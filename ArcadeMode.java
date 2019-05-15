package View;

import Controller.FruitFactory;
import Controller.GameObject;
import Model.level1GameActions;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.sql.Time;
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

      //  Timeline timeline = new Timeline();
       // KeyFrame gameloop = new KeyFrame(Duration.minutes(1),
             //   new EventHandler<ActionEvent>() {

                   // public void handle(ActionEvent event1) {
                        int j =0;
                        while ( j!= x) {
                            System.out.println("fruits number " + i);
                            Image imageX = new Image(getClass().getResource("X.png").toExternalForm());
                            ImageView x1 = new ImageView(imageX);
                            ImageView x2 = new ImageView(imageX);
                            ImageView x3 = new ImageView(imageX);
                            GraphicsContext graphics = canvas.getGraphicsContext2D();
                            Image background = new Image(getClass().getResource("BG2.jpg").toExternalForm());
                            graphics.drawImage(background, 0, 0);
                            level1GameActions level1GameActions = new level1GameActions();
                            level1GameActions.createGameObject(graphics);
                            int xlocation = random.nextInt(13) * 100;
                            level1GameActions.setFruits(level1GameActions.getFruits());
                            PauseTransition pauseTransition = new PauseTransition(Duration.millis(xlocation));
                            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(8000));
                            TranslateTransition translateTransition1 = new TranslateTransition(Duration.millis(8000));
                            FruitFactory fruitFactory = new FruitFactory();
                            GameObject fruits = fruitFactory.getFruits();
                            ImageView im = new ImageView(fruits.toImage());
                            translateTransition.setNode(im);
                            root.getChildren().add(im);
                            x1.setX(1100);
                            x1.setY(50);
                            x2.setX(1200);
                            x2.setY(50);
                            x3.setX(1300);
                            x3.setY(50);
                            x1.setVisible(false);
                            x2.setVisible(false);
                            x3.setVisible(false);
                            root.getChildren().addAll(x1, x2, x3);
                            translateTransition1.setNode(im);
                            translateTransition.setFromY(730);
                            translateTransition.setToY(0);
                            translateTransition.setFromX(xlocation);
                            translateTransition1.setFromY(0);
                            translateTransition1.setToY(735);
                            translateTransition1.setFromX(xlocation);
                            SequentialTransition seq = new SequentialTransition(pauseTransition, translateTransition, translateTransition1);

                            seq.play();
                            seq.setOnFinished(event -> {
                                boolean b = im.isVisible();

                                Xgui(b, x1, x2, x3).handle(event);

                            });


                            level1GameActions.setX(level1GameActions.getX() + 100);
                            im.setOnMouseClicked(event -> {
                                im.setVisible(false);


                            });

                            j++;
                        }

                    //}
        //});
       /// timeline.getKeyFrames().add(gameloop);
       // timeline.play();


        return scene;
    }
    private EventHandler<ActionEvent> Xgui(boolean b ,ImageView x1, ImageView x2, ImageView x3) {
        System.out.println("inside Xgui");
        System.out.println(numberOfXs+""+b);

        if(b==true)
        {
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                numberOfXs++;
        /*    FadeTransition ft = new FadeTransition(Duration.millis(3000), x1);
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
            };};

        return event;
        }
        else return null;


        }

}
