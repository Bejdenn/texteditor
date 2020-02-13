package org.bejdenn.dexteditor.client.editor;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class EditorViewModel {
    private ObjectProperty<String> title;

    public EditorViewModel() {
        title = new SimpleObjectProperty<String>();
    }

    public ObjectProperty<String> titleProperty() {
        return title;
    }
}
