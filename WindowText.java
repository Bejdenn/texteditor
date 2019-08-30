package src;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class WindowText extends TextArea {

	public WindowText() {
		this.setFont(Font.font("Arial", 18));
		this.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> observable, final String oldValue,
					final String newValue) {
				FileManager.setSaved(false);
			}
		});
	}
}
