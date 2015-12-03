package me.ryleykimmel.advent;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public final class FileUtil {

	private static final String DATA_DIRECTORY = "data";

	public static String readInput(String title) {
		return readAllLines(title).stream().collect(Collectors.joining());
	}

	public static List<String> readAllLines(String title) {
		try {
			return Files.readAllLines(Paths.get(DATA_DIRECTORY).resolve(title + ".txt"));
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	private FileUtil() {
	}

}