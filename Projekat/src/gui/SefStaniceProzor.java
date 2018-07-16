package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Centrala;
import model.Deonica;
import model.Korisnik;
import model.NaplatnaStanica;

public class SefStaniceProzor extends Stage implements EventHandler<ActionEvent>{
	
	private Button btn = new Button("Odjavi se");
	private Button btn1 = new Button("Pregled izvestaja");
	private Button btn2 = new Button("Pregled kvarova");
	private Button btn3 = new Button("Izmena cena");
	private Button backbtn = new Button("Nazad");
	private Button backbtn1 = new Button("Nazad");
	private Button backbtn2 = new Button("Nazad");
	private Button showbtn = new Button("Prikazi");
	private Button changebtn = new Button("Izmeni");
	private Button showpricebtn = new Button("Prikazi cenu");
	
	private RadioButton rb = new RadioButton("Izvestaj za sve dane");
	private RadioButton rb1 = new RadioButton("Izvestaj za odredjen vremenski period");
	private RadioButton rb2 = new RadioButton("Ukupan naplacen iznos");
	private RadioButton rb3 = new RadioButton("Broj vozila koja su prosla kroz stanicu");
	
	final ToggleGroup group = new ToggleGroup();
	final DatePicker datepicker = new DatePicker();
	final ToggleGroup group1 = new ToggleGroup();
	
	private TextArea ts = new TextArea();
	private TextArea tskvar = new TextArea();
	private TextArea tsstaracena = new TextArea();
	private TextArea tsnovacena = new TextArea();
	
	private HBox hbox1 = new HBox();
	private HBox hbox2 = new HBox();
	private HBox hbox3 = new HBox();
	private HBox hbox4 = new HBox();
	private HBox hbox5 = new HBox();
	private HBox hbox6 = new HBox();
	private HBox hbox7 = new HBox();
	private HBox hbox8 = new HBox();
	private HBox hbox9 = new HBox();
	private HBox hbox10 = new HBox();
	private HBox hboxtoggle = new HBox();
	private HBox hboxtoggle1 = new HBox();
	private HBox hboxlabela5 = new HBox();
	private HBox hboxshow = new HBox();
	private HBox hboxta = new HBox(); 
	private HBox hboxkvar = new HBox();
	private HBox hboxdeonica = new HBox();
	private HBox hboxcena = new HBox();
	private HBox hboxprikazcene = new HBox();
	
	private ComboBox ulazneStanice = new ComboBox<>();
	private ComboBox izlazneStanice = new ComboBox<>();
	
	private ArrayList<String> listaNazivaUlaznih = new ArrayList<String>();
	private ArrayList<String> listaNazivaIzlaznih = new ArrayList<String>();
	
	
	private BorderPane root = new BorderPane();
	private BorderPane root2 = new BorderPane();
	private BorderPane root3 = new BorderPane();
	private BorderPane root4 = new BorderPane();
	
	private Scene scene1 = new Scene(root,1000,500);
	
	private Label l1 = new Label("Uspesno ste se prijavili kao sef stanice. Odaberite akciju:");
	private Label l2 = new Label("Pregled izvestaja. Odaberite vremenski period: ");
	private Label l3 = new Label("Pregled kvarova");
	private Label l4 = new Label("Izmena cena. Odaberite deonicu: ");
	private Label l5 = new Label("Odaberite tip izvestaja: ");
	private Label labelaUlazna = new Label("Ulazna stanica: ");
	private Label labelaizlazna = new Label("Izlazna stanica: ");
	private Label labelaStaraCena = new Label("Stara cena: ");
	private Label labelaNovaCena = new Label("Nova cena: ");
	
	private VBox vbox = new VBox();
	private VBox vboxtoggle = new VBox();
	private VBox vboxkvar = new VBox();
	private VBox vboxdeonica = new VBox();
	
	private String korisnicko;
	private String lozinka;
	
	Date date = new Date();
	
	Centrala centrala = Centrala.getInstance();
	
