package com.elinis.texteditor.util;

import java.lang.reflect.Field;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class that enable reflective access to type properties.
 */
public class ReflectionUtils {

    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Accesses the instance and sets the field (which will be searched for by the given field name)
     * to the new value.
     * 
     * @param instance the instance to access
     * @param fieldName the field name of the field
     * @param value the new value
     */
    public static void setField(final Object instance, final String fieldName, final Object value) {
        try {
            final Field fieldToAccess = instance.getClass().getDeclaredField(fieldName);
            fieldToAccess.setAccessible(true);
            fieldToAccess.set(instance, value);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
                | SecurityException e) {
            LOGGER.error("Error occured while trying to access field {0} of type {0}.", fieldName,
                    instance.getClass().getSimpleName());
        }
    }
}
