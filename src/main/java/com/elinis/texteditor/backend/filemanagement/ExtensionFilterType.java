package com.elinis.texteditor.backend.filemanagement;

public enum ExtensionFilterType {

    ALL("."), TEXT(".txt"), LOG(".log");

    private String extension;

    ExtensionFilterType(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
