package com.meti;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.nio.file.Files.createDirectory;
import static java.nio.file.Files.exists;
import static java.text.MessageFormat.format;

public final class Main {
	public static final Logger logger = Logger.getLogger("Scaffold-Init");

	private Main() {
	}

	public static void main(String[] args) {
		run();
	}

	private static void run() {
		Path src = ensure(Paths.get(".", "src"));
		Path main = ensure(src.resolve("main"));
		ensure(main.resolve("java"));
		ensure(main.resolve("resources"));
		Path test = ensure(src.resolve("test"));
		ensure(test.resolve("java"));
		ensure(test.resolve("resources"));
		ensure(Paths.get(".", "target"));
	}

	private static Path ensure(Path source) {
		logger.log(Level.INFO, format("{0} exists? {1}", source, exists(source)));
		if (!exists(source)) {
			logger.log(Level.INFO, String.format("%s will be created.", source));
			try {
				createDirectory(source);
			} catch (IOException e) {
				logger.log(Level.WARNING, String.format("Failed to create %s", source), e);
			}
		}
		return source;
	}
}
