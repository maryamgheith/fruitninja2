package View;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
public class Time{
    private final int starttime=60;
    private Integer seconds = starttime;
    Time(Label timeLabel) {
        Timeline time= new Timeline();
        KeyFrame frame= new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                seconds--;
                timeLabel.setText("Timer: "+seconds.toString());
                if(seconds<=0){
                    time.stop();
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