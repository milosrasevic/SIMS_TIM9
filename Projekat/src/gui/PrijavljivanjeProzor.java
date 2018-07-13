package gui;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logika.Prijavljivanje;
import model.TipKorisnika;

public class PrijavljivanjeProzor extends VBox {
	 private TextField tf1 = new TextField();
	 private PasswordField tf2 = new PasswordField();
	 private Label l1 = new Label("Korisnicko ime: ");
	 private Label l2 = new Label("Lozinka: ");
	 private HBox hbox1 = new HBox();
	 private HBox hbox2 = new HBox();
	 private HBox hbox3 = new HBox();
	 private HBox hbox4 = new HBox();
	 private Button btn = new Button("Prijavi se");
	 private Label greska = new Label("");
	 
	 private Stage stage;
	
	public PrijavljivanjeProzor(Stage primaryStage)
	{
		stage = primaryStage;
		this.setPadding(new Insets(80,30,30,30));
		this.setSpacing(10);
		hbox1.getChildren().addAll(l1,tf1);
		hbox2.getChildren().addAll(l2,tf2);
		hbox1.setSpacing(50);
		hbox2.setSpacing(95);
		hbox3.setPadding(new Insets(10,10,10,10));
		hbox3.getChildren().add(greska);
		
		hbox4.getChildren().addAll(new VBox(), btn);
		hbox4.setSpacing(200);
		
		this.getChildren().addAll(hbox1,hbox2, hbox3,hbox4);
		
		greska.setTextFill(Color.RED);
		
		btn.setDisable(true);
		dogadjajBtn();
		dogadjajTextField();
	}
	
	public void dogadjajTextField()
	{
		
		tf1.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable,
		            String oldValue, String newValue) {
		    	
		    	greska.setText("");
		    	
		    	if (oldValue.equals("") && !tf2.getText().equals(""))
		    		btn.setDisable(false);
		    	else if (newValue.equals(""))
		    		btn.setDisable(true);
		    	
		    }
		});
		
		tf2.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable,
		            String oldValue, String newValue) {

		    	greska.setText("");
		    	
		    	if (oldValue.equals("") && !tf1.getText().equals(""))
		    		btn.setDisable(false);
		    	else if (newValue.equals(""))
		    		btn.setDisable(true);
		    }
		});
	}
	
	public void dogadjajBtn()
	{
		this.btn.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		    	
		    	Prijavljivanje pr = new Prijavljivanje();
		    	
		    	TipKorisnika tip = pr.prijaviSe(tf1.getText(), tf2.getText());
		    	String username = tf1.getText();
		    	String password = tf2.getText();
		    	if (tip != null)
		    	{
		    		stage.hide();
		    		tf1.setText("");
		    		tf2.setText("");
		    		
		    		switch (tip) {
					case ADMINISTRATOR:
					{
						AdministratorProzor adminPr = new AdministratorProzor();
						
						break;	
					}
					
					case ZAPOSLENI_CENTRALA:
					{
						ZaposleniCentralaProzor zaposleniCentralaProzor = new ZaposleniCentralaProzor();
						break;
					}
					case SEF_STANICE:
					{
						SefStaniceProzor sefStaniceProzor = new SefStaniceProzor(username,password);
						break;
					}
					case OPERATER:
					{
						OperaterProzor operaterProzor = new OperaterProzor();
						
						break;
					}
					default:
						break;
					}
		    		stage.show();
		    		
		    	}
		    	else {
		    		greska.setText("Pogresno korisnicko ime ili lozinka.");
		    	}
		    	
		    }
		});
	}

}
