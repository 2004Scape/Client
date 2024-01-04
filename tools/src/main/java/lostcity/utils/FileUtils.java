package lostcity.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

public class FileUtils {
    public static Collection<File> listFiles(File directory, String[] extensions, boolean recursive) {
        Collection<File> files = new ArrayList<>();

        if (directory.isDirectory()) {
            File[] found = directory.listFiles();

            for (int i = 0; i < found.length; i++) {
                File file = found[i];
                if (file.isDirectory()) {
                    if (recursive) {
                        files.addAll(listFiles(file, extensions, recursive));
                    }
                } else {
                    for (int j = 0; j < extensions.length; j++) {
                        String extension = extensions[j];
                        if (file.getName().endsWith(extension)) {
                            files.add(file);
                        }
                    }
                }
            }
        }

        return files;
    }

    public static String readFileToString(File file) throws IOException {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return new String(encoded, StandardCharsets.UTF_8);
    }

    public static void writeStringToFile(File file, String contents) throws IOException {
        Files.write(Paths.get(file.toURI()), contents.getBytes(StandardCharsets.UTF_8));
    }
}
