package src;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public final class Util {
	
	public static void copy() {
		final Clipboard clipboard = Clipboard.getSystemClipboard();
		final ClipboardContent content = new ClipboardContent();
		content.putString(ExecutiveClass.getWindowText().getSelectedText());
		clipboard.setContent(content);
	}
}
