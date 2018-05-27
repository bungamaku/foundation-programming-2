import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("A wild cat")
class WildCatTest {

    private static final double DELTA = 0.1;

    private WildCat cat;
    private WildCat anotherCat;

    @BeforeEach
    void setUp() {
        cat = new WildCat("ALICE",  50.0, 150.0);
        anotherCat = new WildCat("BOB", 60.0, 140.0);
    }

    @Test
    @DisplayName("has name")
    void testHasName() {
        assertEquals("ALICE", cat.name);
        assertEquals("BOB", anotherCat.name);
    }

    @Test
    @DisplayName("has weight")
    void testHasWeight() {
        assertEquals(50.0, cat.weight, DELTA);
        assertEquals(60.0, anotherCat.weight, DELTA);
    }

    @Test
    @DisplayName("has length")
    void testHasLength() {
        assertEquals(150.0, cat.length, DELTA);
        assertEquals(140.0, anotherCat.length, DELTA);
    }

    @Test
    @DisplayName("can compute mass index")
    void testComputeMassIndex() {
        assertEquals(22.22, cat.computeMassIndex(), DELTA);
        assertEquals(30.6, anotherCat.computeMassIndex(), DELTA);
    }
}