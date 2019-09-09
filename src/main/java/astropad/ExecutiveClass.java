package astropad;

import de.saxsys.mvvmfx.internal.viewloader.View;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ExecutiveClass extends Application implements View<FileManager> {

	private static Stage primaryStage;
	private static CustomTextArea customTextArea;
	private FileManager fileManager = new FileManager();

	@Override
	public void start(Stage stage) throws Exception {
		primaryStage = stage;

		stage.titleProperty().bind(fileManager.currentFileName());
		stage.titleProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> tab, String oldTitle, String newTitle) {
				stage.setTitle(newTitle);
			}
		});

		CustomMenuBar menue = new CustomMenuBar();

		customTextArea = new CustomTextArea();

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(menue);
		borderPane.setCenter(customTextArea);

		Scene scene = new Scene(new Group(borderPane), 700, 700);
		scene.getStylesheets().add("JMetroPanes.css");
		scene.getStylesheets().add("JMetroLightTheme.css");

		stage.getIcons().add(new Image("icon.png"));
		stage.setScene(scene);
		stage.titleProperty().bind(fileManager.currentFileName());
		stage.show();

		borderPane.prefWidthProperty().bind(scene.widthProperty());
		borderPane.prefHeightProperty().bind(scene.heightProperty());
	}

	class CustomTextArea extends TextArea {

		public int fontSize;

		public CustomTextArea() {
			fontSize = 20;
			this.setStyle("-fx-font-size: " + fontSize + "px;");
			this.textProperty().addListener((observable, oldValue, newValue) -> fileManager.setSaved(false));
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static String getContent() {
		return customTextArea.getText();
	}

	public static CustomTextArea getCustomTextArea() {
		return customTextArea;
	}

	public static void clear() {
		customTextArea.setText("");
		primaryStage.setTitle("Unbenannt" + " - AstroPad");
	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}
}
