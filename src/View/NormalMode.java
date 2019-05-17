package View;

import Controller.FruitFactory;
import Controller.GameObject;
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
import javafx.scene.layout.VBox;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.stage.Modality;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class NormalMode {
    private int levelofdifficulty;
    private int numberOfXs;
    public void setNumberOfXs(int numberOfXs) {
        this.numberOfXs = numberOfXs;
    }

    public void setLevelofdifficulty(int levelofdifficulty) {
        this.levelofdifficulty = levelofdifficulty;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;

    private int i;

    public void setI(int i) {
        i++;
        this.i = i;
    }
    public void getscene(){
        SceneCalling sceneCalling= new SceneCalling();
        setStage(sceneCalling.getStage());

        Group root =new Group();
        Scene scene =new Scene(root);
        Canvas canvas = new Canvas(1350, 735);
        root.getChildren().add(canvas);
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        Image background = new Image(getClass().getResource("BG2.jpg").toExternalForm());
        graphics.drawImage(background, 0, 0);
        Random random = new Random();
        setI(0);
        Timeline timeline = new Timeline();
       KeyFrame keyframe =  new KeyFrame(Duration.seconds(7), ev -> {

            int x= (int) (random.nextInt(3+levelofdifficulty)+1+Math.pow(-1,random.nextInt(3)));

            int j =0;
            System.out.println("integer i"+i);
            while (j != x) {


                Image imageX = new Image(getClass().getResource("X.png").toExternalForm());
                ImageView x1 = new ImageView(imageX);
                ImageView x2 = new ImageView(imageX);
                ImageView x3 = new ImageView(imageX);

                Model.level1GameActions level1GameActions = new level1GameActions();
                level1GameActions.createGameObject(graphics);
                int xlocation = random.nextInt(1300);
                PauseTransition pauseTransition = new PauseTransition(Duration.millis(random.nextInt(9)*100));
                GameObject fruits = level1GameActions.createGameObject(graphics);
                ImageView im = new ImageView(fruits.toImage());
                im.setOnMouseClicked(event -> {
                    im.setVisible(false);
                });
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

                Path path = new Path();
                int quadx =random.nextInt(11) * 100+50;
                MoveTo moveTo = new MoveTo();
                moveTo.setX(quadx);
                moveTo.setY(760);


                QuadCurveTo quadCurveTo = new QuadCurveTo();
                quadCurveTo.setX(quadx+random.nextInt(5)*100+Math.pow(-1,j)*500);
                quadCurveTo.setY(750.0f);
                quadCurveTo.setControlX(quadx+250);
                quadCurveTo.setControlY(-500);
                path.getElements().add(moveTo);

                path.getElements().add(quadCurveTo);

                PathTransition pathTransition= new PathTransition();
                pathTransition.setNode(im);
                pathTransition.setPath(path);
                pathTransition.setDuration(Duration.millis(3000+(levelofdifficulty*100)));

                SequentialTransition seq = new SequentialTransition(pauseTransition,pathTransition);
                seq.play();
                seq.setOnFinished(event -> {
                    boolean b = im.isVisible();
                    im.setVisible(false);
                    System.out.println(b + "" + x1 + "" + x2 + "" + x3);
                    if (b == true)
                        Xgui(x1, x2, x3).handle(event);


                });


                level1GameActions.setX(level1GameActions.getX() + 100);

                j++;
                if(numberOfXs==3)
                    timeline.stop();

            }
            setI(i);

        });
        timeline.getKeyFrames().add(keyframe);
        timeline.setCycleCount(40);
        timeline.play();

        stage.setScene(scene);
        stage.show();

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
                   // Countdown countdown=new Countdown();

                 new GameOver("Normal");
                }
            };};

        return event;



    }



    public void Difficulty()
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Difficulty");

        //window.setMaxWidth(500);
        Label label = new Label();
        label.setText("Select Difficulty");


        Button hard = new Button("Hard");
        hard.setOnAction(e->{
           setLevelofdifficulty(3);
            window.close();

        });
        Button Medium = new Button("Medium");
        Medium.setOnAction(e->{
            setLevelofdifficulty(2);
            window.close();

        });
        Button Easy = new Button("Easy");


        Easy.setOnAction(e->{
            setLevelofdifficulty(1);

            window.close();


        });
        HBox layout = new HBox(10);
        label.setAlignment(Pos.CENTER);
        VBox vBox = new VBox();
        layout.getChildren().addAll(Easy,Medium,hard);
vBox.getChildren().addAll(label,layout);
            Easy.setLayoutX(250);
            Easy.setLayoutY(250);
            Medium .setLayoutX(500);
            Medium .setLayoutY(250);
            hard.setLayoutX(750);
            hard .setLayoutY(250);


        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.showAndWait();





}
}
