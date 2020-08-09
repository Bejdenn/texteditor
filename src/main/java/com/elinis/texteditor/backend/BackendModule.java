package com.elinis.texteditor.backend;

import com.elinis.texteditor.backend.filemanagement.ExtendedFileChooser;
import com.elinis.texteditor.backend.filemanagement.FileManagementService;
import com.google.inject.Provides;
import de.saxsys.mvvmfx.guice.internal.MvvmfxModule;

public class BackendModule extends MvvmfxModule {

    @Provides
    static ExtendedFileChooser extendedFileChooser() {
        return new ExtendedFileChooser();
    }

    @Provides
    static FileManagementService fileManagementService(ExtendedFileChooser extendedFileChooser) {
        return new FileManagementService(extendedFileChooser);
    }
}
