package io.hexlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FixtureReader {
    public static String readFromFile(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Path.of(filePath));
        return new String(bytes);
    }
}
