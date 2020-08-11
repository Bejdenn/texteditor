package com.elinis.texteditor.backend.filemanagement;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javafx.stage.FileChooser;

public class ExtendedFileChooser {

    private static FileChooser fileChooser;

//    private void setDefaultProps() {
//        fileChooser = new FileChooser();
//        setExtensionFilters(ExtensionFilterType.ALL, ExtensionFilterType.TEXT);
//    }

    public void setExtensionFilters(ExtensionFilterType... extensionFilterTypes) {
        List<FileChooser.ExtensionFilter> extensionFilters = Arrays.stream(extensionFilterTypes)
                .map(filter -> new FileChooser.ExtensionFilter(filter.toString(),
                        filter.getExtension()))
                .collect(Collectors.toList());
        fileChooser.getExtensionFilters().addAll(extensionFilters);
    }

    public Optional<File> openFile() {
        File file = fileChooser.showOpenDialog(null);
        if (file == null) {
            return Optional.empty();
        }

        return Optional.of(file);

    }


}
