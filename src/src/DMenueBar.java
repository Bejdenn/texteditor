package src;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class DMenueBar extends MenuBar {

	FileManager fileManager = new FileManager();

	public DMenueBar() {
		Menu menu1 = new Menu("Datei");

		MenuItem open = new MenuItem("Öffnen");
		open.setOnAction(e -> {
			Util.open();
		});

		MenuItem save = new MenuItem("Speichern");
		save.setOnAction(e -> {
			Util.fastFileSave();
		});

		MenuItem saveAt = new MenuItem("Speichern unter");
		saveAt.setOnAction(e -> {
			Util.saveFileAt();
		});

		MenuItem newText = new MenuItem("Neu");
		newText.setOnAction(e -> {
			Util.createNewText();
		});

		MenuItem close = new MenuItem("Beenden");
		close.setOnAction(e -> {
			Util.close();
		});

		ExecutiveClass.getPrimaryStage().setOnCloseRequest(event -> {
			close.fire();
			event.consume();
		});

		menu1.getItems().addAll(newText, open, save, saveAt, close);
		this.getMenus().add(menu1);

		Menu menu2 = new Menu("Bearbeiten");

		MenuItem undo = new MenuItem("Rückgangig");
		undo.setOnAction(e -> {
			ExecutiveClass.getWindowText().undo();
		});

		MenuItem cutOut = new MenuItem("Ausschneiden");
		cutOut.setOnAction(e -> {
			Util.copy();
		});

		menu2.getItems().addAll(undo, cutOut);
		this.getMenus().add(menu2);
	}

}
