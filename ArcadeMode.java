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

import static javafx.application.Platform.exit;

public class ArcadeMode {
    private int numberOfXs;

    public void setNumberOfXs(int numberOfXs) {
        this.numberOfXs = numberOfXs;
    }
    Countdown countdown = new Countdown();
    Group root =new Group();
    Scene scene =new Scene(root);
    Canvas canvas = new Canvas(1350, 735);

    Random random = new Random();

    public Scene getscene (){
        root.getChildren().add(canvas);
        int i=0;
        System.out.println("get scene");
        countdown.countdowntimer();
         int x = random.nextInt(6)+1;
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            int j =0;
            while (j != x) {
                Random random = new Random();
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
                x1.setOpacity(0.05);
                x2.setOpacity(0.05);
                x3.setOpacity(0.05);
                root.getChildren().addAll(x1, x2, x3);
                translateTransition1.setNode(im);
                translateTransition.setFromY(670);
                translateTransition.setToY(0);
                translateTransition.setFromX(xlocation);
                translateTransition1.setFromY(0);
                translateTransition1.setToY(670);
                translateTransition1.setFromX(xlocation);
                SequentialTransition seq = new SequentialTransition(pauseTransition, translateTransition, translateTransition1);

                seq.play();
                seq.setOnFinished(event -> {
                    boolean b = im.isVisible();
                    System.out.println(b + "" + x1 + "" + x2 + "" + x3);
                    if (b == true)
                        Xgui(x1, x2, x3).handle(event);


                });


                level1GameActions.setX(level1GameActions.getX() + 100);

                j++;

               }}));
        timeline.setCycleCount(1);
        timeline.play();
        timeline.setOnFinished(event -> {
            PauseTransition pauseTransition = new PauseTransition(Duration.millis(3000));
            pauseTransition.play();
            timeline.play();
        });



        return scene;
        }
    private EventHandler<ActionEvent> Xgui(ImageView x1, ImageView x2, ImageView x3) {
        System.out.println("inside Xgui");
        System.out.println(numberOfXs);


            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    numberOfXs++;
                    System.out.println(numberOfXs);
                    setNumberOfXs(numberOfXs);
                    if (numberOfXs == 1) {
                        x1.setOpacity(1.0);
                    }
                    if (numberOfXs == 2) {
                        x2.setOpacity(1.0);
                    }
                    if (numberOfXs == 3) {
                        x3.setOpacity(1.0);

                    }
                };};

            return event;



    }

}