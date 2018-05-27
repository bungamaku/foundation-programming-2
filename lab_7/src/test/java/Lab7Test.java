import character.Human;
import character.Magician;
import character.Monster;
import character.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Lab7Test {
    private Player humas;
    private Player magi;
    private Player mons;
    private Player dead;
    private Player wizard;
    private Game game1;
    private ByteArrayOutputStream outContent;
    private ByteArrayOutputStream errContent;
    private Logger logger;

    @BeforeEach
    void init() {
        // inisiasi objek
        // make new ByteArrayOutputStream for output and error output
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();

        humas = new Human("humas", 50);
        magi = new Magician("magi", 150);
        mons = new Monster("mons", 50);
        dead = new Monster("dead", 0);
        wizard = new Magician("wizard", 100);

        System.setOut(new PrintStream(outContent)); // Connect outContent ke System.out
        System.setErr(new PrintStream(errContent)); // Connect errContent ke System.err
    }

    /** Unit testing for players class */
    @Test
    @DisplayName("has name")
    void testHasName() {
        assertEquals("humas", humas.getName());
        assertEquals("magi", magi.getName());
        assertEquals("mons", mons.getName());
    }

    @Test
    @DisplayName("has hp")
    void testHasHp() {
        assertEquals(50, humas.getHp());
        assertEquals(150, magi.getHp());
        assertEquals(100, mons.getHp());
    }

    /** Integration test for few function with some positive and negative functional test */
    @Test
    @DisplayName("Humans Cannot Eat")
    void testHumansCannotEat() {
        assertEquals(false, humas.canEat(magi));
    }

    @Test
    @DisplayName("Humans Can Eat")
    void testHumansCanEat() {
        ((Magician) magi).burn(dead);
        assertEquals(true, humas.canEat(dead));
    }

    @Test
    @DisplayName("Monster Can Roar")
    void testMonsterCanRoar() {
        String result = ((Monster) mons).roar();
        assertEquals("AAAAAAaaaAAAAAaaaAAAAAA", result);
    }

    @Test
    @DisplayName("Magician Can burn")
    void testMagicianCanBurn() {
        int hpBefore = humas.getHp();
        ((Magician) magi).burn(humas);
        int hpAfter = humas.getHp();
        assertEquals(hpBefore-10, hpAfter);
        
    }

    @Test
    @DisplayName("Magician Damaged Twice if Burned")
    void testMagicianDamagedTwice() {
        int hpBefore = wizard.getHp();
        ((Magician) magi).burn(wizard);
        int hpAfter = wizard.getHp();
        assertEquals(hpBefore-20, hpAfter);
    }

    @DisplayName("Players can Attack")
    void testPlayersCanAttack() {
        int hpMonsBefore = mons.getHp();
        int hpHumasBefore = humas.getHp();
        int hpWizardBefore = wizard.getHp();
        magi.attack(humas);
        magi.attack(mons);
        magi.attack(wizard);
        int hpMonsAfter = mons.getHp();
        int hpHumasAfter = humas.getHp();
        int hpWizardAfter = wizard.getHp();
        assertEquals(hpWizardBefore-20, hpWizardAfter);
        assertEquals(hpHumasBefore-10, hpHumasAfter);
        assertEquals(hpMonsBefore-10, hpMonsAfter);
    }
}
