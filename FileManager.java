package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileManager {

	private File currentFile;
	private static boolean saved;
	private FileChooser fileChooser = new FileChooser();
	private Stage stage = ExecutiveClass.getPrimaryStage();

	public FileManager() {
		saved = false;
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Textdateien", "*.txt"),
				new FileChooser.ExtensionFilter("Java-Dateien", "*.java"),
				new FileChooser.ExtensionFilter("Alle Dateien", "*.*"),
				new FileChooser.ExtensionFilter("HTML-Dateien", "*.html"));
	}

	public void openFile() {
		File file = fileChooser.showOpenDialog(stage);
		if (file != null) {
			readFile(file);
			saved = true;
		}
	}

	public void saveFileAt() {
		File file = fileChooser.showSaveDialog(stage);
		if (file != null) {
			this.saveFile(file);
			ExecutiveClass.setFileName(file.getName());
			currentFile = file;
			saved = true;
		}
	}

	public void fastFileSave() {
		if (currentFile == null) {
			this.saveFileAt();
		} else {
			this.saveFile(currentFile);
		}
	}

	private void readFile(File file) {
		try {
			List<String> lines = Files.readAllLines(Paths.get(file.getPath()), Charset.defaultCharset());
			ExecutiveClass.getWindowText().setText("");
			ExecutiveClass.setFileName(file.getName());
			for (String s : lines) {
				ExecutiveClass.getWindowText().appendText(s + "\n");
			}
			currentFile = file;
		} catch (IOException e) {
			DOptionPane.showError("Lesefehler", "Datei konnte nicht gelesen werden. "
					+ "Es beinhaltet möglicherweise nicht lesbare Zeichen oder liegt in einem nicht unterstützen Format vor.");
		}
	}

	private void saveFile(File file) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);
			for (String line : ExecutiveClass.getContent().split("\\n")) {
				writer.println(line);
			}
			saved = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}

	public String checkConditions() {
		if (saved == true) {
			return DOptionPane.SPEICHERN;
		}
		if (ExecutiveClass.getContent().equals("")) {
			if (this.getCurrentFile() == null) {
				return DOptionPane.NICHT_SPEICHERN;
			}
		}
		return "No conditions";
	}

	public String throwSaveWarning() {
		String file = "";
		if (currentFile == null) {
			file = "Unbenannt";
		} else {
			file = this.getCurrentFile().getName();
		}
		String decision = DOptionPane.showWarning("DNotepad", "Möchten Sie die Änderung an " + file + " speichern?");

		switch (decision) {
		case DOptionPane.ABBRECHEN:
			return DOptionPane.ABBRECHEN;
		case DOptionPane.SPEICHERN:
			if (saved == false) {
				this.saveFileAt();
				currentFile = null;
				return DOptionPane.SPEICHERN;
			} else if (this.isSaved() == true) {
				this.fastFileSave();
				currentFile = null;
				return DOptionPane.SPEICHERN;
			}
			return DOptionPane.ABBRECHEN;
		case DOptionPane.NICHT_SPEICHERN:
			currentFile = null;
			return DOptionPane.NICHT_SPEICHERN;
		default:
			return "Fehler";
		}
	}

	public boolean isSaved() {
		return saved;
	}

	public static void setSaved(boolean Tsaved) {
		saved = Tsaved;
	}

	public File getCurrentFile() {
		return currentFile;
	}
}
