package gui;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OperaterProzor extends Stage {

	public OperaterProzor()
	{
		StackPane root = new StackPane();
		this.setScene(new Scene(root,1000,500));
		
		this.setMaximized(true);
		this.initStyle(StageStyle.UTILITY);
		this.show();
	}
}