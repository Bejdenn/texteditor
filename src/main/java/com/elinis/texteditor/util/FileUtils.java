package com.elinis.texteditor.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.io.FilenameUtils;

/**
 * Utility class for file handling.
 */
public class FileUtils {

    private FileUtils() {
        // only static access is allowed
    }

    public static String getFileNameWithoutPath(File file) {
        return file == null ? "Ohne Titel" : FilenameUtils.getName(file.getName());
    }

    /**
     * Reads the content of a file and returns as a single string.
     * 
     * @param file
     * @return the content of a file
     */
    public static String readFile(File file) {
        Objects.requireNonNull(file, "The given file cannot be null!");
        try {
            return Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8).stream()
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new IllegalStateException("Error while processing file: " + file.getName());
        }
    }

    public static void saveFile(File file, String newContent) {
        Objects.requireNonNull(file, "File cannot be empty or null");
        try (RandomAccessFile stream = new RandomAccessFile(file.getName(), "rw")) {
            FileChannel channel = stream.getChannel();
            String value = newContent;
            byte[] strBytes = value.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
            buffer.put(strBytes);
            buffer.flip();
            channel.write(buffer);
            stream.close();
            channel.close();
        } catch (IOException e) {
            throw new IllegalStateException("Error while writing to file:" + file.getName());
        }
    }
}
