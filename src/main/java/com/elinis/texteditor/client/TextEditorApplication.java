package com.elinis.texteditor.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;

/**
 * TODO add proper documentation
 */
@SpringBootApplication
public class TextEditorApplication {

    public static void main(String[] args) {
        Application.launch(TextEditorApplicationStarter.class, args);
    }
}