	public SefStaniceProzor(String user, String pass)
	{
		SefStaniceProzor prozor = this;
		
		this.korisnicko = user;
		this.lozinka = pass;
		
		rb.setToggleGroup(group);
		rb.setSelected(true);
		rb1.setToggleGroup(group);
		rb2.setToggleGroup(group1);
		rb2.setSelected(true);
		rb3.setToggleGroup(group1);
		
		this.setMaximized(true);
		this.setResizable(false);
		this.initStyle(StageStyle.UTILITY);
		
		l1.setStyle("-fx-text-fill: white; -fx-font: 21 arial;");
		l2.setStyle("-fx-text-fill: white; -fx-font: 21 arial;");
		l3.setStyle("-fx-text-fill: white; -fx-font: 21 arial;");
		l4.setStyle("-fx-text-fill: white; -fx-font: 21 arial;");
		l5.setStyle("-fx-text-fill: white; -fx-font: 21 arial;");
		labelaUlazna.setStyle("-fx-font: 21 arial;");
		labelaizlazna.setStyle("-fx-font: 21 arial;");
		hboxlabela5.setAlignment(Pos.CENTER);
		hboxlabela5.setStyle("-fx-background-color: #336666");
		//l5.setStyle("-fx-background-color: #336666");
		
		btn.setScaleX(1.5);
		btn.setScaleY(1.5);
		
		btn1.setScaleX(1.5);
		btn1.setScaleY(1.5);
		
		btn2.setScaleX(1.5);
		btn2.setScaleY(1.5);
		
		btn3.setScaleX(1.5);
		btn3.setScaleY(1.5);
		
		backbtn.setScaleX(1.5);
		backbtn.setScaleY(1.5);
		
		backbtn1.setScaleX(1.5);
		backbtn1.setScaleY(1.5);
		
		backbtn2.setScaleX(1.5);
		backbtn2.setScaleY(1.5);
		
		showbtn.setScaleX(1.7);
		showbtn.setScaleY(1.7);
		
		showpricebtn.setScaleX(1.6);
		showpricebtn.setScaleY(1.6);
		
		rb.setScaleX(1.5);
		rb.setScaleY(1.5);
		rb1.setScaleX(1.5);
		rb1.setScaleY(1.5);
		rb2.setScaleX(1.5);
		rb2.setScaleY(1.5);
		rb3.setScaleX(1.5);
		rb3.setScaleY(1.5);
		
		Image image = null;
		Image image1 = null;
		Image image2 = null;
		
		try {
			image = new Image(new FileInputStream("./src/slike/izvestaj.png"),140,140, false, false);
			image1 = new Image(new FileInputStream("./src/slike/kvar1.png"),140,140, false, false);
			image2 = new Image(new FileInputStream("./src/slike/cena.png"),140,140, false, false);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		ImageView iv = new ImageView();
		iv.setImage(image);
		ImageView iv1 = new ImageView();
		iv1.setImage(image1);
		ImageView iv2 = new ImageView();
		iv2.setImage(image2);
		
		this.setScene(scene1);

	
		this.setTitle("NAPLATNA STANICA");
		root.setBottom(hbox1);
		root.setTop(hbox2);
		root.setCenter(vbox);
		
		hbox6.setStyle("-fx-background-color: #336699");
		hbox6.getChildren().add(l2);
		hbox6.setAlignment(Pos.BOTTOM_CENTER);
		
		hbox7.setStyle("-fx-background-color: #336699");
		hbox7.getChildren().add(l3);
		hbox7.setAlignment(Pos.BOTTOM_CENTER);
		
		hbox8.setStyle("-fx-background-color: #336699");
		hbox8.getChildren().add(l4);
		hbox8.setAlignment(Pos.BOTTOM_CENTER);
		
		root2.setTop(hbox6);
		root2.setCenter(vboxtoggle);
		
		hboxtoggle.getChildren().add(rb);
		hboxtoggle.getChildren().add(rb1);
		
		hboxtoggle1.getChildren().add(rb2);
		hboxtoggle1.getChildren().add(rb3);
		
		hboxtoggle1.setAlignment(Pos.TOP_CENTER);
		hboxtoggle1.setSpacing(130);
		hboxtoggle1.setPadding(new Insets(20,296,20,0));
		
		
		
		datepicker.setDisable(true);
		datepicker.setScaleX(1.2);
		datepicker.setScaleY(1.2);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		datepicker.setValue(LOCAL_DATE("01-07-2018"));
		
		hboxtoggle.getChildren().add(datepicker);
		
		hboxtoggle.setAlignment(Pos.TOP_CENTER);
		hboxtoggle.setSpacing(130);
		hboxtoggle.setPadding(new Insets(20,20,20,0));
		
		hboxlabela5.getChildren().add(l5);
		hboxshow.getChildren().add(showbtn);
		hboxshow.setPadding(new Insets(30,20,20,0));
		hboxshow.setAlignment(Pos.CENTER);
		
		hboxprikazcene.getChildren().add(showpricebtn);
		hboxprikazcene.setAlignment(Pos.CENTER);
		
		vboxtoggle.getChildren().add(hboxtoggle);
		vboxtoggle.getChildren().add(hboxlabela5);
		vboxtoggle.getChildren().add(hboxtoggle1);
		vboxtoggle.getChildren().add(hboxshow);
		ts.setScaleX(2);
		ts.setScaleY(2);
		ts.setPrefHeight(300);
		ts.setPrefWidth(920);
		ts.setEditable(false);
		
		hboxta.setPadding(new Insets(200,20,20,500));
		hboxta.getChildren().add(ts);
		vboxtoggle.getChildren().add(hboxta);
		
		root3.setTop(hbox7);
		root3.setCenter(vboxkvar);
		
		vboxkvar.getChildren().add(hboxkvar);
		hboxkvar.getChildren().add(tskvar);
		tskvar.setPrefHeight(400);
		tskvar.setPrefWidth(920);
		tskvar.setScaleX(2);
		tskvar.setScaleY(2);
		tskvar.setEditable(false);
		hboxkvar.setPadding(new Insets(270,0,0,500));
		
		root4.setTop(hbox8);
		root4.setCenter(vboxdeonica);
		
		vboxdeonica.getChildren().add(hboxdeonica);
		vboxdeonica.getChildren().add(hboxprikazcene);
		vboxdeonica.getChildren().add(hboxcena);
		vboxdeonica.setSpacing(60);
		
		for(NaplatnaStanica ns : centrala.getNaplatneStanice()){
			listaNazivaUlaznih.add(ns.getNaziv());
		}
		
		ulazneStanice.getItems().addAll(listaNazivaUlaznih);
		izlazneStanice.getItems().addAll(listaNazivaUlaznih);
		
		hboxdeonica.getChildren().add(labelaUlazna);
		hboxdeonica.getChildren().add(ulazneStanice);
		hboxdeonica.getChildren().add(labelaizlazna);
		hboxdeonica.getChildren().add(izlazneStanice);
		hboxdeonica.setAlignment(Pos.CENTER);
		hboxdeonica.setSpacing(60);
		hboxdeonica.setPadding(new Insets(300,0,0,0));
		
		ulazneStanice.setPrefWidth(200);
		ulazneStanice.setPrefHeight(25);
		ulazneStanice.setStyle("-fx-font: 21 arial;");
		
		izlazneStanice.setPrefWidth(200);
		izlazneStanice.setPrefHeight(25);
		izlazneStanice.setStyle("-fx-font: 21 arial;");
		
		labelaStaraCena.setStyle("-fx-font: 21 arial;");
		labelaNovaCena.setStyle("-fx-font: 21 arial;");
		
		changebtn.setScaleX(1.5);
		changebtn.setScaleY(1.5);
		
		hboxcena.setAlignment(Pos.CENTER);
		hboxcena.setSpacing(40);
		//hboxcena.setPadding(new Insets(60,0,0,0));
		
		tsstaracena.setPrefHeight(20);
		tsstaracena.setPrefWidth(100);
		tsnovacena.setPrefHeight(20);
		tsnovacena.setPrefWidth(100);
		
		hboxcena.getChildren().add(labelaStaraCena);
		hboxcena.getChildren().add(tsstaracena);
		tsstaracena.setEditable(false);
		hboxcena.getChildren().add(labelaNovaCena);
		hboxcena.getChildren().add(tsnovacena);
		hboxcena.getChildren().add(changebtn);
		
		
		
		hbox5.setStyle("-fx-background-color: #336699;");
		hbox5.getChildren().add(backbtn);
		hbox5.setAlignment(Pos.CENTER_LEFT);
		hbox5.setPadding(new Insets(20,20,20,30));
		
		hbox9.setStyle("-fx-background-color: #336699;");
		hbox9.getChildren().add(backbtn1);
		hbox9.setAlignment(Pos.CENTER_LEFT);
		hbox9.setPadding(new Insets(20,20,20,30));
		
		hbox10.setStyle("-fx-background-color: #336699;");
		hbox10.getChildren().add(backbtn2);
		hbox10.setAlignment(Pos.CENTER_LEFT);
		hbox10.setPadding(new Insets(20,20,20,30));
		
		root2.setBottom(hbox5);
		root3.setBottom(hbox9);
		root4.setBottom(hbox10);
		
		vbox.setStyle("-fx-background-color: white");
	
		hbox1.setStyle("-fx-background-color: #336699;");
		hbox1.getChildren().add(btn);
		hbox1.setAlignment(Pos.CENTER_RIGHT);
		hbox1.setPadding(new Insets(20,40,20,0));
		
		hbox2.getChildren().add(l1);
		hbox2.setStyle("-fx-background-color: #336699");
		hbox2.setAlignment(Pos.BOTTOM_CENTER);
		
		
		hbox3.setAlignment(Pos.CENTER);
		hbox3.setPadding(new Insets(10,50,50,50));
		
		hbox3.getChildren().add(btn1);
		hbox3.getChildren().add(btn2);
		hbox3.getChildren().add(btn3);
		hbox3.setSpacing(480);
		
		hbox4.setAlignment(Pos.CENTER);
		hbox4.setPadding(new Insets(365,100,30,120));
		hbox4.getChildren().add(iv);
		hbox4.getChildren().add(iv1);
		hbox4.getChildren().add(iv2);
		hbox4.setSpacing(440);
		
		vbox.getChildren().add(hbox4);
		vbox.getChildren().add(hbox3);
		
		this.btn.setOnAction(this);
		this.btn1.setOnAction(this);
		this.btn2.setOnAction(this);
		this.btn3.setOnAction(this);
		this.backbtn.setOnAction(this);
		this.backbtn1.setOnAction(this);
		this.backbtn2.setOnAction(this);
		this.showbtn.setOnAction(this);	
		dogadjajKalendar();
		
		this.showAndWait();
	}
	
	public static final LocalDate LOCAL_DATE (String dateString){
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    LocalDate localDate = LocalDate.parse(dateString, formatter);
	    return localDate;
	}
	
	public void dogadjajKalendar(){
		rb1.pressedProperty().addListener(new ChangeListener<Boolean>(){
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(oldValue == false && newValue == true){
					datepicker.setDisable(false);
				}
			}			
		});
		
		rb.pressedProperty().addListener(new ChangeListener<Boolean>(){

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(oldValue == false && newValue == true){
					datepicker.setDisable(true);
				}
			}			
		});
	}
	
	public NaplatnaStanica dobaviNaplatnuStanicu(){
		for(NaplatnaStanica ns : centrala.getNaplatneStanice()){
			Korisnik sef = ns.dobaviSefa();
			if(sef.getKorisnickoIme().equalsIgnoreCase(this.korisnicko) && sef.getLozinka().equalsIgnoreCase(this.lozinka)){
				return ns;
			}
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == btn){
			this.close();
		}
		if(event.getSource() == btn1){
			this.scene1.setRoot(root2);
		}
		if(event.getSource() == btn2){
			this.scene1.setRoot(root3);
			pregledajKvarove(dobaviNaplatnuStanicu());
		}
		if(event.getSource() == btn3){
			this.scene1.setRoot(root4);
		}
		if(event.getSource() == backbtn || event.getSource() == backbtn1 || event.getSource() == backbtn2){
			this.scene1.setRoot(root);
		}
		if(event.getSource() == showbtn){
			if(this.group.getSelectedToggle() == this.rb){
				if(this.group1.getSelectedToggle() == this.rb2){
					double iznos = pozivIzvestaja(dobaviNaplatnuStanicu(),true,true,this.date);
					this.ts.appendText("Ukupan naplacen iznos je: " + iznos + "\n");
				}
				else{
					double iznos = pozivIzvestaja(dobaviNaplatnuStanicu(),true,false,this.date);
					this.ts.appendText("Broj vozila koja su prosla je: " + iznos + "\n");
				}	
			}
			else{
				
				LocalDate localDate = this.datepicker.getValue();
				Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
				this.date = Date.from(instant);
				
				if(this.group1.getSelectedToggle() == this.rb2){
					double iznos = pozivIzvestaja(dobaviNaplatnuStanicu(),false,true,this.date);
					this.ts.appendText("Ukupan naplacen iznos od datuma: " + this.date.getDate() + '/'+ (this.date.getMonth() + 1) + '/'+ (this.date.getYear() + 1900) + " je " + iznos + "\n");
				}
				else{
					double iznos = pozivIzvestaja(dobaviNaplatnuStanicu(),false,false,this.date);
					this.ts.appendText("Ukupan broj vozila koja su prosla od datuma: " + this.date.getDate() + '/'+ (this.date.getMonth() + 1) + '/'+ (this.date.getYear() + 1900) + " je " + iznos + "\n");
				}
			}
		}
		
	}
	
	private void pregledajKvarove(NaplatnaStanica ns) {
		ArrayList<String> kvarovi = ns.pregledajKvarove();
		for(String s : kvarovi){
			this.tskvar.appendText(s + '\n');
		}
		
	}

	public double pozivIzvestaja(NaplatnaStanica ns, Boolean arg1, Boolean arg2,Date datum){
		double suma = 0;
		if(arg1){
			if(arg2){
				suma = ns.pregledajIzvestaje(1,datum);
			}
			else{
				suma = ns.pregledajIzvestaje(2,datum);
			}
		}
		else{
			if(arg2){
				suma = ns.pregledajIzvestaje(3,datum);
			}
			else{
				suma = ns.pregledajIzvestaje(4,datum);
			}
		}
		return suma;
	}
}
