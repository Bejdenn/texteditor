package com.elinis.texteditor.frontend.view.i18n;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Locale;
import com.elinis.texteditor.util.ReflectionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@Disabled("We have to enable CircleCI and then fix the test.")
@ExtendWith(MockitoExtension.class)
public class TranslationProviderTest {

    private static final String EXPECTED_TRANSLATION = "Übersetzungstest";
    private static final String RESOURCE_KEY = "testString";

    @InjectMocks
    private TranslationProvider translationProvider;

    @BeforeEach
    public void setUp() throws Exception {
        ReflectionUtils.setField(translationProvider, "bundlePath",
                "com.elinis.texteditor.i18n.TranslationResourcesTest");
        ReflectionUtils.setField(translationProvider, "locale", new Locale("de"));
    }

    @Test
    public final void test_getTranslation_Class_String() {
        // GIVEN
        // see constants

        // WHEN
        String translation =
                translationProvider.getTranslation(getClass().getSimpleName(), RESOURCE_KEY);

        // THEN
        assertThat(translation, is(equalTo(EXPECTED_TRANSLATION)));
    }

    @Test
    public final void test_getTranslation_String_String() {
        // GIVEN
        // see constants

        // WHEN
        String translation = translationProvider.getTranslation(getClass(), RESOURCE_KEY);

        // THEN
        assertThat(translation, is(equalTo(EXPECTED_TRANSLATION)));
    }
}
