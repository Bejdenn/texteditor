package com.elinis.texteditor.client.view.i18n;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Locale;
import org.junit.BeforeClass;
import org.junit.Test;
import com.elinis.texteditor.frontend.view.i18n.BaseTranslationProvider;

public class TranslationResourcesTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        BaseTranslationProvider.initializeWith(new Locale("de"),
                "com.elinis.texteditor.client.view.i18n.TestApplicationResources");
    }

    @Test
    public void test_setLocale() {
        // GIVEN
        String localeLanguage = "de";

        // WHEN
        // See TranslationResource#setUpBeforeClass

        // THEN
        assertThat(BaseTranslationProvider.getBundleLocale().getLanguage(), is(localeLanguage));
    }

    @Test
    public void test_getString() {
        // GIVEN
        String expectedTranslation = "Übersetzungstest";
        String key = "TestResourceClass";
        String subKey = "TranslationTest";

        // WHEN
        // See TranslationResource#setUpBeforeClass

        // THEN
        assertThat(BaseTranslationProvider.getTranslation(key, subKey), is(expectedTranslation));
    }
}
