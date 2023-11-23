package FXproject;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jxl.read.biff.BiffException;

public class GUIshow extends Application {
    @Override
    public void start(Stage primaryStage) {
        Text operation1 = new Text(TestingBeforeGUI.getGuiOperations().get(0));
        Text object1 = new Text(TestingBeforeGUI.getGuiObjects().get(0));
        Text object2 = new Text(TestingBeforeGUI.getGuiObjects().get(1));
        Text object3 = new Text(TestingBeforeGUI.getGuiObjects().get(2));
        Text object4 = new Text(TestingBeforeGUI.getGuiObjects().get(3));
        Text object5 = new Text(TestingBeforeGUI.getGuiObjects().get(4));
        HBox objects = new HBox();
        objects.getChildren().addAll(object1 , object2 , object3 , object4 , object5 );
        objects.setAlignment(Pos.CENTER);
        objects.setSpacing(70);
        VBox root =  new VBox();
        root.getChildren().add(operation1);
        root.getChildren().add(objects);
        root.setSpacing(150);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 1260, 940);
        primaryStage.setTitle("showing excel file data");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) throws IOException, BiffException {
        TestingBeforeGUI.main(null);
        launch(args);
    } 
}
