package com.elinis.texteditor.client;

import com.elinis.texteditor.backend.BackendModule;
import com.elinis.texteditor.frontend.FrontendModule;
import com.elinis.texteditor.frontend.editor.EditorView;
import com.elinis.texteditor.frontend.view.service.ViewService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import de.saxsys.mvvmfx.guice.MvvmfxGuiceApplication;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX application class. The main method should be called from outside, in the usual program
 * flow.
 */
public class TextEditorClient extends MvvmfxGuiceApplication {

    /**
     * Main method of the {@link TextEditorClient} class.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void startMvvmfx(Stage stage) throws Exception {
        Injector injector = Guice.createInjector(new FrontendModule(), new BackendModule());
        ViewService viewService = injector.getInstance(ViewService.class);
        viewService.prepareView(EditorView.class);
    }

}
