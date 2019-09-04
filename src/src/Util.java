package src;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public final class Util {

	static FileManager fileManager = new FileManager();

	public static void copy() {
		final Clipboard clipboard = Clipboard.getSystemClipboard();
		final ClipboardContent content = new ClipboardContent();
		content.putString(ExecutiveClass.getWindowText().getSelectedText());
		clipboard.setContent(content);
	}

	public static void cut() {
		final Clipboard clipboard = Clipboard.getSystemClipboard();
		final ClipboardContent content = new ClipboardContent();
		content.putString(ExecutiveClass.getWindowText().getSelectedText());
		clipboard.setContent(content);
		ExecutiveClass.getWindowText().setText(
				ExecutiveClass.getWindowText().getText().replace(ExecutiveClass.getWindowText().getSelectedText(), ""));
	}
	
	public static void paste() {
		final Clipboard clipboard = Clipboard.getSystemClipboard();
		ExecutiveClass.getWindowText().appendText(clipboard.getString());
	}

	public static void open() {
		String decision = fileManager.checkConditions();

		if (decision.equals("No conditions")) {
			decision = fileManager.throwSaveWarning();
		}

		switch (decision) {
		case DOptionPane.SPEICHERN:
			fileManager.openFile();
			break;
		case DOptionPane.NICHT_SPEICHERN:
			fileManager.openFile();
			break;
		default:
			break;
		}
	}

	public static void fastFileSave() {
		fileManager.fastFileSave();
	}

	public static void saveFileAt() {
		fileManager.saveFileAt();
	}

	public static void createNewText() {
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
	}

	public static void undo() {
		if (fileManager.isSaved() != true) {
			ExecutiveClass.getWindowText().undo();
		}
	}

	public static void close() {
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
	}

	public static void breakLine(boolean b) {
		ExecutiveClass.getWindowText().setWrapText(b);
	}
}
