package View;

import Controller.BombFactory;
import Controller.FruitFactory;
import Controller.GameObject;
import Model.FatalBomb;
import Model.level1GameActions;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class ArcadeMode {
    private int numberOfXs;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;
private int i;

    public void setI(int i) {
        i++;
        this.i = i;
    }

    public void setNumberOfXs(int numberOfXs) {
        this.numberOfXs = numberOfXs;
    }
    Countdown countdown = new Countdown();

    Group root =new Group();
    Scene scene =new Scene(root);
    Canvas canvas = new Canvas(1350, 735);

    Random random = new Random();

    public void getscene (){
        SceneCalling sceneCalling= new SceneCalling();
       setStage(sceneCalling.getStage());

        root.getChildren().add(canvas);

       setI(0);
        //countdown.countdowntimer();
AnimationTimer animationTimer = new AnimationTimer() {
    @Override
    public void handle(long now) {

    }
};
//animationTimer.

        Timeline timeline = new Timeline();
             KeyFrame keyFrame =   new KeyFrame(Duration.seconds(7), ev -> {
           int x= (int) (random.nextInt(3)+1+Math.pow(-1,random.nextInt(3)));

            int j =0;

            while (j != x) {



                GraphicsContext graphics = canvas.getGraphicsContext2D();
                Image background = new Image(getClass().getResource("BG2.jpg").toExternalForm());
                graphics.drawImage(background, 0, 0);
                level1GameActions level1GameActions = new level1GameActions();
                level1GameActions.createGameObject(graphics);
                int xlocation = random.nextInt(1300);
                level1GameActions.setFruits(level1GameActions.getFruits());
                PauseTransition pauseTransition = new PauseTransition(Duration.millis(random.nextInt(9)*100));
                TranslateTransition translateTransition = new TranslateTransition(Duration.millis(3000));
                TranslateTransition translateTransition1 = new TranslateTransition(Duration.millis(3000));
                GameObject fruits = level1GameActions.createGameObject(graphics);
                ImageView im = new ImageView(fruits.toImage());
               /* public void mouseClicked(MouseEvent e) {


                public void mousePressed(MouseEvent e) {


                public void mouseReleased(MouseEvent e) {

                public void mouseEntered(MouseEvent e) {

                public void mouseExited(MouseEvent e) {

               */ im.setOnMouseDragOver(event -> {
                    if(fruits.getObjectType()==GameObject.FallingObjectType.FBOMB) {
                       GameOver gameOver=new GameOver("Arcade");
                        im.setVisible(false);
                    }else im.setVisible(false); });


                translateTransition.setNode(im);
                root.getChildren().add(im);

                Path path = new Path();
                int quadx =random.nextInt(1150);
                MoveTo moveTo = new MoveTo();
                moveTo.setX(quadx);
                moveTo.setY(760);


                QuadCurveTo quadCurveTo = new QuadCurveTo();
                quadCurveTo.setX(quadx+Math.pow(-1,j)*500);
                quadCurveTo.setY(750.0f);
                quadCurveTo.setControlX(quadx+250);
                quadCurveTo.setControlY(-500);
                path.getElements().add(moveTo);

                path.getElements().add(quadCurveTo);
               translateTransition1.setNode(im);
                PathTransition pathTransition= new PathTransition();
                pathTransition.setNode(im);
                pathTransition.setPath(path);
                pathTransition.setDuration(Duration.millis(5000));
                translateTransition.setFromY(670);
                translateTransition.setToY(0);
                translateTransition.setFromX(xlocation);
                translateTransition1.setFromY(0);
                translateTransition1.setToY(670);
                translateTransition1.setFromX(xlocation);
                SequentialTransition seq = new SequentialTransition(pauseTransition,pathTransition);
                seq.play();
                seq.setOnFinished(event -> {
                    boolean b = im.isVisible();
                    im.setVisible(false);




                });


                level1GameActions.setX(level1GameActions.getX() + 100);

                j++;

               }               setI(i);
            if (i==10)
                timeline.stop();
        });
             timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(40);
        timeline.play();

        timeline.setOnFinished(event -> {
            PauseTransition pauseTransition = new PauseTransition(Duration.millis(3000));
            pauseTransition.play();
            timeline.play();
        });
       stage.setScene(scene);
stage.show();

        }

}

