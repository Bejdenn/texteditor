package com.elinis.texteditor.client;

import com.elinis.texteditor.frontend.editor.EditorView;
import com.elinis.texteditor.frontend.view.service.ViewService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import de.saxsys.mvvmfx.MvvmFX;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX application class. The method {@link #startClient(String[])} should be called from another
 * class.
 */
@Configuration
@ComponentScan("com.elinis.texteditor")
public class TextEditorApplicationConfiguration extends Application {

    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Starts up this {@link Application}.
     */
    static final void startClient(String[] args) {
        launch(args);
    }

    /**
     * Runs the {@link SpringApplication} and registers the {@code ApplicationContext} for the
     * {@code MvvmFX framework}. Afterwards the {@link ViewService} prepares the first application
     * view.
     */
    @Override
    public void start(Stage stage) throws Exception {
        try (ConfigurableApplicationContext context = SpringApplication.run(getClass())) {
            MvvmFX.setCustomDependencyInjector(context::getBean);
            context.getBeanFactory().autowireBean(this);

            ViewService viewService = context.getBean(ViewService.class);
            viewService.prepareView(EditorView.class);
        } catch (Exception e) {
            LOGGER.error("An error occurred while starting the application.");
            throw e;
        }
    }
}
