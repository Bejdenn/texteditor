package astropad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileManager implements ViewModel {

	private File currentFile;
	private StringProperty currentFileName;
	private boolean saved;
	private FileChooser fileChooser = new FileChooser();
	private Stage stage = ExecutiveClass.getPrimaryStage();

	public FileManager() {
		currentFileName = new SimpleStringProperty("Unbenannt");
		saved = false;
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Textdateien", "*.txt"),
				new FileChooser.ExtensionFilter("Java-Dateien", "*.java"),
				new FileChooser.ExtensionFilter("HTML-Dateien", "*.html"),
				new FileChooser.ExtensionFilter("LOG-Dateien", "*.log"),
				new FileChooser.ExtensionFilter("Alle Dateien", "*.*"));
	}

	private void setCurrentFileName() {
		currentFileName.set(currentFile.getName());
		System.out.println(currentFileName.get());
	}

	public String getCurrentFileName() {
		return currentFileName.getValue();
	}

	public StringProperty currentFileName() {
		return currentFileName;
	}

	public void openFile() {
		File file = fileChooser.showOpenDialog(stage);
		if (file != null) {
			try {
				readFile(file);
			} catch (UncheckedIOException | IOException e) {
				DOptionPane.showError("Lesefehler", "Datei konnte nicht gelesen werden. "
						+ "Sie beinhaltet möglicherweise nicht lesbare Zeichen oder liegt in einem nicht unterstützen Format vor.");
				return;
			}
			currentFile = file;
			this.setCurrentFileName();
			saved = true;
		}
	}

	public void saveFileAt() {
		File file = fileChooser.showSaveDialog(stage);
		if (file != null) {
			this.saveFile(file);
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

	private void readFile(File file) throws UncheckedIOException, IOException {
		Stream<String> lines = Files.lines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
		ExecutiveClass.getCustomTextArea().setText("");
		lines.forEach(s -> {
			ExecutiveClass.getCustomTextArea().appendText(s);
			if (!(s.equals(null))) {
				ExecutiveClass.getCustomTextArea().appendText("\n");
			}
		});
		currentFile = file;
		lines.close();
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
			currentFile = null;
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
		String decision = DOptionPane.showWarning("DNotepad", "Möchten Sie die Änderungen an " + file + " speichern?");

		switch (decision) {
		case DOptionPane.ABBRECHEN:
			return DOptionPane.ABBRECHEN;
		case DOptionPane.SPEICHERN:
			if (saved == false) {
				this.saveFileAt();
				if (saved != true) {
					return DOptionPane.ABBRECHEN;
				}
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

	public void setSaved(boolean Tsaved) {
		saved = Tsaved;
	}

	public File getCurrentFile() {
		return currentFile;
	}
}
