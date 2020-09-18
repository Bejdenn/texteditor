package com.elinis.texteditor.frontend.view;

public enum PresentationType {
    VIEW(625, 750), DIALOG(600, 425);

    private double height;
    private double width;

    private PresentationType(final double height, final double width) {
        this.height = height;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
