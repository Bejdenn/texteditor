package src;

import java.util.concurrent.ThreadLocalRandom;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class WindowPanel extends GridPane implements Runnable {
	private Text text = new Text("Welcome to Color Cycle!");

	private CustomTextField rInputField = new CustomTextField("RED", 3);
	private CustomTextField gInputField = new CustomTextField("GREEN", 3);
	private CustomTextField bInputField = new CustomTextField("BLUE", 3);

	private StartButton startButton = new StartButton(this);

	private CustomTextField durationField = new CustomTextField("SECONDS", 5);

	private CustomTextField rFactorField = new CustomTextField("FACTOR FOR RED", 3);
	private CustomTextField gFactorField = new CustomTextField("FACTOR FOR GREEN", 3);
	private CustomTextField bFactorField = new CustomTextField("FACTOR FOR BLUE", 3);

	private static ColorControl colorControl = new ColorControl();

	private static Text console = new Text();

	public WindowPanel() {
		this.setPadding(new Insets(25, 25, 25, 25));
		this.setVgap(30);

		text.setFont(Font.font("Arial", FontWeight.BOLD, 30));

		HBox colorInputArea = new HBox();
		colorInputArea.setSpacing(50);

		colorInputArea.getChildren().addAll(rInputField, gInputField, bInputField);

		HBox factorInputArea = new HBox();
		factorInputArea.setSpacing(50);

		factorInputArea.getChildren().addAll(rFactorField, gFactorField, bFactorField);

		HBox sizeChangerBox = new HBox();
		sizeChangerBox.setSpacing(75);

		console.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		console.setStyle("-fx-font-color: #a8323a;");

		GridPane.setConstraints(text, 0, 0);
		GridPane.setConstraints(colorInputArea, 0, 1);
		GridPane.setConstraints(startButton, 0, 3);
		GridPane.setConstraints(durationField, 0, 4);
		GridPane.setConstraints(factorInputArea, 0, 2);
		GridPane.setConstraints(console, 0, 5);

		this.getChildren().addAll(text, startButton, colorInputArea, factorInputArea, durationField, console);

	}

	void saveInput() {
		rInputField.setValue();
		gInputField.setValue();
		bInputField.setValue();

		startButton.getTimeline().setDuration(Float.parseFloat(durationField.getText()));
		colorControl.setrFactor(Integer.parseInt(rFactorField.getText()));
		colorControl.setgFactor(Integer.parseInt(gFactorField.getText()));
		colorControl.setbFactor(Integer.parseInt(bFactorField.getText()));

		if (Integer.parseInt(rInputField.getValue()) > 255) {
			rInputField.setText("" + ThreadLocalRandom.current().nextInt(0, 255 + 1));
			rInputField.setValue();
		}
		if (Integer.parseInt(gInputField.getValue()) > 255) {
			gInputField.setText("" + ThreadLocalRandom.current().nextInt(0, 255 + 1));
			gInputField.setValue();
		}
		if (Integer.parseInt(bInputField.getValue()) > 255) {
			bInputField.setText("" + ThreadLocalRandom.current().nextInt(0, 255 + 1));
			bInputField.setValue();
		}
		colorControl.setRgb(rInputField.getValue(), gInputField.getValue(), bInputField.getValue());
	}

	private void setColor() {
		this.setStyle("-fx-background-color: rgb(" + colorControl.getR() + "," + colorControl.getG() + ", "
				+ colorControl.getB() + ");");
	}

	@Override
	public void run() {
		this.setColor();
		colorControl.increaseColorValues();
	}

	public static void writeToConsole(String exception) {
		console.setText(exception);
	}

	public void setRestricted(boolean b) {
		rInputField.setDisable(b);
		gInputField.setDisable(b);
		bInputField.setDisable(b);

		rFactorField.setDisable(b);
		gFactorField.setDisable(b);
		bFactorField.setDisable(b);
		
		durationField.setDisable(b);

	}
}
