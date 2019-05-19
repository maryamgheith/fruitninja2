package View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameOver
{
    public GameOver(String str) {

        ArcadeMode arcadeMode=new ArcadeMode();
        NormalMode normalMode = new NormalMode();
        OpeningScene openingScene = new OpeningScene();
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);


        //window.setMaxWidth(500);
        Label label = new Label();
        label.setText("GAME OVER!!");
        label.setFont(Font.font(48));
        Button btnMainMenu = new Button("MainMenu");
        btnMainMenu.setOnAction(e->{

            openingScene.getscene();
            window.close();
        });
        Button btnRetry = new Button("Retry");
        btnRetry.setOnAction(e->{
            if(str.equalsIgnoreCase("normal"))
                normalMode.getscene();
            if (str.equalsIgnoreCase("arcade"))
                arcadeMode.getscene();
            // sceneCalling.Arcade(stage);
            window.close();
        });

        HBox layout = new HBox(10);
        label.setAlignment(Pos.CENTER);

        {layout.getChildren().addAll(btnMainMenu,btnRetry,label);

            btnMainMenu.setLayoutX(250);
            btnMainMenu.setLayoutY(250);
            btnRetry .setLayoutX(500);
            btnRetry .setLayoutY(250);
        }

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();



    }
}
