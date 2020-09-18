package com.elinis.texteditor.filemanagement;

import javafx.stage.FileChooser.ExtensionFilter;

/**
 * Holds all extension filter that a file choose can apply. Mainly used at the configuration of a
 * {@link ExtendedFileChooser}.
 */
public class ExtensionFilterType {

    /** Includes all files. **/
    public static final ExtensionFilter ALL = new ExtensionFilter("Alle Dateien", ".");

    /** Includes all text files. **/
    public static final ExtensionFilter TEXT = new ExtensionFilter("Textdateien", ".txt");

    /** Includes all Log files. **/
    public static final ExtensionFilter LOG = new ExtensionFilter("Logdateien", ".log");

    static ExtensionFilter getFilter(ExtensionFilter filter) {
        return filter;
    }
}
