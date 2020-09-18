package com.elinis.texteditor.frontend.view.service;

import com.elinis.texteditor.filemanagement.ExtendedFileChooser;
import com.elinis.texteditor.frontend.view.AbstractView;
import com.elinis.texteditor.frontend.view.AbstractViewModel;
import com.elinis.texteditor.frontend.view.PresentationType;
import com.elinis.texteditor.frontend.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * Service that manages views in the application.
 */
@Service
public class ViewService {

    private final ExtendedFileChooser extendedFileChooser;

    @Autowired
    public ViewService(final ExtendedFileChooser extendedFileChooser) {
        this.extendedFileChooser = extendedFileChooser;
    }

    public <V extends AbstractView<? extends VM>, VM extends AbstractViewModel> void prepareView(
            final Class<V> viewClass) {
        final ViewTuple<V, VM> viewTuple = FluentViewLoader.javaView(viewClass).load();
        final Region view = (Region) viewTuple.getView();
        final VM viewModel = viewTuple.getViewModel();

        setPrefSize(view);

        final Stage stage = new Stage();
        final Scene scene = new Scene(view);

        viewModel.setAssociatedScene(scene);
        stage.titleProperty().bind(viewModel.titleProperty());

        stage.setScene(scene);

        viewModel.requestStyleChange();

        stage.show();
    }

    private void setPrefSize(final Region view) {
        View annotation = view.getClass().getAnnotation(View.class);

        if (annotation != null) {
            PresentationType type = annotation.value();
            view.setPrefSize(type.getWidth(), type.getHeight());
        }
    }

    /**
     * @deprecated The current implementation of opening the file chooser is not very fluent and a
     *             good API, search for another way.
     */
    public ExtendedFileChooser getFileChooser() {
        return extendedFileChooser;
    }
}
