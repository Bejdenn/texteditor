package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javafx.event.Event;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileManager {

	private File currentFile;
	private static boolean saved;

	public FileManager() {
		saved = false;
	}

	public void openFile(Stage stage) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Textdateien", "*.txt"),
				new FileChooser.ExtensionFilter("Java-Dateien", "*.java"));
		File file = fileChooser.showOpenDialog(stage);
		if (file != null) {
			readFile(file);
			currentFile = file;
		}
	}

	public void saveFileAt(Stage stage) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Textdateien", "*.txt"),
				new FileChooser.ExtensionFilter("Java-Dateien", "*.java"));
		File file = fileChooser.showSaveDialog(stage);
		if (file != null) {
			this.saveFile(file);
			ExecutiveClass.setCurrentFile(file.getName());
			currentFile = file;
			saved = true;
		}
	}

	public void fastFileSave(Stage stage) {
		if (currentFile == null) {
			this.saveFileAt(stage);
		} else {
			this.saveFile(currentFile);
		}
	}

	private void readFile(File file) {
		try {
			ExecutiveClass.setCurrentFile(file.getName());
			List<String> lines = Files.readAllLines(Paths.get(file.getPath()), Charset.defaultCharset());
			ExecutiveClass.getWinText().setText("");
			for (String s : lines) {
				ExecutiveClass.getWinText().appendText(s + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void saveFile(File file) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);
			for (String line : ExecutiveClass.getWinText().getText().split("\\n")) {
				writer.println(line);
			}
			saved = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}

	public void saveOrNot(Stage stage) {
		if (saved == true) {
			ExecutiveClass.clear();
			return;
		}
		if (!(ExecutiveClass.getWinText().getText().equals(""))) {
			this.throwSaveWarning(stage);
			return;
		}
		if (ExecutiveClass.getWinText().getText().equals("") && this.getCurrentFile() == null) {
			ExecutiveClass.clear();
			return;
		}
		if (ExecutiveClass.getWinText().getText().equals("") && this.getCurrentFile() != null) {
			this.throwSaveWarning(stage);
		}
	}

	public void throwSaveWarning(Stage stage) {
		String file = "";
		String decision = DOptionPane.showWarning("DNotepad", "Möchten Sie die Änderung an " + file + " speichern?");
		if (currentFile == null) {
			file = "Unbenannt";
		} else {
			file = this.getCurrentFile().getName();
		}
		if (decision.equals(DOptionPane.ABBRECHEN)) {
			return;
		} else if (decision.equals(DOptionPane.SPEICHERN)) {
			if (this.isSaved() == false) {
				this.saveFileAt(stage);
				currentFile = null;
				ExecutiveClass.clear();

			} else if (this.isSaved() == true) {
				this.fastFileSave(stage);
				currentFile = null;
				ExecutiveClass.clear();
			}
			return;
		} else if (decision.equals(DOptionPane.NICHT_SPEICHERN)) {
			currentFile = null;
			ExecutiveClass.clear();
		}
	}
	
	public void closeOrNot(Stage stage) {
		if (saved == true) {
			System.exit(0);
		}
		if (!(ExecutiveClass.getWinText().getText().equals(""))) {
			this.throwCloseWarning(stage);
			return;
		}
		if (ExecutiveClass.getWinText().getText().equals("") && this.getCurrentFile() == null) {
			System.exit(0);
			return;
		}
		if (ExecutiveClass.getWinText().getText().equals("") && this.getCurrentFile() != null) {
			this.throwCloseWarning(stage);
		}
	}
	
	public void throwCloseWarning(Stage stage) {
		String file = "";
		String decision = DOptionPane.showWarning("DNotepad", "Möchten Sie die Änderung an " + file + " speichern?");
		if (currentFile == null) {
			file = "Unbenannt";
		} else {
			file = this.getCurrentFile().getName();
		}
		if (decision.equals(DOptionPane.ABBRECHEN)) {
			return;
		} else if (decision.equals(DOptionPane.SPEICHERN)) {
			if (this.isSaved() == false) {
				this.saveFileAt(stage);
				System.exit(0);

			} else if (this.isSaved() == true) {
				this.fastFileSave(stage);
				System.exit(0);
			}
			return;
		} else if (decision.equals(DOptionPane.NICHT_SPEICHERN)) {
			System.exit(0);
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
