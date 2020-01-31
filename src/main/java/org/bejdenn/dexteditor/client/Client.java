package org.bejdenn.dexteditor.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Class that starts AstroPad client.
 */
public class Client extends Application {

    public static final Logger LOGGER = LogManager.getLogger(Client.class);

    /**
     * The main method of the client.
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LOGGER.info("Application has started.");
    }

}
