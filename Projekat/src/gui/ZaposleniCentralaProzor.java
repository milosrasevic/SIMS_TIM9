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

public class ZaposleniCentralaProzor extends Stage implements EventHandler<ActionEvent>{
	
	private Centrala centrala = Centrala.getInstance();
	
	// DUGMAD OSNOVNOG PROZORA
	private Button btn_odjava = new Button("Odjavi se");
	private Button btn_IzvestajiStanice = new Button("IZVESTAJI NAPLATNIH STANICA");
	private Button btn_IzvestajiMesta = new Button("IZVESTAJI NAPLATNIH MESTA");
	
	
	private HBox zaglavlje = new HBox();
	private HBox ikonice = new HBox(50);
	private HBox dugmad = new HBox(50);
	private VBox vbox1 = new VBox(100);
	
	
	// DUGMAD PROZORA ZA IZVESTAJE STANICA
	private Button btn_broj_vozila = new Button("Broj vozila");
	private Button btn_naplaceni_iznos = new Button("Naplaceni iznos");
	private Button btn_kvarovi = new Button("Kvarovi");
	private Button btn_broj_vozila_period = new Button("Broj vozila period");
	private Button btn_nazad = new Button("Nazad");
	private ComboBox lista_stanica = new ComboBox<>();
	private Label tekst_zaglavlja_stanice = new Label("  STANICA");
	private HBox zaglavlje_stanica = new HBox(150);
	private HBox ikonice_stanice = new HBox(120);
	private HBox dugmad_stanice = new HBox(120);
	private HBox podglavlje_stanica = new HBox();
	private VBox vbox_stanice = new VBox();
	
	private BorderPane osnovni_layout = new BorderPane();
	private BorderPane stanice_layout = new BorderPane();
	private BorderPane mesta_layout = new BorderPane();
	
	private Scene osnovnaScena = new Scene(osnovni_layout,1000,500);
	private Scene izvestajiStanicaScena = new Scene(stanice_layout,1000,500);
	private Scene izvestajiMestaScena = new Scene(mesta_layout,1000,500);
	
