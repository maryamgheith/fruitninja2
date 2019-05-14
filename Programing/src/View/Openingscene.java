package View;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Openingscene extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FruitNinja");
        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        Canvas canvas = new Canvas(1350, 735);
        root.getChildren().add(canvas);
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        Image background = new Image(getClass().getResource("BG.jpg").toExternalForm());
        graphics.drawImage(background, 0, 0);
        Button Arcade = new Button();
        ArcadeMode arcadeMode=new ArcadeMode();
        //Arcade.
       Arcade.setLayoutX(775);
       Arcade.setLayoutY(350);
        Image i = new Image(String.valueOf(getClass().getResource("Arcade.png")));
        Arcade.setGraphic(new ImageView(i));
        NormalMode normalMode=new NormalMode();
        Button Normal = new Button();
        Normal.setLayoutX(775);
        Normal.setLayoutY(470);
        Image i2 = new Image(String.valueOf(getClass().getResource("Normal.png")));
        Normal.setGraphic(new ImageView(i2));
        Button Exit = new Button();
        Exit.setLayoutX(775);
        Exit.setLayoutY(590);
        Image i1 = new Image(String.valueOf(getClass().getResource("Exit.png")));
        Exit.setGraphic(new ImageView(i1));
        root.getChildren().addAll(Arcade, Normal,Exit);
        Arcade.setOnAction(event -> {

            primaryStage.setScene(arcadeMode.getscene());
        });
        Exit.setOnAction(event -> {
            primaryStage.close();
        });
        Normal.setOnAction(event -> {
            normalMode.Difficulty();
            primaryStage.setScene(normalMode.getscene());
        });

        primaryStage.show();
    }
    public static void main (String[]args){


        launch(args);

    }

}
