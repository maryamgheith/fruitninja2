package View;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class NormalMode {
    public void setLevelofdifficulty(int levelofdifficulty) {
        this.levelofdifficulty = levelofdifficulty;
    }

    private int levelofdifficulty;
    public Scene getscene(){
        Group root =new Group();
        Scene scene =new Scene(root);
        Canvas canvas = new Canvas(1350, 735);
        root.getChildren().add(canvas);
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        Image background = new Image(getClass().getResource("BG2.jpg").toExternalForm());
        graphics.drawImage(background, 0, 0);
        System.out.println(levelofdifficulty);
        return scene;
    }

    public void Difficulty()
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Difficulty");

        //window.setMaxWidth(500);
        Label label = new Label();
        label.setText("Select Difficulty");

        Button Easy = new Button("Easy");


        Easy.setOnAction(e->{
        setLevelofdifficulty(1);

            window.close();


        });
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

        HBox layout = new HBox(10);
        label.setAlignment(Pos.CENTER);
        VBox vBox = new VBox();
        layout.getChildren().addAll(Medium,hard,Easy);
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
