import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountriesBinaryFile {

	protected static Path path = Paths.get("countries.dat");

	public static void main(String[] args) throws IOException {

		Files.deleteIfExists(path);
		ensureFileExists();
		appendToFile("United States:325,700,000");
		appendToFile("India:1,339,000,000");
		appendToFile("China:1,386,000,000");
		appendToFile("Rwanda:12,210,000");
		
	}

	public static void ensureFileExists() throws IOException {
		if (Files.notExists(path)) {
			Files.createFile(path);
		}
	}

	public static ArrayList<String> readFile() {
		try {
			ArrayList<String> list = (ArrayList<String>) Files.readAllLines(path);
			return list;
		} catch (FileNotFoundException ex) {
			return new ArrayList<>();
		} catch (IOException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

	public static void appendToFile(String line) throws IOException {
		ensureFileExists();
		List<String> linesToAdd = Arrays.asList(line);
		Files.write(path, linesToAdd, StandardOpenOption.APPEND);
	}

	public static void clearFile() throws IOException {
		rewriteFile(Collections.emptyList());
	}

	public static void rewriteFile(List<String> lines) throws IOException {
		ensureFileExists();
		Files.write(path, lines, StandardOpenOption.TRUNCATE_EXISTING);
	}
}
