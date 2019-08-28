package src;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FuncButton extends DefaultButton {

	private String function;
	
	public FuncButton(String text) {
		super(text);
		this.function = text;
		this.setFont(Font.font("Arial", FontWeight.BOLD, 22));
	}

}
