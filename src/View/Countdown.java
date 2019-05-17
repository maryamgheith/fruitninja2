package View;

import com.sun.java.swing.plaf.windows.resources.windows;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Countdown {
    Scene scene;
    private final Integer starttime=7;
    private Integer seconds= starttime;
    public void countdowntimer(){
        OpeningScene openingScene=new OpeningScene();
        Label lb = new Label();
        Stage window = new Stage();
        window.setWidth(1350);
        window.setHeight(735);
        window.initModality(Modality.APPLICATION_MODAL);
        Group root = new Group();
        Canvas canvas = new Canvas(1350, 735);
        root.getChildren().add(canvas);
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        Image background = new Image(getClass().getResource("BG2.jpg").toExternalForm());
        graphics.drawImage(background, 0, 0);

        Button cancel = new Button("Cancel");
        cancel.setFont(Font.font(72));
        cancel.setAlignment(Pos.BOTTOM_CENTER);
        lb.setAlignment(Pos.CENTER);
        lb.setText("7");
        lb.setFont(Font.font(72));
        lb.setTextFill(Color.RED);
        VBox layout= new VBox(lb,cancel);
        root.getChildren().addAll(layout);
        Scene scene= new Scene(root, 300,300, Color.BLACK);
        doTime(lb,window);
        cancel.setOnAction(event -> {
          openingScene.getscene();
          window.close();

        });
        window.setScene(scene);
window.show();
    }

    private void doTime(Label lb,Stage window) {
        Timeline time= new Timeline();
        KeyFrame frame= new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                seconds--;
                lb.setText(seconds.toString());
                if(seconds<=0){
                    time.stop();
                    window.close();



                }


            }


        });

        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(frame);
        if(time!=null){
            time.stop();
        }
        time.play();


    }
}
