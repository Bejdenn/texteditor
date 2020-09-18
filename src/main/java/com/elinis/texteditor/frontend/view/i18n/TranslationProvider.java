package com.elinis.texteditor.frontend.view.i18n;

/**
 * Describes how an implementing class should structure translation providing methods for a
 * requesting class.The implementing class has to guarantee of returning anything but a empty
 * string, so that the consumer gets some acceptable fallback string.
 */
public interface TranslationProvider {

    /**
     * Returns the translation as a string by searching for the given resource key. The name space
     * is defined by the given {@link Class}.
     * 
     * @param clazz a class instance, usually the one requesting a translation
     * @param resourceKey the key to search for
     * @return
     */
    public abstract String getTranslation(Class<?> clazz, String resourceKey);

    /**
     * Returns the translation as a string by searching for the given resource key. The name space
     * is defined by the given name space.
     * 
     * @param namespace
     * @param resourceKey the key to search for
     * @return a translation
     */
    public abstract String getTranslation(String namespace, String resourceKey);
}
