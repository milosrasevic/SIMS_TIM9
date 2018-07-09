package gui;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
       
        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.setTitle("");
        primaryStage.setResizable(false);
        primaryStage.show();
        PrijavljivanjeProzor pr = new PrijavljivanjeProzor(primaryStage);
        root.getChildren().add(pr);
        
        
        
    }
    
    
}
