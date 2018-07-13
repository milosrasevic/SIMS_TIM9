package gui;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logika.UpravljanjeFajlovima;
import model.Deonica;
import model.Deonice;
import model.NaplatnaStanica;

 

public class Main extends Application {
    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
    	// TODO : proveri gde treba da stoji ovaj poziv za ucitavanje
    	UpravljanjeFajlovima uf = new UpravljanjeFajlovima();
    	uf.ucitajKorisnike();
    	
    	uf.ucitajDeonice();
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
