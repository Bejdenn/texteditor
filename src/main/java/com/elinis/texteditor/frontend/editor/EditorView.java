package com.elinis.texteditor.frontend.editor;

import com.elinis.texteditor.frontend.view.AbstractView;
import com.elinis.texteditor.frontend.view.component.menubar.MenuBarBuilder;
import com.elinis.texteditor.frontend.view.component.textarea.EditorTextArea;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.scene.control.MenuBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;

/**
 * The initial and currently only view of the application. It adds a special editor text area to the
 * {@link AbstractView}.
 */
public class EditorView extends AbstractView<EditorViewModel> {

    @InjectViewModel
    private EditorViewModel viewModel;

    @Override
    public void initializeGUI() {
        EditorTextArea customTextArea = new EditorTextArea();
        setTop(createMenuBar());
        setCenter(customTextArea);
    }

    protected MenuBar createMenuBar() {
        //@formatter:off
        return MenuBarBuilder
            .newMenuBar()
                .newMenu("Datei")
                    .newMenuItem(getTranslation("newFile"))
                        .withCommand(getViewModel().getOpenNewFileCommand())
                        .withKeyCombination(KeyCombination.CONTROL_DOWN, KeyCode.N)
                    .buildMenuItem()
                    .newMenuItem(getTranslation("openFile"))
                        .withCommand(getViewModel().getOpenNewFileCommand())
                        .withKeyCombination(KeyCombination.CONTROL_DOWN, KeyCode.O)
                    .buildMenuItem()
                    .newMenuItem(getTranslation("saveFile"))
                        .withCommand(getViewModel().getSaveFileCommand())
                        .withKeyCombination(KeyCombination.CONTROL_DOWN, KeyCode.S)
                    .buildMenuItem()
                    .newMenuItem(getTranslation("saveFileAs"))
                        .withCommand(getViewModel().getSaveFileAsCommand())
                        .withKeyCombination(KeyCombination.CONTROL_DOWN, KeyCode.S)
                    .buildMenuItem()
                    .newMenuItem(getTranslation("printFile"))
                        .withCommand(getViewModel().getPrintFileCommand())
                        .withKeyCombination(KeyCombination.CONTROL_DOWN, KeyCode.P)
                    .buildMenuItem()
                .buildMenu()
            .buildMenuBar();
        //@formatter:on
    }

    @Override
    protected EditorViewModel getViewModel() {
        return viewModel;
    }
}
