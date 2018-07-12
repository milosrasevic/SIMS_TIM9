package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SefStaniceProzor extends Stage implements EventHandler<ActionEvent>{
	
	private Button btn = new Button("Odjavi se");
	private Button btn1 = new Button("Pregled izvestaja");
	private Button btn2 = new Button("Pregled kvarova");
	private Button btn3 = new Button("Izmena cena");
	private Button backbtn = new Button("Nazad");
	private Button backbtn1 = new Button("Nazad");
	private Button backbtn2 = new Button("Nazad");
	
	private RadioButton rb = new RadioButton("Izvestaj za sve dane");
	private RadioButton rb1 = new RadioButton("Izvestaj za odredjen vremenski period");
	final ToggleGroup group = new ToggleGroup();
	final DatePicker datepicker = new DatePicker();
	
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
	
	private BorderPane root = new BorderPane();
	private BorderPane root2 = new BorderPane();
	private BorderPane root3 = new BorderPane();
	private BorderPane root4 = new BorderPane();
	
	private Scene scene1 = new Scene(root,1000,500);
	private Scene scene2 = new Scene(root2,1000,500);
	private Scene scene3 = new Scene(root3,1000,500);
	private Scene scene4 = new Scene(root4,1000,500);
	
	private Label l1 = new Label("Uspesno ste se prijavili kao sef stanice. Odaberite akciju:");
	private Label l2 = new Label("Pregled izvestaja");
	private Label l3 = new Label("Pregled kvarova");
	private Label l4 = new Label("Izmena cena");
	
	private VBox vbox = new VBox();
	
	public SefStaniceProzor()
	{
		SefStaniceProzor prozor = this;
		
		rb.setToggleGroup(group);
		rb.setSelected(true);
		rb1.setToggleGroup(group);
		
		this.setMaximized(true);
		this.setResizable(false);
		this.initStyle(StageStyle.UTILITY);
		
		l1.setStyle("-fx-text-fill: white; -fx-font: 21 arial;");
		l2.setStyle("-fx-text-fill: white; -fx-font: 21 arial;");
		l3.setStyle("-fx-text-fill: white; -fx-font: 21 arial;");
		l4.setStyle("-fx-text-fill: white; -fx-font: 21 arial;");
		
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
		
		rb.setScaleX(1.5);
		rb.setScaleY(1.5);
		rb1.setScaleX(1.5);
		rb1.setScaleY(1.5);
		
		Image image = null;
		Image image1 = null;
		Image image2 = null;
		
		try {
			image = new Image(new FileInputStream("./izvestaj.png"),140,140, false, false);
			image1 = new Image(new FileInputStream("./kvar.png"),140,140, false, false);
			image2 = new Image(new FileInputStream("./cena.png"),140,140, false, false);
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
		root2.setCenter(hboxtoggle);
		hboxtoggle.getChildren().add(rb);
		hboxtoggle.getChildren().add(rb1);
		datepicker.setDisable(true);
		hboxtoggle.getChildren().add(datepicker);
		hboxtoggle.setAlignment(Pos.TOP_CENTER);
		hboxtoggle.setSpacing(130);
		hboxtoggle.setPadding(new Insets(20,20,20,0));
		
		root3.setTop(hbox7);
		root4.setTop(hbox8);
		
		
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
			
		dogadjajKalendar();
		
		this.showAndWait();
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

	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == btn){
			this.close();
		}
		if(event.getSource() == btn1){
			this.setScene(scene2);
			this.sizeToScene();
            this.setMaximized(false);
            this.setMaximized(true);
		}
		if(event.getSource() == btn2){
			this.setScene(scene3);
			this.sizeToScene();
            this.setMaximized(false);
            this.setMaximized(true);
		}
		if(event.getSource() == btn3){
			this.setScene(scene4);
			this.sizeToScene();
            this.setMaximized(false);
            this.setMaximized(true);
		}
		if(event.getSource() == backbtn || event.getSource() == backbtn1 || event.getSource() == backbtn2){
			this.setScene(scene1);
			this.sizeToScene();
	        this.setMaximized(false);
	        this.setMaximized(true);
		}
		
	}
}
