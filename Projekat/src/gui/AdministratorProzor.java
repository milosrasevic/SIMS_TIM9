package gui;



import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Centrala;
import model.Deonica;

public class AdministratorProzor extends Stage implements EventHandler<ActionEvent>{

	private Centrala centrala = Centrala.getInstance();
	
	// DUGMAD OSNOVNOG PROZORA
	private Button btn_odjava = new Button("Odjavi se");
	private Button btn_rad_sa_korisnicima = new Button("IZMENA NA KORSINICIMA");
	private Button btn_rad_sa_deonicama = new Button("IZMENA NA DEONICAMA");
	private Button btn_rad_sa_stanicama = new Button("IZMENA NA STANICAMA");
	private Button btn_rad_sa_cenovnicina = new Button("UNOS CENOVNIKA");
	
	private HBox zaglavlje = new HBox();
	private HBox ikonice = new HBox(50);
	private HBox dugmad = new HBox(50);
	private VBox vbox1 = new VBox(100);
	
	// RAD SA KORISNICIMA
	private Button btn_dodaj_korisnika = new Button("DODAJ KORISNIKA");
	private Button btn_izmeni_korisnika = new Button("IZMENI KORISNIKA");
	private Button btn_obrisi_korisnika = new Button("OBRISI KORISNIKA");
	private Button btn_nazad = new Button("Nazad");
	
	private HBox centar_korisnici = new HBox(100);
	private VBox centar_dugmad_korisnici = new VBox();
	private HBox podglavlje_korisnici = new HBox();

	private BorderPane osnovni_layout = new BorderPane();
	private BorderPane korisnici_layout = new BorderPane();
	
	private Scene osnovnaScena = new Scene(osnovni_layout,1000,500);
	private Scene scena_rad_sa_korisnicima = new Scene(korisnici_layout, 1000,500);
	
	public AdministratorProzor()
	{
		AdministratorProzor prozor = this;
		
		this.setScene(osnovnaScena);
		this.setMaximized(true);
		this.initStyle(StageStyle.UTILITY);
		this.setTitle("ADMINISTRATOR");
		this.setResizable(false);
		
		osnovni_layout.setTop(zaglavlje);
		zaglavlje.setStyle("-fx-background-color: #336699;");
		zaglavlje.getChildren().add(btn_odjava);
		zaglavlje.setAlignment(Pos.CENTER_RIGHT);
		zaglavlje.setPadding(new Insets(10,10,10,0));

		
		
		
		btn_rad_sa_deonicama.setStyle("-fx-font: 18 arial; -fx-base: #b6e7c9;");
		btn_rad_sa_cenovnicina.setStyle("-fx-font: 18 arial; -fx-base: #b6e7c9;");
		btn_rad_sa_stanicama.setStyle("-fx-font: 18 arial; -fx-base: #b6e7c9;");
		btn_rad_sa_korisnicima.setStyle("-fx-font: 18 arial; -fx-base: #b6e7c9;");
		
		btn_rad_sa_deonicama.setPrefSize(400, 500);
		btn_rad_sa_cenovnicina.setPrefSize(400, 500);
		btn_rad_sa_korisnicima.setPrefSize(400, 500);
		btn_rad_sa_stanicama.setPrefSize(400, 500);

		dugmad.getChildren().addAll(btn_rad_sa_korisnicima, btn_rad_sa_deonicama, btn_rad_sa_stanicama, btn_rad_sa_cenovnicina);
		dugmad.setAlignment(Pos.CENTER);
		vbox1.getChildren().add(dugmad);
		
		osnovni_layout.setCenter(vbox1);
		vbox1.setAlignment(Pos.CENTER_RIGHT);

		
		btn_rad_sa_korisnicima.setOnAction(this);
		btn_rad_sa_deonicama.setOnAction(this);
		btn_odjava.setOnAction(this);
		btn_rad_sa_stanicama.setOnAction(this);
		btn_rad_sa_cenovnicina.setOnAction(this);
		// RAD SA KORISNICIMA
		
		btn_dodaj_korisnika.setStyle("-fx-font: 18 arial; -fx-base: #b6e7c9;");
		btn_izmeni_korisnika.setStyle("-fx-font: 18 arial; -fx-base: #b6e7c9;");
		btn_obrisi_korisnika.setStyle("-fx-font: 18 arial; -fx-base: #b6e7c9;");
		btn_nazad.setStyle("-fx-font: 18 arial; -fx-base: #b6e7c9;");
		
		
		btn_dodaj_korisnika.setPrefSize(400, 500);
		btn_izmeni_korisnika.setPrefSize(400, 500);
		btn_obrisi_korisnika.setPrefSize(400, 500);
		btn_nazad.setPrefSize(1800, 300);
		
		centar_korisnici.getChildren().addAll(btn_dodaj_korisnika, btn_izmeni_korisnika, btn_obrisi_korisnika);
		centar_korisnici.setAlignment(Pos.CENTER);
		centar_dugmad_korisnici.getChildren().add(centar_korisnici);
		centar_dugmad_korisnici.setAlignment(Pos.CENTER_RIGHT);
		
		podglavlje_korisnici.getChildren().add(btn_nazad);
		korisnici_layout.setBottom(podglavlje_korisnici);
		korisnici_layout.setCenter(centar_dugmad_korisnici);
		
		
		btn_dodaj_korisnika.setOnAction(this);
		btn_izmeni_korisnika.setOnAction(this);
		btn_obrisi_korisnika.setOnAction(this);
		btn_nazad.setOnAction(this);
		

		this.showAndWait();
		
	}
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == btn_odjava) {
			this.close();
		}else if(event.getSource() == btn_rad_sa_korisnicima) {
			this.setScene(scena_rad_sa_korisnicima);
			obradiVelicinu();
		}else if(event.getSource() == btn_rad_sa_deonicama) {
			
			obradiVelicinu();
		}else if(event.getSource() == btn_rad_sa_stanicama) {
			
		}else if(event.getSource() == btn_rad_sa_cenovnicina) {
			
		}else if(event.getSource() == btn_dodaj_korisnika) {
			
		}else if(event.getSource() == btn_izmeni_korisnika) {
			
		}else if(event.getSource() == btn_obrisi_korisnika) {
			
		}else if(event.getSource() == btn_nazad) {
			this.setScene(osnovnaScena);
			obradiVelicinu();
		}
	}
	public void obradiVelicinu() {
		this.sizeToScene();
		this.setMaximized(false);
		this.setMaximized(true);
	}
}
