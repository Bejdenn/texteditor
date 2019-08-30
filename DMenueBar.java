package src;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class DMenueBar extends MenuBar {

	FileManager fileManager = new FileManager();

	public DMenueBar() {

		Menu menu = new Menu("Datei");

		MenuItem open = new MenuItem("Öffnen");
		open.setOnAction(e -> {
			fileManager.openFile();
		});

		MenuItem save = new MenuItem("Speichern");
		save.setOnAction(e -> {
			fileManager.fastFileSave();
		});

		MenuItem saveAt = new MenuItem("Speichern unter");
		saveAt.setOnAction(e -> {
			fileManager.saveFileAt();
		});

		MenuItem newText = new MenuItem("Neu");
		newText.setOnAction(e -> {
			String decision = fileManager.checkConditions();

			if (decision.equals("No conditions")) {
				decision = fileManager.throwSaveWarning();
			}

			switch (decision) {
			case DOptionPane.SPEICHERN:
				ExecutiveClass.clear();
			case DOptionPane.NICHT_SPEICHERN:
				ExecutiveClass.clear();
			default:
				break;
			}
		});

		MenuItem close = new MenuItem("Beenden");
		close.setOnAction(e -> {
			String decision = fileManager.checkConditions();

			if (decision.equals("No conditions")) {
				decision = fileManager.throwSaveWarning();
			}

			switch (decision) {
			case DOptionPane.SPEICHERN:
				System.exit(0);
				break;
			case DOptionPane.NICHT_SPEICHERN:
				System.exit(0);
				break;
			default:
				break;
			}
		});

		ExecutiveClass.getPrimaryStage().setOnCloseRequest(event -> {
			close.fire();
			event.consume();
		});

		menu.getItems().addAll(newText, open, save, saveAt, close);
		this.getMenus().add(menu);
	}
}
