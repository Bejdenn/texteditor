package com.elinis.texteditor.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TextEditorApplication {

    /**
     * Main method of the client.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        TextEditorClient.startClient(args);
    }
}
