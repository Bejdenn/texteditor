package com.elinis.texteditor.frontend.view.i18n;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Base implementation of {@link TranslationProvider}.
 */
@Service
public class TranslationProviderImpl implements TranslationProvider {

    private static final Logger LOGGER = LogManager.getLogger();

    private final String bundlePath;
    private final Locale locale;
    private final ResourceBundle translationBundle;

    @Autowired
    public TranslationProviderImpl() {
        bundlePath = "com.elinis.texteditor.i18n.TranslationResources";
        locale = new Locale("de");
        translationBundle = ResourceBundle.getBundle(bundlePath, locale);
    }

    @Override
    public String getTranslation(final Class<?> clazz, final String resourceKey) {
        return findTranslationInBundle(clazz.getSimpleName(), resourceKey);
    }

    @Override
    public String getTranslation(final String namespace, final String resourceKey) {
        return findTranslationInBundle(namespace, resourceKey);
    }

    private String findTranslationInBundle(final String namespace, final String resourceKey) {
        Objects.requireNonNull(namespace, "Namespace cannot be null");
        Objects.requireNonNull(resourceKey, "ResourceKey cannot be null");

        final StringBuilder builder =
                new StringBuilder().append(namespace).append(".").append(resourceKey);

        try {
            return translationBundle.getString(builder.toString());
        } catch (final MissingResourceException ex) {
            LOGGER.error("No translation found for key: " + builder.toString());
            return "[" + builder.toString() + "]";
        }
    }
}
