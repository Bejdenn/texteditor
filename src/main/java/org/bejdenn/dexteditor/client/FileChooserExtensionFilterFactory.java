package org.bejdenn.dexteditor.client;

import java.util.List;

import javafx.stage.FileChooser;

public class FileChooserExtensionFilterFactory {

    private List<FileChooser.ExtensionFilter> extensionFilters;

    public FileChooserExtensionFilterFactory() {

    }

    public FileChooserExtensionFilterFactory getAllFilesFilter() {
        extensionFilters.add(new FileChooser.ExtensionFilter(ApplicationConstants.EXTENSION_FILTER_ALL, "*.*"));
        return this;
    }

    public FileChooserExtensionFilterFactory getTextFileFilter() {
        extensionFilters.add(new FileChooser.ExtensionFilter(ApplicationConstants.EXTENSION_FILTER_TEXT, "*.txt"));
        return this;
    }

    public FileChooserExtensionFilterFactory getJavaFileFilter() {
        extensionFilters.add(new FileChooser.ExtensionFilter(ApplicationConstants.EXTENSION_FILTER_JAVA, "*.java"));
        return this;
    }

    public FileChooserExtensionFilterFactory getHTMLFileFilter() {
        extensionFilters.add(new FileChooser.ExtensionFilter(ApplicationConstants.EXTENSION_FILTER_HTML, "*.html"));
        return this;
    }

    public FileChooserExtensionFilterFactory getLogFileFilter() {
        extensionFilters.add(new FileChooser.ExtensionFilter(ApplicationConstants.EXTENSION_FILTER_LOG, "*.log"));
        return this;
    }

    public List<FileChooser.ExtensionFilter> build() {
        return extensionFilters;
    }

}
