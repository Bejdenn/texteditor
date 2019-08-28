package src;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorCycle extends Application {

	private static WindowPanel root;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new WindowPanel();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Color Cycle");
		primaryStage.show();
	}
	
	public static WindowPanel getRoot() {
		return root;
	}
}
