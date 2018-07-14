package gui;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.CenovnikVozilo;
import model.Centrala;
import model.NaplatnaStanica;
import model.ObicnoNapMesto;
import model.TipVozila;
import model.Valuta;

public class NaplataProzor  extends BorderPane{
	private ObicnoNapMesto naplatnoMesto;
	
	// TOP
	StackPane sp = new StackPane();
	Label l = new Label("NAPLATA");
	
	// BOTTOM
	BorderPane bpBottom = new BorderPane();
	Button btnNaplati = new Button("NAPLATI");
	Label labelStatus = new Label("Status: ");
	
	// CENTER
	HBox hboxCenter = new HBox();
	VBox vboxStanice = new VBox();
	VBox vboxKategorije = new VBox();
	
	// Stanice, Tip, Valuta
	Label labelUlaz = new Label("Ulazna naplatna stanica:");
	Label labelIzlaz = new Label("Izlazna naplatna stanica:");
	Label labelTip = new Label("Kategorija vozila:");
	Label labelValuta = new Label("Valuta:");
	ComboBox<String> comboUlaz = new ComboBox<String>();
	ComboBox<String> comboIzlaz = new ComboBox<String>();
	ComboBox<String> comboTip = new ComboBox<String>();
	ComboBox<String> comboValuta = new ComboBox<String>();

	// Kategorije
	
	Label labelKategorije = new Label("KATEGORIJE VOZILA: ");
	HBox hboxKat = new HBox();
	
	// Cene
	ArrayList<CenovnikVozilo> cene = new ArrayList<CenovnikVozilo>();
	ArrayList<CenaPolje> cenePolja = new ArrayList<CenaPolje>();
	
	
	public NaplataProzor(ObicnoNapMesto naplatnoMesto)
	{
		this.naplatnoMesto = naplatnoMesto;
		podesiTop();
		podesiBottom();
		podesiCenter();
		this.setPadding(new Insets(0,10,10,10));
	}
	
	private void podesiTop()
	{
		sp.getChildren().add(l);
		sp.setAlignment(Pos.CENTER);
		this.setTop(sp);
	}
	
	private void podesiBottom()
	{
		btnNaplati.setPrefSize(200, 100);
		bpBottom.setRight(btnNaplati);
		bpBottom.setLeft(labelStatus);
		this.setBottom(bpBottom);
		podesiBtnNaplati();
	}
	
	private void podesiCenter()
	{
		hboxCenter.getChildren().addAll(vboxStanice, vboxKategorije);
		hboxCenter.setSpacing(100);
		
		podesiPrikazOdabira();
		podesiPrikazKategorija();
		try {
			podesiCene();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		hboxCenter.setPadding(new Insets(100,0,0,0));
		hboxCenter.setAlignment(Pos.CENTER);
		this.setCenter(hboxCenter);
	}
	
	private void podesiPrikazOdabira()
	{
		vboxStanice.setSpacing(20);
		comboUlaz.setMaxWidth(Double.MAX_VALUE);
		comboIzlaz.setMaxWidth(Double.MAX_VALUE);
		
		comboValuta.setMaxWidth(Double.MAX_VALUE);
		vboxStanice.getChildren().addAll(labelUlaz, comboUlaz, labelIzlaz, comboIzlaz);
		vboxStanice.getChildren().addAll(labelTip, comboTip, labelValuta, comboValuta);
		
		podesiKategorije();
		podesiValute();
		
	}
	private void podesiPrikazKategorija()
	{
		vboxKategorije.setSpacing(20);
		vboxKategorije.getChildren().addAll(labelKategorije,hboxKat);
		
		ArrayList<TipVozila> tipovi = TipVozila.getTipovi();
		
		VBox vb1 = new VBox();
		hboxKat.getChildren().add(vb1);
		hboxKat.setSpacing(50);
		
		vb1.getChildren().addAll(new Label(" "), new Label(" "));
		vb1.setSpacing(20);
		vb1.setMaxWidth(Double.MAX_VALUE);
		
		for (Valuta valuta : Valuta.values()) {
			vb1.getChildren().add(new Label(valuta.name()));
		}
		
		for (TipVozila tip : tipovi) {
			VBox vb = new VBox();
			Label l = new Label(tip.name());
			vb.getChildren().add(l);
			
			ImageView view = new ImageView();
			Image slika = new Image(TipVozila.getSliku(tip));
			view.setImage(slika);
			
			vb.getChildren().add(view);
			
			vb.setSpacing(20);
			
			hboxKat.getChildren().add(vb);
			
			for (Valuta valuta : Valuta.values()) {
				CenaPolje cena = new CenaPolje(tip, valuta);
				cenePolja.add(cena);
				vb.getChildren().add(cena);
			}
		}
	}
	
	private void podesiKategorije()
	{
		comboTip.setMaxWidth(Double.MAX_VALUE);
			
		for (TipVozila tip : TipVozila.values()) {
			comboTip.getItems().add(tip.name());
		}
	}
	
	private void podesiValute()
	{
		
		comboValuta.setMaxWidth(Double.MAX_VALUE);
		
		for (Valuta val : Valuta.values())
		{
			comboValuta.getItems().add(val.name());
		}
	}
	
	private void podesiCene()
	{
		for (CenaPolje cenaPolje : cenePolja) {
			NaplatnaStanica ulaz = getNaplatnaStanicaUlaz();
			double iznos = this.naplatnoMesto.getCenaVozila(cenaPolje.getTipVozila(), cenaPolje.getValuta(), ulaz);
			cenaPolje.setText(String.valueOf(iznos));
		}
	}
	private void podesiBtnNaplati()
	{
		this.btnNaplati.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		    	
		    	TipVozila tipVozila = TipVozila.strToTip(comboTip.getPromptText());
		    	Valuta valuta = Valuta.strToValuta(comboValuta.getPromptText());
		    	NaplatnaStanica ulaz = getNaplatnaStanicaUlaz();
		    	
		    	boolean ok = naplatnoMesto.naplati(tipVozila, valuta, ulaz);
		    	
		    	if (ok)
		    	{
		    		Alert alert = new Alert(AlertType.INFORMATION);
			    	alert.setHeaderText(null);
			    	alert.setContentText("Naplata uspesno izvrsena!");

			    	alert.showAndWait();
		    	} else 
		    	{
		    		Alert alert = new Alert(AlertType.ERROR);
			    	alert.setHeaderText(null);
			    	alert.setContentText("Naplata neuspesno izvrsena!");

			    	alert.showAndWait();
		    	}
		    	
		    }
		});
	}
	
	private NaplatnaStanica getNaplatnaStanicaUlaz()
	{
		NaplatnaStanica np = null;
		for (NaplatnaStanica naplatnaStanica : Centrala.getInstance().getNaplatneStanice()) {
			if (naplatnaStanica.equals(comboUlaz.getPromptText()))
				{
					np = naplatnaStanica;
				}
		}
		
		return np;
	}
	
}
