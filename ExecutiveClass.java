package src;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ExecutiveClass extends Application {

	private static Stage primaryStage;
	private static String fileName;
	private static WindowText winText;

	@Override
	public void start(Stage stage) throws Exception {
		primaryStage = stage;
		fileName = "Unbenannt";
		stage.setTitle(fileName + " - DNotepad");

		DMenueBar menue = new DMenueBar();

		winText = new WindowText();

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(menue);
		borderPane.setCenter(winText);

		Scene scene = new Scene(new Group(borderPane), 700, 700);
		scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		stage.setScene(scene);
		stage.show();

		borderPane.prefWidthProperty().bind(scene.widthProperty());
		borderPane.prefHeightProperty().bind(scene.heightProperty());
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static String getContent() {
		return winText.getText();
	}
	
	public static WindowText getWindowText() {
		return winText;
	}

	public static void setFileName(String fileName) {
		ExecutiveClass.fileName = fileName;
		primaryStage.setTitle(fileName + " - DNotepad");
	}

	public static void clear() {
		winText.setText("");
		primaryStage.setTitle("Unbenannt" + " - DNotepad");
	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}
}
