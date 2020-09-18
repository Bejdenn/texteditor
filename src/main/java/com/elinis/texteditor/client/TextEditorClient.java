package com.elinis.texteditor.client;

import com.elinis.texteditor.frontend.editor.EditorView;
import com.elinis.texteditor.frontend.view.service.ViewService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import de.saxsys.mvvmfx.MvvmFX;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX application class. The method {@link #startClient(String[])} should bTe called from
 * another class.
 */
@Configuration
@ComponentScan("com.elinis")
public class TextEditorClient extends Application {

    /**
     * Starts the JavaFX client.
     * 
     * @param args
     */
    static final void startClient(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try (ConfigurableApplicationContext context = SpringApplication.run(getClass())) {
            MvvmFX.setCustomDependencyInjector(context::getBean);
            context.getBeanFactory().autowireBean(this);

            ViewService viewService = context.getBean(ViewService.class);
            viewService.prepareView(EditorView.class);
        } catch (Exception e) {
            throw e;
        }
    }
}
