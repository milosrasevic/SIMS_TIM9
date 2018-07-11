package gui;



import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdministratorProzor extends Stage {

	private Button btn = new Button("Odjavi se");
	private Button btn_IzvestajiStanice = new Button("PREGLEDAJ IZVESTAJE SA NAPLATNIH STANICA");
	private Button btn_IzvestajiMesta = new Button("PREGLEDAJ IZVESTAJE SA NAPLATNIH MESTA");
	
	private HBox hbox1 = new HBox();
	
	private HBox ikonice = new HBox();
	private HBox dugmad = new HBox();
	private VBox vbox1 = new VBox(100);
	
	public AdministratorProzor()
	{
		AdministratorProzor prozor = this;
		
		BorderPane root = new BorderPane();
		StackPane sp = new StackPane();
		
		Scene osnovnaScena = new Scene(root,1000,500);
		this.setScene(osnovnaScena);
		this.setMaximized(true);
		this.initStyle(StageStyle.UTILITY);
		this.setTitle("ADMINISTRATOR");
		
		
		root.setTop(hbox1);
		hbox1.setStyle("-fx-background-color: #336699;");
		hbox1.getChildren().add(btn);
		hbox1.setAlignment(Pos.CENTER_RIGHT);
		hbox1.setPadding(new Insets(10,10,10,0));

		
		Image image = new Image(new File("src/slike/izvestaji.png").toURI().toString());
		ImageView iv = new ImageView();
		iv.setImage(image);
		
		ikonice.getChildren().add(iv);
		btn_IzvestajiStanice.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		btn_IzvestajiStanice.setPrefSize(620, 50);
		btn_IzvestajiMesta.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		btn_IzvestajiMesta.setPrefSize(620, 50);

		vbox1.getChildren().add(ikonice);

		
		dugmad.getChildren().add(btn_IzvestajiMesta);
		dugmad.getChildren().add(btn_IzvestajiStanice);
		vbox1.getChildren().add(dugmad);
		
		root.setCenter(vbox1);
		vbox1.setAlignment(Pos.CENTER_RIGHT);
		this.btn.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		    	prozor.close();
		    }
		});
		
		this.showAndWait();
		
	}
}
