package src;

import javafx.print.Printer;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;

public class DMenueBar extends MenuBar {

	FileManager fileManager = new FileManager();

	public DMenueBar() {
		Menu menu1 = new Menu("Datei");

		MenuItem open = new MenuItem("Öffnen");
		open.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
		open.setOnAction(e -> {
			Util.open();
		});

		MenuItem save = new MenuItem("Speichern");
		save.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
		save.setOnAction(e -> {
			Util.fastFileSave();
		});

		MenuItem saveAt = new MenuItem("Speichern unter");
		saveAt.setOnAction(e -> {
			Util.saveFileAt();
		});

		MenuItem newText = new MenuItem("Neu");
		newText.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
		newText.setOnAction(e -> {
			Util.createNewText();
		});

		MenuItem printer = new MenuItem("Drucken");
		printer.setAccelerator(KeyCombination.keyCombination("Ctrl+P"));
		printer.setOnAction(e -> {

		});

		SeparatorMenuItem line = new SeparatorMenuItem();
		SeparatorMenuItem line1 = new SeparatorMenuItem();

		MenuItem close = new MenuItem("Beenden");
		close.setOnAction(e -> {
			Util.close();
		});

		ExecutiveClass.getPrimaryStage().setOnCloseRequest(event -> {
			close.fire();
			event.consume();
		});

		menu1.getItems().addAll(newText, open, save, saveAt, line, printer, line1, close);
		this.getMenus().add(menu1);

		Menu menu2 = new Menu("Bearbeiten");

		MenuItem undo = new MenuItem("Rückgangig");
		undo.setOnAction(e -> {
			Util.undo();
		});

		MenuItem cutOut = new MenuItem("Ausschneiden");
		cutOut.setOnAction(e -> {
			Util.copy();
		});

		menu2.getItems().addAll(undo, cutOut);
		this.getMenus().add(menu2);

		Menu menu3 = new Menu("Format");

		CheckMenuItem breakLine = new CheckMenuItem("Zeilenumbruch");
		breakLine.setOnAction(e -> {
			Util.breakLine(breakLine.isSelected());
		});

		MenuItem font = new MenuItem("Schriftart");
		font.setOnAction(e -> {
			try {
				String url = "https://github.com/Bejdenn";
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
			} catch (java.io.IOException ex) {
				System.out.println(ex.getMessage());
			}
		});

		menu3.getItems().addAll(breakLine, font);
		this.getMenus().add(menu3);

		Menu menu4 = new Menu("Hilfe");
		MenuItem info = new MenuItem("Info");

		info.setOnAction(e -> {
			switch (DOptionPane.showInformation("Information",
					"Dies ist eine Open-Source-Anwendung. Ersteller ist bejdenn. Mit den Knöpfen kommt man auf das GitHub-Profil oder das Repository.")) {
			case DOptionPane.PROFIL:
				try {
					String url = "https://github.com/Bejdenn";
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				} catch (java.io.IOException ex) {
					System.out.println(ex.getMessage());
				}
			case DOptionPane.REPO:
				try {
					String url = "https://github.com/Bejdenn/DNotepad";
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				} catch (java.io.IOException ex) {
					System.out.println(ex.getMessage());
				}
			}

		});
		menu4.getItems().addAll(info);
		this.getMenus().add(menu4);
	}

}
