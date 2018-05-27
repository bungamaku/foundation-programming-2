import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This code is redeveloped from Ichlasul Affan's code
 */

@DisplayName("BingoCard")
public class BingoCardTest {
	// Membuat variabel baru untuk output dan error output
	private ByteArrayOutputStream outContent;
	private ByteArrayOutputStream errContent;
    private BingoCard card;

	// Untuk setiap test, lakukan setup terlebih dahulu
	@BeforeEach
	void init() {
		// make new ByteArrayOutputStream for output and error output
		outContent = new ByteArrayOutputStream();
		errContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent)); // Connect outContent ke System.out
		System.setErr(new PrintStream(errContent)); // Connect errContent ke System.err

		// inisiasi objek BingoCard
		// untuk inisiasi kalian boleh mengubah bagian kode ini untuk menyesuaikan dengan class BingoCard yang telah kalian buat
        Number[][] numbers = {{new Number(10,0,0), new Number(12,0,1),new Number(14,0,2),new Number(16,0,3),new Number(18,0,4)},
        {new Number(29,1,0), new Number(27,1,1),new Number(25,1,2),new Number(23,1,3),new Number(21,1,4)},
        {new Number(35,2,0), new Number(34,2,1),new Number(30,2,2),new Number(38,2,3),new Number(39,2,4)},
        {new Number(40,3,0), new Number(44,3,1),new Number(45,3,2),new Number(49,3,3),new Number(41,3,4)},
        {new Number(52,4,0), new Number(67,4,1),new Number(73,4,2),new Number(81,4,3),new Number(90,4,4)}};
		
		Number[] states = new Number[100];
        for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){				
				states[numbers[i][j].getValue()] = numbers[i][j];
			}
		}

        card = new BingoCard(numbers,states);
		// batas kode yang diperbolehkan untuk diubah
	}	

	@Test
	@DisplayName("Test Info on an unmarked card")
	void tesInfoBersih() {
		assertEquals("| 10 | 12 | 14 | 16 | 18 |\n| 29 | 27 | 25 | 23 | 21 |\n| 35 | 34 | 30 | 38 | 39 |\n| 40 | 44 | 45 | 49 | 41 |\n| 52 | 67 | 73 | 81 | 90 |", card.info());
	}

	@Test
	@DisplayName("Test Mark a number on a card")
	void testMarkSuccess() {
		assertEquals("14 tersilang",card.markNum(14));
        assertEquals("| 10 | 12 | X  | 16 | 18 |\n| 29 | 27 | 25 | 23 | 21 |\n| 35 | 34 | 30 | 38 | 39 |\n| 40 | 44 | 45 | 49 | 41 |\n| 52 | 67 | 73 | 81 | 90 |", card.info());
        assertEquals("10 tersilang",card.markNum(10));
        assertEquals("| X  | 12 | X  | 16 | 18 |\n| 29 | 27 | 25 | 23 | 21 |\n| 35 | 34 | 30 | 38 | 39 |\n| 40 | 44 | 45 | 49 | 41 |\n| 52 | 67 | 73 | 81 | 90 |", card.info());
        assertEquals("49 tersilang",card.markNum(49));
        assertEquals("| X  | 12 | X  | 16 | 18 |\n| 29 | 27 | 25 | 23 | 21 |\n| 35 | 34 | 30 | 38 | 39 |\n| 40 | 44 | 45 | X  | 41 |\n| 52 | 67 | 73 | 81 | 90 |", card.info());
        assertEquals("90 tersilang",card.markNum(90));
        assertEquals("| X  | 12 | X  | 16 | 18 |\n| 29 | 27 | 25 | 23 | 21 |\n| 35 | 34 | 30 | 38 | 39 |\n| 40 | 44 | 45 | X  | 41 |\n| 52 | 67 | 73 | 81 | X  |", card.info());
	}

	@Test
	@DisplayName("Test Mark a marked number on a card")
	void testMarkMultipleOccurence() {
        card.markNum(14);
        assertEquals("| 10 | 12 | X  | 16 | 18 |\n| 29 | 27 | 25 | 23 | 21 |\n| 35 | 34 | 30 | 38 | 39 |\n| 40 | 44 | 45 | 49 | 41 |\n| 52 | 67 | 73 | 81 | 90 |", card.info());
        assertEquals("14 sebelumnya sudah tersilang",card.markNum(14));
        assertEquals("| 10 | 12 | X  | 16 | 18 |\n| 29 | 27 | 25 | 23 | 21 |\n| 35 | 34 | 30 | 38 | 39 |\n| 40 | 44 | 45 | 49 | 41 |\n| 52 | 67 | 73 | 81 | 90 |", card.info());
	}

	@Test
	@DisplayName("Test Mark a number not on a card")
	void testMarkFail() {
        assertEquals("Kartu tidak memiliki angka 11",card.markNum(11));
        assertEquals("| 10 | 12 | 14 | 16 | 18 |\n| 29 | 27 | 25 | 23 | 21 |\n| 35 | 34 | 30 | 38 | 39 |\n| 40 | 44 | 45 | 49 | 41 |\n| 52 | 67 | 73 | 81 | 90 |", card.info());
    }

	@Test
	@DisplayName("Test Restart")
	void testRestart() {
		card.markNum(14);
        card.markNum(10);
        card.markNum(49);
        card.markNum(90);
        card.restart();
		assertEquals("| 10 | 12 | 14 | 16 | 18 |\n| 29 | 27 | 25 | 23 | 21 |\n| 35 | 34 | 30 | 38 | 39 |\n| 40 | 44 | 45 | 49 | 41 |\n| 52 | 67 | 73 | 81 | 90 |", card.info());
        card.markNum(49);
		assertEquals("| 10 | 12 | 14 | 16 | 18 |\n| 29 | 27 | 25 | 23 | 21 |\n| 35 | 34 | 30 | 38 | 39 |\n| 40 | 44 | 45 | X  | 41 |\n| 52 | 67 | 73 | 81 | 90 |", card.info());
	}

	@Test
	@DisplayName("Test Win Vertically")
	void testWinVertically() {
		card.markNum(12);
        card.markNum(27);
        card.markNum(34);
        card.markNum(44);
        card.markNum(67);
        assertEquals(true,card.isBingo());
	}

	@Test
	@DisplayName("Test Win Horizontally")
	void testWinHorizontally() {
		card.markNum(45);
        card.markNum(40);
        card.markNum(41);
        card.markNum(49);
        card.markNum(44);
        assertEquals(true,card.isBingo());
	}

	@Test
	@DisplayName("Test Win Diagonally 1")
	void testWinDiagonal1() {
		card.markNum(90);
        card.markNum(49);
        card.markNum(30);
        card.markNum(27);
        card.markNum(10);
        assertEquals(true,card.isBingo());
	}

	@Test
	@DisplayName("Test Win Diagonally 2")
	void testWinDiagonal2() {
		card.markNum(18);
        card.markNum(44);
        card.markNum(23);
        card.markNum(52);
        card.markNum(30);
        assertEquals(true,card.isBingo());
	}
}
