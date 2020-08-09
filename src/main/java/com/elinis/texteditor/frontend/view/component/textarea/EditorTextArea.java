package com.elinis.texteditor.frontend.view.component.textarea;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.TextArea;

/**
 * Simple extension of {@link TextArea}. The difference is the {@link EditorTextArea#textChanged}
 * property that informs a binding of any input made into the text area.
 */
public class EditorTextArea extends TextArea {

    private BooleanProperty textChanged = new SimpleBooleanProperty();

    public EditorTextArea() {
        textProperty().addListener((observable, oldVal, newVal) -> textChanged.set(false));
    }

    protected BooleanProperty textChangedProperty() {
        return textChanged;
    }

}
