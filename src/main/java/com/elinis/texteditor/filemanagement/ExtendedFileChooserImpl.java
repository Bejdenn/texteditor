package com.elinis.texteditor.filemanagement;

import java.io.File;
import java.util.Optional;
import java.util.Set;
import com.elinis.texteditor.frontend.view.AbstractViewModel;
import org.springframework.stereotype.Component;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;

/**
 * A customizable file chooser that offers some file managing actions.
 */
@Component
public class ExtendedFileChooserImpl implements ExtendedFileChooser {

    private static final FileChooser fileChooser = new FileChooser();

    private Window owner;

    public ExtendedFileChooserImpl() {
        setDefaultExtensionFilters();
    }

    private void setDefaultExtensionFilters() {
        addExtensionFilters(Set.of(ExtensionFilterType.ALL, ExtensionFilterType.TEXT));
    }

    @Override
    public <VM extends AbstractViewModel> ExtendedFileChooser owner(VM owner) {
        this.owner = owner.getAssociatedScene().getWindow();
        return this;
    }

    @Override
    public ExtendedFileChooserImpl addExtensionFilters(Set<ExtensionFilter> filterTypes) {
        filterTypes.stream().forEachOrdered(fileChooser.getExtensionFilters()::add);
        return this;
    }

    @Override
    public Optional<File> openFile() {
        return Optional.ofNullable(fileChooser.showOpenDialog(owner));
    }

    @Override
    public Optional<File> saveFile() {
        return Optional.ofNullable(fileChooser.showSaveDialog(owner));
    }
}
