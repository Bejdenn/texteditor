package com.elinis.texteditor.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import javafx.application.Application;

/**
 * Class that represents the main entry point of the TextEditor application. Its sole purpose is to
 * call {@link TextEditorApplicationConfiguration#startClient(String[])} to avoid the exception that
 * occurs when starting an extended {@link Application} directly.
 */
@SpringBootApplication
public class TextEditorApplication {

    public static void main(String[] args) {
        TextEditorApplicationConfiguration.startClient(args);
    }
}
