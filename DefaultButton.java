package src;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class DefaultButton extends Button {
	public DefaultButton (String text) {
		this.setText(text);
		this.setFont(Font.font("Arial", 17));
	}
}
