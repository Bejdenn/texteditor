package org.bejdenn.dexteditor.client;

import org.bejdenn.dexteditor.client.component.CustomMenuBar;
import org.bejdenn.dexteditor.client.component.CustomTextArea;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ExecutiveClass extends Application {

    static CustomTextArea customTextArea = new CustomTextArea();
    private static String fileName;
    private static Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle(fileName + " - DNotepad");
        
        CustomMenuBar menue = new CustomMenuBar();


        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menue);
        borderPane.setCenter(customTextArea);
        
        Scene scene = new Scene(new Group(borderPane), 700, 700);

        stage.getIcons().add(new Image(ApplicationConstants.ICON_FILE_PATH));
        stage.setScene(scene);
        stage.show();

        borderPane.prefWidthProperty().bind(scene.widthProperty());
        borderPane.prefHeightProperty().bind(scene.heightProperty());
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

    public static void setFileName(String fileName) {
        ExecutiveClass.fileName = fileName;
        primaryStage.setTitle(fileName + " - DNotepad");
    }

    public static void clear() {
        customTextArea.setText("");
        primaryStage.setTitle("Unbenannt" + " - DNotepad");
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
