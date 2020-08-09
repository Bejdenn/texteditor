package com.elinis.texteditor.frontend.editor;

import com.elinis.texteditor.frontend.view.AbstractViewModel;
import com.elinis.texteditor.frontend.view.interaction.ViewModelAction;
import de.saxsys.mvvmfx.utils.commands.Command;
import de.saxsys.mvvmfx.utils.commands.DelegateCommand;

public class EditorViewModel extends AbstractViewModel {
   
    private Command startNewFileCommand;
    private Command openNewFileCommand;
    private Command saveFileCommand;
    private Command saveFileAsCommand;
    private Command printFileCommand;

    public void initialize() {
        startNewFileCommand = new DelegateCommand(() -> new ViewModelAction(this::startNewFile));
        openNewFileCommand = new DelegateCommand(() -> new ViewModelAction(this::openNewFile));
        saveFileCommand = new DelegateCommand(() -> new ViewModelAction(this::saveFile));
        saveFileAsCommand = new DelegateCommand(() -> new ViewModelAction(this::saveFileAs));
        printFileCommand = new DelegateCommand(() -> new ViewModelAction(this::printFile));
    }

    private void startNewFile() {

    }

    private void openNewFile() {

    }

    private void saveFile() {

    }

    private void saveFileAs() {

    }

    private void printFile() {
        System.out.println("Print");
    }

    Command getStartNewFileCommand() {
        return startNewFileCommand;
    }

    Command getOpenNewFileCommand() {
        return openNewFileCommand;
    }

    Command getSaveFileCommand() {
        return saveFileCommand;
    }

    Command getSaveFileAsCommand() {
        return saveFileAsCommand;
    }

    Command getPrintFileCommand() {
        return printFileCommand;
    }
}
