package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class IzvestajiProzor extends BorderPane {
	// TOP
		StackPane sp = new StackPane();
		Label l = new Label("IZVESTAJI");
		
	public IzvestajiProzor()
	{
		podesiTop();	
	}
	
	private void podesiTop()
	{
		sp.getChildren().add(l);
		sp.setAlignment(Pos.CENTER);
		this.setTop(sp);
	}
}
