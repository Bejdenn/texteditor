package src;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class CustomTextField extends TextField {

	private String value;

	public CustomTextField(String text, int maxLength) {
		this.setPromptText(text);
		this.setFont(Font.font("Arial", 22));
		CustomTextField.addTextLimiter(this, maxLength);
	}

	public static void addTextLimiter(final TextField tf, final int maxLength) {
	    tf.textProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
	            if (tf.getText().length() > maxLength) {
	                String s = tf.getText().substring(0, maxLength);
	                tf.setText(s);
	            }
	        }
	    });	
	}
	
	public String getValue() {
		return value;
	}

	public void setValue() {
		this.value = this.getText();
	}
}
