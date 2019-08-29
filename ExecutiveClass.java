package src;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ExecutiveClass extends Application {

	private static Stage primaryStage;
	static String currentFile;
	static WindowText winText;

	@Override
	public void start(Stage stage) throws Exception {
		primaryStage = stage;
		currentFile = "Unbenannt";
		stage.setTitle(currentFile + " - DNotepad");

		DMenueBar menue = new DMenueBar(stage);

		winText = new WindowText();

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(menue);
		borderPane.setCenter(winText);

		Scene scene = new Scene(new Group(borderPane), 500, 500);
		stage.setScene(scene);
		stage.show();
		

		borderPane.prefWidthProperty().bind(scene.widthProperty());
		borderPane.prefHeightProperty().bind(scene.heightProperty());
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static WindowText getWinText() {
		return winText;
	}

	public static void setCurrentFile(String currentFile) {
		ExecutiveClass.currentFile = currentFile;
		primaryStage.setTitle(currentFile + " - DNotepad");
	}

	public static void clear() {
		winText.setText("");
		primaryStage.setTitle("Unbenannt" + " - DNotepad");
	}
}
