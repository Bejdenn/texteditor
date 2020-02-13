package org.bejdenn.dexteditor.client.component;

import org.bejdenn.dexteditor.client.Util;

import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;

public class CustomMenuBar extends MenuBar {

    public CustomMenuBar() {
        this.createDataMenu();
        this.createEditMenu();
        this.createFormatMenu();
        this.createHelpMenu();

    }

    private void createDataMenu() {
        Menu dateMenu = new Menu("Datei");

        MenuItem createNewTextMItem = new MenuItem("Neu");
        createNewTextMItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        createNewTextMItem.setOnAction(e -> Util.createNewText());

        MenuItem openFileMItem = new MenuItem("ffnen");
        openFileMItem.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        openFileMItem.setOnAction(e -> Util.openFile());

        MenuItem saveFileMItem = new MenuItem("Speichern");
        saveFileMItem.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        saveFileMItem.setOnAction(e -> Util.saveFile());

        MenuItem saveAsMItem = new MenuItem("Speichern unter");
        saveAsMItem.setOnAction(e -> Util.saveFileAs());

        MenuItem printFileMItem = new MenuItem("Drucken");
        printFileMItem.setAccelerator(KeyCombination.keyCombination("Ctrl+P"));
        printFileMItem.setOnAction(e -> {

        });

        SeparatorMenuItem separator1 = new SeparatorMenuItem();
        SeparatorMenuItem separator2 = new SeparatorMenuItem();

        MenuItem closeAppMItem = new MenuItem("Beenden");
        closeAppMItem.setOnAction(e -> {
            Util.closeApp();
        });

        dateMenu.getItems().addAll(createNewTextMItem, openFileMItem, saveFileMItem, saveAsMItem, separator1,
                printFileMItem, separator2, closeAppMItem);
        this.getMenus().add(dateMenu);
    }

    private void createEditMenu() {
        Menu editMenu = new Menu("Bearbeiten");

        MenuItem undoChangeMItem = new MenuItem("Rckgangig");
        undoChangeMItem.setAccelerator(KeyCombination.keyCombination("Ctrl+Z"));
        undoChangeMItem.setOnAction(e -> {
            Util.undoChange();
        });

        SeparatorMenuItem separator3 = new SeparatorMenuItem();

        MenuItem cutTextMItem = new MenuItem("Ausschneiden");
        cutTextMItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        cutTextMItem.setOnAction(e -> {
            Util.cutText();
        });

        MenuItem copyTextMItem = new MenuItem("Kopieren");
        copyTextMItem.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        copyTextMItem.setOnAction(e -> {
            Util.copyText();
        });

        MenuItem pasteTextMItem = new MenuItem("Einfgen");
        pasteTextMItem.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));
        pasteTextMItem.setOnAction(e -> {
            Util.pasteText();
        });

        editMenu.getItems().addAll(undoChangeMItem, separator3, cutTextMItem, copyTextMItem, pasteTextMItem);
        this.getMenus().add(editMenu);
    }

    private void createFormatMenu() {
        Menu formatMenu = new Menu("Format");

        CheckMenuItem breakLineMItem = new CheckMenuItem("Zeilenumbruch");
        breakLineMItem.setOnAction(e -> {
            Util.isBreakingLine(breakLineMItem.isSelected());
        });

        MenuItem changeFontMItem = new MenuItem("Schriftart");
        changeFontMItem.setOnAction(e -> {

        });

        formatMenu.getItems().addAll(breakLineMItem, changeFontMItem);
        this.getMenus().add(formatMenu);
    }

    private void createHelpMenu() {
        Menu helpMenu = new Menu("Hilfe");
        MenuItem showInfoMItem = new MenuItem("Info");

        showInfoMItem.setOnAction(e -> {
            Util.openInternetPage();
        });
        helpMenu.getItems().addAll(showInfoMItem);
        this.getMenus().add(helpMenu);
    }

}
