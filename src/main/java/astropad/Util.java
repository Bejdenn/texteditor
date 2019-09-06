package astropad;

import java.io.IOException;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public final class Util {

	private static FileManager fileManager = new FileManager();
	private final static Clipboard clipboard = Clipboard.getSystemClipboard();
	private final static ClipboardContent content = new ClipboardContent();

	public static void copyText() {
		content.putString(ExecutiveClass.getCustomTextArea().getSelectedText());
		clipboard.setContent(content);
	}

	public static void cutText() {
		content.putString(ExecutiveClass.getCustomTextArea().getSelectedText());
		clipboard.setContent(content);
		ExecutiveClass.getCustomTextArea().setText(ExecutiveClass.getCustomTextArea().getText()
				.replace(ExecutiveClass.getCustomTextArea().getSelectedText(), ""));
	}

	public static void pasteText() {
		ExecutiveClass.getCustomTextArea().appendText(clipboard.getString());
	}

	public static void openFile() {
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

	public static void saveFile() {
		fileManager.fastFileSave();
	}

	public static void saveFileAs() {
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

	public static void undoChange() {
		if (fileManager.isSaved() != true) {
			ExecutiveClass.getCustomTextArea().undo();
		}
	}

	public static void closeApp() {
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

	public static void isBreakingLine(boolean b) {
		ExecutiveClass.getCustomTextArea().setWrapText(b);
	}
}
