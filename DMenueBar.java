package src;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class DMenueBar extends MenuBar {

	FileManager fileManager = new FileManager();

	public DMenueBar(Stage stage) {
		stage.setOnCloseRequest(event -> {
			fileManager.throwCloseWarning(stage);
		});
		
		Menu menu = new Menu("Datei");

		MenuItem open = new MenuItem("Öffnen");
		open.setOnAction(e -> {
			fileManager.openFile(stage);
		});

		MenuItem save = new MenuItem("Speichern");
		save.setOnAction(e -> {
			fileManager.fastFileSave(stage);
		});

		MenuItem saveAt = new MenuItem("Speichern unter");
		saveAt.setOnAction(e -> {
			fileManager.saveFileAt(stage);
		});

		MenuItem newText = new MenuItem("Neu");
		newText.setOnAction(e -> {
			fileManager.saveOrNot(stage);
		});

		MenuItem close = new MenuItem("Beenden");
		close.setOnAction(e -> {
			fileManager.closeOrNot(stage);
		});

		menu.getItems().addAll(newText, open, save, saveAt, close);
		this.getMenus().add(menu);
	}
}
