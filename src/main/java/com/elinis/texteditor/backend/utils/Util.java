package com.elinis.texteditor.backend.utils;

public final class Util {

//	public static void copyText() {
//		final Clipboard clipboard = Clipboard.getSystemClipboard();
//		final ClipboardContent content = new ClipboardContent();
//		content.putString(ExecutiveClass.getCustomTextArea().getSelectedText());
//		clipboard.setContent(content);
//	}
//
//	public static void cutText() {
//		final Clipboard clipboard = Clipboard.getSystemClipboard();
//		final ClipboardContent content = new ClipboardContent();
//		content.putString(ExecutiveClass.getCustomTextArea().getSelectedText());
//		clipboard.setContent(content);
//		ExecutiveClass.getCustomTextArea().setText(
//				ExecutiveClass.getCustomTextArea().getText().replace(ExecutiveClass.getCustomTextArea().getSelectedText(), ""));
//	}
//
//	public static void pasteText() {
//		final Clipboard clipboard = Clipboard.getSystemClipboard();
//		ExecutiveClass.getCustomTextArea().appendText(clipboard.getString());
//	}
//
//	public static void openFile() {
//		String decision = fileManager.checkConditions();
//
//		if (decision.equals("No conditions")) {
//			decision = fileManager.throwSaveWarning();
//		}
//
//		switch (decision) {
//		case DOptionPane.SPEICHERN:
//			fileManager.readFile();
//			break;
//		case DOptionPane.NICHT_SPEICHERN:
//			fileManager.readFile();
//			break;
//		default:
//			break;
//		}
//	}
//
//	public static void saveFile() {
//		fileManager.fastFileSave();
//	}
//
//	public static void saveFileAs() {
//		fileManager.saveFileAt();
//	}
//
//	public static void createNewText() {
//		String decision = fileManager.checkConditions();
//
//		if (decision.equals("No conditions")) {
//			decision = fileManager.throwSaveWarning();
//		}
//
//		switch (decision) {
//		case DOptionPane.SPEICHERN:
//			ExecutiveClass.clear();
//		case DOptionPane.NICHT_SPEICHERN:
//			ExecutiveClass.clear();
//		default:
//			break;
//		}
//	}
//
//	public static void undoChange() {
//		if (fileManager.isSaved() != true) {
//			ExecutiveClass.getCustomTextArea().undo();
//		}
//	}
//
//	public static void closeApp() {
//		String decision = fileManager.checkConditions();
//
//		if (decision.equals("No conditions")) {
//			decision = fileManager.throwSaveWarning();
//		}
//
//		switch (decision) {
//		case DOptionPane.SPEICHERN:
//			System.exit(0);
//			break;
//		case DOptionPane.NICHT_SPEICHERN:
//			System.exit(0);
//			break;
//		default:
//			break;
//		}
//	}
//
//	public static void isBreakingLine(boolean b) {
//		ExecutiveClass.getCustomTextArea().setWrapText(b);
//	}
//
//	public static void openInternetPage() {
//		switch (DOptionPane.showInformation("Information",
//				"Das ist eine Open-Source-Anwendung. Der Ersteller ist bejdenn. Mit den Knöpfen kommt man auf das GitHub-Profil oder das Repository.")) {
//		case DOptionPane.PROFIL:
//			try {
//				String url = "https://github.com/Bejdenn";
//				java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
//			} catch (java.io.IOException ex) {
//				System.out.println(ex.getMessage());
//			}
//		case DOptionPane.REPO:
//			try {
//				String url = "https://github.com/Bejdenn/DNotepad";
//				java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
//			} catch (java.io.IOException ex) {
//				System.out.println(ex.getMessage());
//			}
//		}
//	}
}
