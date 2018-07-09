package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdministratorProzor extends Stage {

	private Button btn = new Button("Odjavi se");
	private HBox hbox1 = new HBox();
	
	public AdministratorProzor()
	{
		AdministratorProzor prozor = this;
		
		BorderPane root = new BorderPane();
		
		this.setScene(new Scene(root,1000,500));
		this.setMaximized(true);
		this.initStyle(StageStyle.UTILITY);
		
		root.setTop(hbox1);
		hbox1.setStyle("-fx-background-color: #336699;");
		hbox1.getChildren().add(btn);
		hbox1.setAlignment(Pos.CENTER_RIGHT);
		hbox1.setPadding(new Insets(10,10,10,0));
		
		
		this.btn.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		    	prozor.close();
		    }
		});
		
		this.showAndWait();
		
	}
}
