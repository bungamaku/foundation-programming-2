import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This code is redeveloped from Ichlasul Affan's code
 */

@DisplayName("Manusia")
public class ManusiaTest {
	// Membuat variabel baru untuk output dan error output
	private ByteArrayOutputStream outContent;
	private ByteArrayOutputStream errContent;
	private Manusia yumna;
	private Manusia mecin;

	// Untuk setiap test, lakukan setup terlebih dahulu
	@BeforeEach
	void init() {
		// inisiasi objek manusia
		yumna = new Manusia("Yumna", 20, 500000);
		mecin = new Manusia("Me Cin", 11);

		// make new ByteArrayOutputStream for output and error output
		outContent = new ByteArrayOutputStream();
		errContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent)); // Connect outContent ke System.out
		System.setErr(new PrintStream(errContent)); // Connect errContent ke System.err
	}

	@Test
	@DisplayName("Test Getters")
	void testGetter() {
		// Setup masukan menggunakan ByteArrayInputStream
		assertAll("manusia",
            () -> assertEquals("Yumna", yumna.getNama()),
            () -> assertEquals(20, yumna.getUmur()),
            () -> assertEquals(500000, yumna.getUang()),
            () -> assertEquals(50, yumna.getKebahagiaan()),
            () -> assertEquals("Me Cin", mecin.getNama()),
            () -> assertEquals(11, mecin.getUmur()),
            () -> assertEquals(50000, mecin.getUang()),
            () -> assertEquals(50, mecin.getKebahagiaan())
        );
	}

	@Test
	@DisplayName("Test Bekerja Full Time")
	void testBekerjaFullTime() {
		// Beri uang dengan jumlah
		yumna.bekerja(8, 2);
		assertEquals(660000, yumna.getUang());
		assertEquals(34, yumna.getKebahagiaan());
	}

	@Test
	@DisplayName("Test Bekerja Half Time")
	void testBekerjaHalfTime() {
		// Beri uang dengan jumlah
		yumna.setKebahagiaan(8);
		yumna.bekerja(8, 3);
		assertEquals(560000, yumna.getUang());
		assertEquals(2, yumna.getKebahagiaan());
	}

	@Test
	@DisplayName("Test Beri Uang Valid")
	void testBeriUangValid() {
		// Beri uang dengan jumlah
		yumna.beriUang(mecin);
		assertEquals(450800, yumna.getUang());
		assertEquals("58.2", String.format("%.1f", yumna.getKebahagiaan()));
		assertEquals(99200, mecin.getUang());
		assertEquals("58.2", String.format("%.1f", mecin.getKebahagiaan()));
	}

	@Test
	@DisplayName("Test Beri Uang Valid dengan Jumlah")
	void testBeriUangValidDenganJumlah() {
		// Beri uang dengan jumlah
		yumna.beriUang(mecin, 49200);
		assertEquals(450800, yumna.getUang());
		assertEquals("58.2", String.format("%.1f", yumna.getKebahagiaan()));
		assertEquals(99200, mecin.getUang());
		assertEquals("58.2", String.format("%.1f", mecin.getKebahagiaan()));
	}

	@Test
	@DisplayName("Test Beri Uang Kebanyakan")
	void testBeriUangNotValid() {
		// Beri uang dengan jumlah
		yumna.beriUang(mecin, 10000000);
		assertEquals(500000, yumna.getUang());
		assertEquals(50, yumna.getKebahagiaan());
		assertEquals(50000, mecin.getUang());
		assertEquals(50, mecin.getKebahagiaan());
	}

	@Test
	@DisplayName("Test Beri Uang Kebanyakan V2")
	void testBeriUangNotValidV2() {
		// Beri uang dengan jumlah
		yumna.setUang(1000);
		yumna.beriUang(mecin);
		assertEquals(1000, yumna.getUang());
		assertEquals(50, yumna.getKebahagiaan());
		assertEquals(50000, mecin.getUang());
		assertEquals(50, mecin.getKebahagiaan());
	}

	@Test
	@DisplayName("Test Beri Uang Terlalu Bahagia")
	void testBeriUangTerlaluBahagia() {
		// Beri uang dengan jumlah
		yumna.setKebahagiaan(99);
		mecin.setKebahagiaan(99);
		yumna.beriUang(mecin, 400000);
		assertEquals(100000, yumna.getUang());
		assertEquals(100, yumna.getKebahagiaan());
		assertEquals(450000, mecin.getUang());
		assertEquals(100, mecin.getKebahagiaan());
	}

	@Test
	@DisplayName("Test Rekreasi Valid")
	void testRekreasiValid() {
		// Beri uang dengan jumlah
		yumna.rekreasi("Ancol");
		assertEquals(450000, yumna.getUang());
		assertEquals(55, yumna.getKebahagiaan());
	}

	@Test
	@DisplayName("Test Rekreasi Not Valid")
	void testRekreasiNotValid() {
		// Beri uang dengan jumlah
		yumna.setUang(10000);
		yumna.rekreasi("Ancol");
		assertEquals(10000, yumna.getUang());
		assertEquals(50, yumna.getKebahagiaan());
	}

	@Test
	@DisplayName("Test Rekreasi Terlalu Bahagia")
	void testRekreasiTerlaluBahagia() {
		// Beri uang dengan jumlah
		yumna.setKebahagiaan(99);
		yumna.rekreasi("Ancol");
		assertEquals(450000, yumna.getUang());
		assertEquals(100, yumna.getKebahagiaan());
	}

	@Test
	@DisplayName("Test Sakit Normal")
	void testSakitNormal() {
		// Beri uang dengan jumlah
		yumna.sakit("Hati");
		assertEquals(500000, yumna.getUang());
		assertEquals(46, yumna.getKebahagiaan());
	}	

	@Test
	@DisplayName("Test Sakit Padahal Udah Gak Bahagia")
	void testSakitKetikaSedangGakBahagia() {
		// Beri uang dengan jumlah
		yumna.setKebahagiaan(2);
		yumna.sakit("Hati");
		assertEquals(500000, yumna.getUang());
		assertEquals(0, yumna.getKebahagiaan());
	}

}
