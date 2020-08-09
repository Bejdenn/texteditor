package com.elinis.texteditor.frontend.view;

import com.elinis.texteditor.frontend.view.i18n.BaseTranslationProvider;
import de.saxsys.mvvmfx.Initialize;
import de.saxsys.mvvmfx.JavaView;
import de.saxsys.mvvmfx.ViewModel;
import javafx.scene.layout.BorderPane;

/**
 * Base class for {@link JavaView Views}. Sets some general implementation that should be used
 * across every view.
 * 
 * @param <VM>
 *            The assigned ViewModelBase
 */
public abstract class AbstractView<VM extends AbstractViewModel> extends BorderPane
        implements JavaView<VM> {

    @Initialize
    public final void initialize() {
        initializeGUI();
    }

    /**
     * Initializes custom GUI components in the implementing class. This is useful if you want to
     * add some special elements to a extended view.
     */
    protected void initializeGUI() {
        // empty because overriding this method is optional
    }

    /**
     * Returns the {@link ViewModel} instance associated with the {@link JavaView View} that calls
     * this method.
     * 
     * @return the view model instance
     */
    protected abstract VM getViewModel();

    /**
     * Returns a translation by utilizing the {@link BaseTranslationProvider} and searching for the
     * key <code>className.resourceKey</code>. The class name will be determined by calling
     * {@link Object#getClass()}.
     * 
     * @param resourceKey
     * @return
     */
    public String getTranslation(String resourceKey) {
        return BaseTranslationProvider.getTranslation(getClass(), resourceKey);
    }
}
