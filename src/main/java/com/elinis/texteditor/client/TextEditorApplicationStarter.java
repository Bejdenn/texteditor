package com.elinis.texteditor.client;

import com.elinis.core.commons.ApplicationStarter;
import com.elinis.core.frontend.view.AbstractView;
import com.elinis.core.frontend.view.AbstractViewModel;
import com.elinis.texteditor.frontend.editor.EditorView;

public class TextEditorApplicationStarter extends ApplicationStarter {

    @SuppressWarnings("unchecked")
    @Override
    protected <V extends AbstractView<? extends AbstractViewModel>> Class<V> getStartViewClass() {
        return (Class<V>) EditorView.class;
    }
}
