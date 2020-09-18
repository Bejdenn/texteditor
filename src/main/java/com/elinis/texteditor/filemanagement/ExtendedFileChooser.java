package com.elinis.texteditor.filemanagement;

import java.io.File;
import java.util.Optional;
import java.util.Set;
import com.elinis.texteditor.frontend.view.AbstractViewModel;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * Describes how an extended {@link FileChooser} implementation should behave.
 */
public interface ExtendedFileChooser {

    /**
     * Registers the window where the file chooser was called from. This is necessary to block any
     * interaction in the owner window while the chooser is active.
     * 
     * @param <VM> the view model class
     * @param owner the view model that calls the file chooser
     * @return the file chooser
     */
    <VM extends AbstractViewModel> ExtendedFileChooser owner(VM owner);

    /**
     * Adds extension filters to the {@link FileChooser}.
     * 
     * @param filterTypes the filter types that should be added
     * @return the file chooser
     */
    ExtendedFileChooser addExtensionFilters(Set<ExtensionFilter> filterTypes);

    /**
     * Opens a {@link FileChooser} and returns an {@link Optional} with the {@link File}, if any was
     * selected. Otherwise (or if an exception occurs) the caller will get an empty Optional.
     * 
     * @return an optional with the chosen file or an empty optional
     */
    Optional<File> openFile();

    /**
     * Opens a {@link FileChooser} and returns an {@link Optional} with the newly created
     * {@link File} or an existing one.
     * 
     * <p>
     * <b> NOTE</b>: This process only creates or loads an file. Other means (like writing/appending
     * new text content to the file) have to be done separately.
     * 
     * @return the file
     */
    Optional<File> saveFile();
}
