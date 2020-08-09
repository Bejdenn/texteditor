package com.elinis.texteditor.frontend.view.component;

import javafx.scene.Node;

public abstract class Component<T> extends Node {

    /**
     * Initializes the given component type.
     * 
     * @return an instance of the component type
     */
    protected abstract T initialize();

    public T get() {
        return initialize();
    }

}