	public ZaposleniCentralaProzor()
	{
		ZaposleniCentralaProzor prozor = this;
		
		this.setScene(osnovnaScena);
		this.setMaximized(true);
		this.initStyle(StageStyle.UTILITY);
		this.setTitle("ZAPOSLENI U CENTRALI");
		this.setResizable(false);
		
		osnovni_layout.setTop(zaglavlje);
		zaglavlje.setStyle("-fx-background-color: #336699;");
		zaglavlje.getChildren().add(btn_odjava);
		zaglavlje.setAlignment(Pos.CENTER_RIGHT);
		zaglavlje.setPadding(new Insets(10,10,10,0));

		
//		Image image = new Image(new File("src/slike/izvestaji.png").toURI().toString());
//		ImageView iv = new ImageView();
//		iv.setImage(image);
//		ikonice.getChildren().add(iv);
//		ikonice.setAlignment(Pos.CENTER);
//		vbox1.getChildren().add(ikonice);
//		
		
		btn_IzvestajiStanice.setStyle("-fx-font: 18 arial; -fx-base: #b6e7c9;");
		btn_IzvestajiStanice.setPrefSize(400, 500);
		btn_IzvestajiMesta.setStyle("-fx-font: 18 arial; -fx-base: #b6e7c9;");
		btn_IzvestajiMesta.setPrefSize(400, 500);

		dugmad.getChildren().add(btn_IzvestajiMesta);
		dugmad.getChildren().add(btn_IzvestajiStanice);
		dugmad.setAlignment(Pos.CENTER);
		vbox1.getChildren().add(dugmad);
		
		osnovni_layout.setCenter(vbox1);
		vbox1.setAlignment(Pos.CENTER_RIGHT);
		
		
		// SCENA ZA IZVESTAJE STANICA
		//****************************************************************************
		tekst_zaglavlja_stanice.setStyle("-fx-font: 50 arial; -fx-base: #b6e7c9;");
		lista_stanica.setStyle("-fx-font: 30 arial; -fx-base: #b6e7c9;");
		ArrayList<String> listaNazivaDeonica = new ArrayList<String>();
		for (Deonica deonica : centrala.getDeonice()) {
			if(!listaNazivaDeonica.contains(deonica.getUlaznaStanica().getNaziv())) {
				listaNazivaDeonica.add(deonica.getUlaznaStanica().getNaziv());
			}
		}
		lista_stanica.getItems().addAll( listaNazivaDeonica);
		zaglavlje_stanica.setAlignment(Pos.CENTER);
		zaglavlje_stanica.setStyle("-fx-background-color: #336699;");
		zaglavlje_stanica.getChildren().addAll(tekst_zaglavlja_stanice, lista_stanica);
		
		ImageView[] imageView = new ImageView[3];
		
		imageView[0] = new ImageView(); imageView[0].setImage(new Image(new File("src/slike/automobil.jpg").toURI().toString()));
		imageView[1] = new ImageView(); imageView[1].setImage(new Image(new File("src/slike/kes.png").toURI().toString()));
		imageView[2] = new ImageView(); imageView[2].setImage(new Image(new File("src/slike/kvar.png").toURI().toString()));
		for(int i = 0; i < 3; i++) {
			imageView[i].setFitHeight(100);
			imageView[i].setFitWidth(100);
		}
//		ikonice_stanice.getChildren().addAll(imageView[0], imageView[1], imageView[2]);
//		ikonice_stanice.setAlignment(Pos.CENTER);
//		vbox_stanice.getChildren().add(ikonice_stanice);
		
		btn_broj_vozila.setPrefSize(400, 500);
		btn_naplaceni_iznos.setPrefSize(400, 500);
		btn_broj_vozila_period.setPrefSize(400, 500);
		btn_kvarovi.setPrefSize(400, 500);
		btn_broj_vozila.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");	btn_naplaceni_iznos.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");
		btn_kvarovi.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");	btn_broj_vozila_period.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");
		dugmad_stanice.getChildren().addAll(btn_broj_vozila, btn_naplaceni_iznos, btn_kvarovi, btn_broj_vozila_period);
		dugmad_stanice.setAlignment(Pos.CENTER);
		vbox_stanice.getChildren().add(dugmad_stanice);
		
		podglavlje_stanica.setAlignment(Pos.BOTTOM_CENTER);
		btn_nazad.setStyle("-fx-font: 100 arial; -fx-base: #b6e7c9;");
		podglavlje_stanica.getChildren().add(btn_nazad);
		
		
		stanice_layout.setCenter(vbox_stanice);
		stanice_layout.setTop(zaglavlje_stanica);
		stanice_layout.setBottom(podglavlje_stanica);
		
		
		
		
		btn_IzvestajiStanice.setOnAction(this);
		btn_IzvestajiMesta.setOnAction(this);
		btn_odjava.setOnAction(this);
		btn_broj_vozila.setOnAction(this);
		btn_naplaceni_iznos.setOnAction(this);
		btn_kvarovi.setOnAction(this);
		btn_broj_vozila_period.setOnAction(this);
		btn_nazad.setOnAction(this);
		this.showAndWait();
		
	}
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == btn_odjava) {
			this.close();
		}else if(event.getSource() == btn_IzvestajiStanice) {
			this.setScene(izvestajiStanicaScena);
			obradiVelicinu();
		}else if(event.getSource() == btn_IzvestajiMesta) {
			this.setScene(izvestajiMestaScena);
			obradiVelicinu();
		}else if(event.getSource() == btn_broj_vozila) {
			
		}else if(event.getSource() == btn_naplaceni_iznos) {
			
		}else if(event.getSource() == btn_kvarovi) {
			
		}else if(event.getSource() == btn_broj_vozila_period) {
			
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
