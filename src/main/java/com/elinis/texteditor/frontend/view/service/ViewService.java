package com.elinis.texteditor.frontend.view.service;

import javax.inject.Singleton;
import com.elinis.texteditor.frontend.view.AbstractView;
import com.elinis.texteditor.frontend.view.AbstractViewModel;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Services that manages views in the application.
 */
@Singleton
public class ViewService {

    public <V extends AbstractView<? extends VM>, VM extends AbstractViewModel> void prepareView(
            Class<V> viewClass) {
        ViewTuple<V, VM> viewTuple = FluentViewLoader.javaView(viewClass).load();
        Stage stage = new Stage();
        stage.setScene(new Scene(viewTuple.getView()));
        stage.show();
    }
}
