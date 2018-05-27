import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This code is redeveloped from Ichlasul Affan's code
 */

@DisplayName("RabbitHouse")
public class RabbitHouseTest {
	// Membuat variabel baru untuk output dan error output
	private ByteArrayOutputStream outContent;
	private ByteArrayOutputStream errContent;
	
	// Untuk setiap test, lakukan setup terlebih dahulu
	@BeforeEach
	void setUp() {
		// make new ByteArrayOutputStream for output and error output
		outContent = new ByteArrayOutputStream();
		errContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent)); // Connect outContent ke System.out
		System.setErr(new PrintStream(errContent)); // Connect errContent ke System.err
	}

	@Test
	@DisplayName("Testcase Input Langsung: Contoh Soal 1")
	void testInput1() {
		// Setup masukan menggunakan ByteArrayInputStream
		ByteArrayInputStream in = new ByteArrayInputStream("normal PEWEW\n".getBytes());
		System.setIn(in);

		// Buat scanner untuk input (mensimulasikan user)
		Scanner keyboard = new Scanner(System.in);

		// Jalankan fungsi main
		RabbitHouse.main(new String[0]);

		// Mengecek apakah hasil-hasil pemrosesan ada pada output
		// Cek jawaban
		if (!outContent.toString().contains("206")) {
			fail("Gagal testcase 1 ");
		}
	}

	@Test
	@DisplayName("Testcase Input Langsung: Contoh Soal 2")
	void testInput2() {
		// Setup masukan menggunakan ByteArrayInputStream
		ByteArrayInputStream in = new ByteArrayInputStream("normal EXODUS\n".getBytes());
		System.setIn(in);

		// Buat scanner untuk input (mensimulasikan user)
		Scanner keyboard = new Scanner(System.in);

		// Jalankan fungsi main
		RabbitHouse.main(new String[0]);

		// Mengecek apakah hasil-hasil pemrosesan ada pada output
		// Cek jawaban
		if (!outContent.toString().contains("1237")) {
			fail("Gagal testcase 2 ");
		}
	}
	
	@Test
	@DisplayName("Testcase Input Langsung: Contoh Soal 3")
	void testInput3() {
		// Setup masukan menggunakan ByteArrayInputStream
		ByteArrayInputStream in = new ByteArrayInputStream("normal J\n".getBytes());
		System.setIn(in);

		// Buat scanner untuk input (mensimulasikan user)
		Scanner keyboard = new Scanner(System.in);

		// Jalankan fungsi main
		RabbitHouse.main(new String[0]);

		// Mengecek apakah hasil-hasil pemrosesan ada pada output
		// Cek jawaban
		if (!outContent.toString().contains("1")) {
			fail("Gagal testcase 3 ");
		}
	}

}