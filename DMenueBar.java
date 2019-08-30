package src;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class DMenueBar extends MenuBar {

	FileManager fileManager = new FileManager();

	public DMenueBar() {
		this.getStyleClass().add("menubar");
		Menu menu1 = new Menu("Datei");

		MenuItem open = new MenuItem("�ffnen");
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

		menu1.getItems().addAll(newText, open, save, saveAt, close);
		this.getMenus().add(menu1);

		Menu menu2 = new Menu("Bearbeiten");

		MenuItem undo = new MenuItem("R�ckgangig");
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
