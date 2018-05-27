package javari.reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * This class represents the base class for reading all lines from a text
 * file that contains CSV data.
 *
 * @author Programming Foundations 2 Teaching Team
 * @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
 */

public class CsvReader {

    public static final String COMMA = ",";
    private final Path file;
    private final List<String> lines;

    /**
     * Defines the base constructor for instantiating an object of
     * {@code CsvReader}.
     *
     * @param file path object referring to a CSV file
     * @throws IOException if given file is not present or cannot be read
     *     properly
     */

    public CsvReader(Path file) throws IOException {
        this.file = file;
        this.lines = Files.readAllLines(this.file, StandardCharsets.UTF_8);
    }

    /**
     * Returns all line of text from CSV file as a list.
     *
     * @return
     */

    public List<String> getLines() {
        return lines;
    }
}
