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

public class SceneCalling extends Application {
    ArcadeMode arcadeMode=new ArcadeMode();
    NormalMode normalMode=new NormalMode();
    OpeningScene openingScene = new OpeningScene();
    private static Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public  Stage getStage() {
        return stage;
    }



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FruitNinja");
       setStage(primaryStage);
       openingScene.getscene();

    }


    public static void main (String[]args){


        launch(args);

    }

}
