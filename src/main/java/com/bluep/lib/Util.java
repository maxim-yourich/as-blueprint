package com.bluep.lib;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Util {
    public static void copyPasteDirectory(Path src, Path dst) throws IOException {
        Files.walk(src)
                .forEach(source -> {
                    Path destination = Paths.get(
                            String.valueOf(dst),
                            source.toString().substring(String.valueOf(src).length())
                    );

                    try {
                        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
