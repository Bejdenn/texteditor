package org.bejdenn.dexteditor.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.bejdenn.dexteditor.client.component.DOptionPane;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileManagerService {

    private File currentFile;
    private static boolean saved;
    private FileChooser fileChooser;
    private Stage stage = ExecutiveClass.getPrimaryStage();

    public FileManagerService() {
        fileChooser = new FileChooser();
        saved = false;
        //@formatter:off
        List<FileChooser.ExtensionFilter> extensionFilters = new FileChooserExtensionFilterFactory()
                .getAllFilesFilter()
                .getJavaFileFilter()
                .getHTMLFileFilter()
                .getLogFileFilter()
                .getTextFileFilter()
                .build();
        //@formatter:on
        this.setUpExtensionFilter(extensionFilters);
    }

    private void setUpExtensionFilter(List<FileChooser.ExtensionFilter> extensionFilters) {
        fileChooser.getExtensionFilters().addAll(extensionFilters);
    }

    public void openFile() {
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            readFile(file);
            saved = true;
        }
    }

    public void saveFileAt() {
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            this.saveFile(file);
            ExecutiveClass.setFileName(file.getName());
            currentFile = file;
            saved = true;
        }
    }

    public void fastFileSave() {
        if (currentFile == null) {
            this.saveFileAt();
        } else {
            this.saveFile(currentFile);
        }
    }

    private void readFile(File file) {
        try {
            Stream<String> lines = Files.lines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
            ExecutiveClass.getCustomTextArea().setText("");
            lines.forEach(s -> {
                ExecutiveClass.getCustomTextArea().appendText(s);
                if (!(s.equals(null))) {
                    ExecutiveClass.getCustomTextArea().appendText("\n");
                }
            });
            ExecutiveClass.setFileName(file.getName());
            currentFile = file;
            lines.close();

        } catch (UncheckedIOException | IOException ex) {
            DOptionPane.showError("Lesefehler", "Datei konnte nicht gelesen werden. "
                    + "Sie beinhaltet mglicherweise nicht lesbare Zeichen oder liegt in einem nicht untersttzen Format vor.");
        }
    }

    private void saveFile(File file) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
            for (String line : ExecutiveClass.getContent().split("\\n")) {
                writer.println(line);
            }
            saved = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    public String checkConditions() {
        if (saved == true) {
            currentFile = null;
            return DOptionPane.SPEICHERN;
        }
        if (ExecutiveClass.getContent().equals("")) {
            if (this.getCurrentFile() == null) {
                return DOptionPane.NICHT_SPEICHERN;
            }
        }
        return "No conditions";
    }

    public String throwSaveWarning() {
        String file = "";
        if (currentFile == null) {
            file = "Unbenannt";
        } else {
            file = this.getCurrentFile().getName();
        }
        String decision = DOptionPane.showWarning("DNotepad", "Mchten Sie die nderungen an " + file + " speichern?");

        switch (decision) {
            case DOptionPane.ABBRECHEN:
                return DOptionPane.ABBRECHEN;
            case DOptionPane.SPEICHERN:
                if (saved == false) {
                    this.saveFileAt();
                    if (saved != true) {
                        return DOptionPane.ABBRECHEN;
                    }
                    currentFile = null;
                    return DOptionPane.SPEICHERN;
                } else if (this.isSaved() == true) {
                    this.fastFileSave();
                    currentFile = null;
                    return DOptionPane.SPEICHERN;
                }
                return DOptionPane.ABBRECHEN;
            case DOptionPane.NICHT_SPEICHERN:
                currentFile = null;
                return DOptionPane.NICHT_SPEICHERN;
            default:
                return "Fehler";
        }
    }

    public boolean isSaved() {
        return saved;
    }

    public static void setSaved(boolean Tsaved) {
        saved = Tsaved;
    }

    public File getCurrentFile() {
        return currentFile;
    }
}
