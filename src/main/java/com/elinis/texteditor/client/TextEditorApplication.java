package com.elinis.texteditor.client;

import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import com.elinis.texteditor.frontend.view.i18n.BaseTranslationProvider;

public class TextEditorApplication {

    private TextEditorApplication() {
        // hide public constructor
    }

    /**
     * Main method of the client.
     * 
     * @param args
     *            Command line arguments
     */
    public static void main(String[] args) {
        BaseTranslationProvider.initializeWith(new Locale("de"), StringUtils.EMPTY);
        TextEditorClient.main(args);
    }
}
