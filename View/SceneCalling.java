package View;

import javafx.application.Application;
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
        primaryStage.setTitle("Fruit Ninja");
        setStage(primaryStage);
        openingScene.getscene();
    }


    public static void main (String[]args){
        launch(args);
    }

}