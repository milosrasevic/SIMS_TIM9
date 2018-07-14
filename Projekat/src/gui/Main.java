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
import model.Centrala;
import model.Deonica;
import model.ElektronskoNapMesto;
import model.Korisnici;
import model.Korisnik;
import model.Kvar;
import model.Kvarovi;
import model.NaplatnaStanica;
import model.NaplatneStanice;
import model.NaplatnoMesto;
import model.ObicnoNapMesto;
import model.Prolasci;
import model.Prolazak;
import model.Rampa;

 

public class Main extends Application {
    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
    	// TODO : proveri gde treba da stoji ovaj poziv za ucitavanje
    	UpravljanjeFajlovima uf = new UpravljanjeFajlovima();
    	uf.ucitajKorisnike();
    	uf.ucitajDeonice();
    	uf.ucitajStanice();
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
