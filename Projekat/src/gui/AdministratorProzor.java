package gui;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class AdministratorProzor extends Stage {

	public AdministratorProzor() {
		StackPane root = new StackPane();
		this.setScene(new Scene(root,1000,500));
		
		 this.setMaximized(true);
		 this.resizableProperty().setValue(Boolean.FALSE);
		 this.show();
	}
}
