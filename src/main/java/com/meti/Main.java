package com.meti;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.*;

public class Main {
    public static final String RESOURCES = "resources";
    public static final String JAVA = "java";
    private static final Path source = Paths.get(".", "src");

    public void run() {
        try {
            Path main = source.resolve("main");
            createDirectories(main.resolve(JAVA));
            createDirectories(main.resolve(RESOURCES));
            Path test = source.resolve("test");
            createDirectories(test.resolve(JAVA));
            createDirectories(test.resolve(RESOURCES));
            createDirectories(Paths.get(".", "target"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
