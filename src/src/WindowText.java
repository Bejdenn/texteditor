package src;

import javax.swing.undo.UndoManager;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;

public class WindowText extends TextArea {

	public static int fontSize;
	public static UndoManager undoManager = new UndoManager();

	public WindowText() {
		fontSize = 20;
		this.setStyle("-fx-font-size: " + fontSize + "px;");
		this.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> observable, final String oldValue,
					final String newValue) {
				FileManager.setSaved(false);
			}
		});
	}
}
