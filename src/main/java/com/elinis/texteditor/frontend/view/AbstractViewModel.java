package com.elinis.texteditor.frontend.view;

import de.saxsys.mvvmfx.ViewModel;

public abstract class AbstractViewModel implements ViewModel {

    /**
     * This method can be used to initialize something after the view model is injected by the
     * MvvmFx framework.
     */
    public void initialize() {
        // empty because overriding this method is optional
    }
}
