package gui;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Korisnik;

public class OperaterProzor extends Stage{
	
	private Korisnik korisnik;
	
	private OperaterProzor prozor;
	private BorderPane root;
	private NaplataProzor naplataRoot;
	private IzvestajiProzor izvestajiRoot;

	private Label labelaNaziv = new Label("Naziv Stanice i Naziv Naplatnog mesta");
	private Label labelaStanje = new Label("Stanje rampe");
	private Button btnOdjava = new Button("Odjavi se");
	private HBox hboxTop = new HBox();
	private VBox vboxTop = new VBox();
	private BorderPane bpTop = new BorderPane();
	private Button btnNaplata = new Button("Naplata");
	private Button btnIzvestaji = new Button("Izvestaji");
	private Button btnRampa = new Button("Prinudno podizanje rampe");
	private VBox vboxLeft = new VBox();
	private BorderPane bpLeft = new BorderPane();
	
	public OperaterProzor(Korisnik korisnik)
	{
		this.korisnik = korisnik;
		podesiInterfejs();
		podesiAkcije();
		this.showAndWait();
	}
	
	private  void podesiInterfejs()
	{
		prozor = this;
		
		BorderPane bproot = new BorderPane();
		root = bproot;
		
		this.setScene(new Scene(root,1000,500));
		this.setMaximized(true);
		this.initStyle(StageStyle.UNDECORATED);
		this.setTitle("NAPLATNO MESTO");

		podesiTop();
		podesiLeft();
		
		root.setTop(bpTop);
		root.setLeft(bpLeft);
	}
	
	private void podesiTop()
	{
		bpTop.setRight(hboxTop);
		bpTop.setLeft(vboxTop);
		
		vboxTop.getChildren().add(labelaNaziv);
		vboxTop.getChildren().add(labelaStanje);
		
		bpTop.setStyle("-fx-background-color: #336699;");
		hboxTop.getChildren().add(btnOdjava);
		hboxTop.setAlignment(Pos.CENTER_RIGHT);
		hboxTop.setPadding(new Insets(10,10,10,0));
	}
	private void podesiLeft()
	{
		vboxLeft.setStyle("-fx-background-color: #336000;");
		vboxLeft.getChildren().addAll(btnNaplata, btnIzvestaji);
		btnNaplata.setMaxWidth(Double.MAX_VALUE);
		btnIzvestaji.setMaxWidth(Double.MAX_VALUE);
		btnRampa.setMaxWidth(Double.MAX_VALUE);
		
		bpLeft.setTop(vboxLeft);
		bpLeft.setBottom(btnRampa);
	}
	
	private void podesiAkcije() {
		this.btnOdjava.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		    	prozor.close();
		    }
		});
		
		this.btnNaplata.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		    	NaplataProzor naplataProzor = new NaplataProzor(korisnik.getNaplatnoMesto());
		    	naplataRoot = naplataProzor;
		    	root.setCenter(naplataProzor);
		    }
		});
		
		this.btnIzvestaji.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		    	IzvestajiProzor izvestajiProzor = new IzvestajiProzor();
		    	izvestajiRoot = izvestajiProzor;
		    	root.setCenter(izvestajiProzor);
		    }
		});
	}
}
