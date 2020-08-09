package com.elinis.texteditor.frontend;

import com.elinis.texteditor.frontend.view.service.ViewService;
import com.google.inject.Provides;
import de.saxsys.mvvmfx.guice.internal.MvvmfxModule;

public class FrontendModule extends MvvmfxModule {

    @Provides
    static ViewService viewService() {
        return new ViewService();
    }
}
