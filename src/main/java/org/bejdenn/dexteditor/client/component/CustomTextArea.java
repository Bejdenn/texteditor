package org.bejdenn.dexteditor.client.component;

import org.bejdenn.dexteditor.client.FileManagerService;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;

public class CustomTextArea extends TextArea {

	public static final int fontSize = 20;

	public CustomTextArea() {
		this.setStyle("-fx-font-size: " + fontSize + "px;");
		this.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> observable, final String oldValue,
					final String newValue) {
				FileManagerService.setSaved(false);
			}
		});
	}
}
