package com.elinis.texteditor.frontend.view.i18n;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.ResourceBundle;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Base implementation of {@link TranslationProvider}.
 */
public class BaseTranslationProvider {

    private static final Logger LOGGER = LogManager.getLogger(BaseTranslationProvider.class);

    // TODO remove this hardcoded bundle name; let the provider read it from a properties file or
    // create an optional method
    static final String BASE_BUNDLE_NAME = "com.elinis.texteditor.i18n.TranslationResources";

    static ResourceBundle loadedBundle;

    private BaseTranslationProvider() {
        // only static access
    }

    public static void initializeWith(Locale locale, String optionalBundleName) {
        loadedBundle = ResourceBundle.getBundle(
                StringUtils.isEmpty(optionalBundleName) ? BASE_BUNDLE_NAME : optionalBundleName,
                locale);
    }

    public static String getTranslation(Class<?> clazz, String resourceKey) {
        Objects.requireNonNull(clazz, () -> "Clazz cannot be null");
        return getTranslatedString(clazz.getSimpleName(), resourceKey);
    }

    public static String getTranslation(String namespace, String resourceKey) {
        return getTranslatedString(namespace, resourceKey);
    }

    private static String getTranslatedString(String namespace, String resourceKey) {
        String key = namespace.concat(".").concat(resourceKey);

        String translation;
        try {
            translation = loadedBundle.getString(key);
        } catch (MissingResourceException ex) {
            translation = "[" + key + "]";
            LOGGER.error("No translation found for key: " + key);
        }

        return translation;
    }

    /**
     * Returns the locale of the corresponding resource bundle.
     * 
     * @return the current locale
     */
    public static Locale getBundleLocale() {
        return loadedBundle.getLocale();
    }
}
