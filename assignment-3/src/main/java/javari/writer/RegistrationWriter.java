package javari.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javari.animal.Animal;
import javari.park.Registration;
import javari.park.SelectedAttraction;

import org.json.JSONWriter;

/**
 * This class handles saving data of registered attractions into JSON file.
 *
 * @author Programming Foundations 2 Teaching Team
 * @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
 */

public class RegistrationWriter {

    private static final String DEFAULT_FILENAME_FMT =
            "registration_%s.json";

    /**
     * Writes visitor's registration data into JSON file.
     *
     * <p>Hint: You can follow the similar approach in this method to implement
     * your own JSON writing methods that accept multiple registration objects.</p>
     *
     * @param registration  instance of registration that contains attractions
     *                      that will be watched by visitor
     * @param directory     the directory where JSON file will be written
     * @throws IOException  when JSON file cannot be written
     */
    
    public static void writeJson(Registration registration,
                                 Path directory) throws IOException {
        String fileName = String.format(DEFAULT_FILENAME_FMT,
                registration.getVisitorName());
        String jsonFileName = fileName.replace(" ", "_");
        Path jsonFile = directory.resolve(jsonFileName);
        BufferedWriter fileWriter = Files.newBufferedWriter(jsonFile,
                StandardCharsets.UTF_8);
        final JSONWriter writer = new JSONWriter(fileWriter);

        // Note: JSONWriter is following Builder design pattern
        // to provide a "fluent-style" JSON file creation
        writer.array();
        buildRegistration(writer, registration);
        writer.endArray();

        System.out.println("... End of program, write to "
                + jsonFile.getFileName().toString());

        // Ensure JSON text are flushed out from internal buffer
        // into the actual file
        fileWriter.flush();
        fileWriter.close();
    }

    /**
     * Uses call-by-reference to write content of registration using
     * given instance of JsonWriter.
     *
     * @param writer        an instance of JSONWriter passed by reference
     * @param registration  registration object
     */
    private static void buildRegistration(JSONWriter writer,
                                          Registration registration) {
        writer.object()
                .key("registration_id").value(registration.getRegistrationId())
                .key("name").value(registration.getVisitorName())
                .key("attractions").array();

        registration.getSelectedAttractions().forEach(attraction ->
                buildAttraction(writer, attraction)
        );

        writer.endArray().endObject();
    }

    /**
     * Uses call-by-reference to write an instance of selected attraction into
     * intermediate result of JSON file writing.
     *
     * @param writer        instance of JSONWriter containing intermediate result
     * @param attraction    an attraction that will be watched by visitor according
     *                      to the registration info
     */
    private static void buildAttraction(JSONWriter writer,
                                        SelectedAttraction attraction) {
        String type = attraction.getType();
        writer.object()
                .key("name").value(attraction.getName())
                .key("type").value(type);

        buildPerformers(writer,
                attraction.getPerformers());

        writer.endObject();
    }

    /**
     * Uses call-by-reference to write list of animal performers into
     * intermediate result of JSON writing.
     *
     * @param writer    instance of JSONWriter containing intermediate result
     *                  of JSON writing
     * @param animals   list of animals that perform in the attraction
     */
    private static void buildPerformers(JSONWriter writer,
                                        List<Animal> animals) {
        writer.key("animals").array();
        animals.forEach(animal -> buildPerformer(writer, animal));
        writer.endArray();
    }

    /**
     * Uses call-by-reference to write an animal into intermediate result
     * of JSON writing.
     *
     * @param writer    instance of JSONWriter containing intermediate result
     *                  of JSON writing
     * @param animal    an instance of animal that will perform in an attraction
     */
    private static void buildPerformer(JSONWriter writer,
                                       Animal animal) {
        writer.object()
                .key("name").value(animal.getName())
                .endObject();
    }
}
