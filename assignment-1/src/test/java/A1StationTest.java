import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Assignment 1 program")
class A1StationTest {

    private OutputStream out;

    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();

        System.setOut(new PrintStream(out));
    }

    @Test
    @DisplayName("runs correctly given 1 cat to transport")
    void testSingleInput() {
        // Based on setup procedure used in Prog. Found. 2 tutorial 3
        InputStream input = new ByteArrayInputStream("1\nOcelot,25,50\n".getBytes());
        System.setIn(input);

        A1Station.main(new String[0]);
        String output = out.toString();

        assertTimeout(Duration.ofSeconds(1), () -> output.contains("[LOCO]<--(Ocelot)"));
    }

    @AfterEach
    void tearDown() throws IOException {
        out.close();
    }
}
