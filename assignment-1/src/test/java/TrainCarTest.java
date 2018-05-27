import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("A train car")
class TrainCarTest {

    private static final double DELTA = 0.1;

    private OutputStream out;
    private WildCat firstCat;
    private TrainCar firstCar;

    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();
        firstCat = createTestCat("ALICE");
        firstCar = new TrainCar(firstCat);
    }

    @Test
    @DisplayName("can compute total weight of firstCar and its content")
    void testComputeTotalWeight() {
        firstCat.weight = 11;

        assertEquals(TrainCar.EMPTY_WEIGHT + 11, firstCar.computeTotalWeight());
    }

    @Test
    @DisplayName("can compute total mass index of a cat in the firstCar")
    void testComputeTotalMassIndex() {
        when(firstCat.computeMassIndex()).thenCallRealMethod();
        firstCat.weight = 50;
        firstCat.length = 150;

        assertEquals(22.22, firstCar.computeTotalMassIndex(), DELTA);
    }

    @Test
    @DisplayName("can display the cat stored in the firstCar")
    void testPrintCar() {
        System.setOut(new PrintStream(out));

        firstCar.printCar();
        String output = out.toString().trim();

        assertTrue(output.endsWith("(ALICE)"));
    }

    @AfterEach
    void tearDown() throws IOException {
        out.close();
    }

    private static WildCat createTestCat(String name) {
        WildCat cat = mock(WildCat.class);
        cat.name = name;

        return cat;
    }

    @Nested
    @DisplayName("with another car")
    class TwoCarsTest {

        private WildCat secondCat;
        private TrainCar secondCar;

        @BeforeEach
        void setUp() {
            secondCat = createTestCat("BOB");
            secondCar = new TrainCar(secondCat, firstCar);
        }

        @Test
        @DisplayName("can display both cats")
        void testPrintBothCats() {
            System.setOut(new PrintStream(out));

            secondCar.printCar();
            String output = out.toString().trim();

            assertTrue(output.endsWith("(ALICE)"));
            assertTrue(output.contains("(BOB)"));
        }

        @Test
        @DisplayName("can compute total weight of all cars")
        void testComputeTotalWeight() {
            firstCat.weight = 10;
            secondCat.weight = 20;

            assertEquals((TrainCar.EMPTY_WEIGHT * 2) + 30, secondCar.computeTotalWeight());
        }

        @Test
        @DisplayName("can compute total mass index of both cats")
        void testComputeTotalMassIndex() {
            when(firstCat.computeMassIndex()).thenReturn(22.22);
            when(secondCat.computeMassIndex()).thenReturn(18.00);

            assertEquals(40.22, secondCar.computeTotalMassIndex());
        }
    }

    @Nested
    @DisplayName("internally")
    class InternalTest {

        private Class<?> carClass;
        private List<Field> carVariables;

        @BeforeEach
        void setUp() throws ClassNotFoundException {
            carClass = Class.forName(TrainCar.class.getName());
            carVariables = Arrays.asList(carClass.getDeclaredFields());
        }

        @Test
        @DisplayName("contains an instance variable to store reference to next car")
        void testHasVariableReferencingNextCar() {
            Optional<Field> foundVariable = carVariables.stream()
                    .filter(variable -> !Modifier.isStatic(variable.getModifiers()))
                    .filter(variable -> TrainCar.class.equals(variable.getType()))
                    .findFirst();

            assertTrue(foundVariable.isPresent());
        }

        @Test
        @DisplayName("contains an instance variable to store reference to a cat")
        void testHasVariableReferencingACat() {
            Optional<Field> foundVariable = carVariables.stream()
                    .filter(variable -> !Modifier.isStatic(variable.getModifiers()))
                    .filter(variable -> WildCat.class.equals(variable.getType()))
                    .findFirst();

            assertTrue(foundVariable.isPresent());
        }
    }
}