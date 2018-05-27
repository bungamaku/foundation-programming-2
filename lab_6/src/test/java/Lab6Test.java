import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import customer.Customer;
import movie.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import theater.Theater;
import ticket.Ticket;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class Lab6Test {
    Movie[] movies;
    Ticket[] tickets1;
    Ticket[] tickets2;
    private Theater cgtBlitz;
    private Theater compFestXXI;
    private Customer dekDepe;
    private Customer sisDea;
    private Customer kakPewe;
    private OutputStream out;
    private Logger logger;

    @BeforeEach
    void setUp() {
        logger = Logger.getLogger(Lab6Test.class.getName());
        movies = Lab6.createMovieList();
        Movie[] movies2 = {movies[0], movies[1]};
        tickets1 = Lab6.createTicket1(movies);
        tickets2 = Lab6.createTicket2(movies2);

        cgtBlitz = new Theater("CGT Blitz", 0, new ArrayList<>(Arrays.asList(tickets1)), movies);
        compFestXXI = new Theater("CompFest XXI", 25000, new ArrayList<>(Arrays.asList(tickets2)), movies2);

        dekDepe = new Customer("Dek Depe","Perempuan",10);
        sisDea = new Customer("Sis Dea","Perempuan",15);
        kakPewe = new Customer("Kak Pewe","Laki-Laki",20);

        out = new ByteArrayOutputStream();
    }

    @Test
    @DisplayName("Test Print Info CGT Blitz")
    void testPrintCGTInfo() {
        System.setOut(new PrintStream(out));
        cgtBlitz.printInfo();
        String output = out.toString().trim();

        assertTrue(output.contains("Black Panther, Dilan 1990, The Greatest Showman, Si Juki The Movie") && output.contains("0")
        && output.contains("CGT Blitz") && output.endsWith("------------------------------------------------------------------"));
    }

    @Test
    @DisplayName("Test Print Info CompFestXXI")
    void testPrintCompFestInfo() {
        System.setOut(new PrintStream(out));
        compFestXXI.printInfo();
        String output = out.toString().trim();

        assertTrue(output.startsWith("------------------------------------------------------------------")&&
                output.contains("Black Panther, Dilan 1990") && output.contains("CompFest XXI") && output.contains("25000") &&
                output.endsWith("------------------------------------------------------------------"));
    }

    @Test
    @DisplayName("Test Dek Depe Order tickets")
    void testDekDepeOrderTicket() {
        System.setOut(new PrintStream(out));
        dekDepe.orderTicket(cgtBlitz, "Black Panther", "Senin", "3 Dimensi");
        String output = out.toString().trim();
        assertEquals(output, "Tiket untuk film Black Panther jenis 3 Dimensi dengan jadwal Senin tidak tersedia di CGT Blitz");

        assertEquals(tickets1[7],
                dekDepe.orderTicket(cgtBlitz, "The Greatest Showman", "Jumat", "3 Dimensi"));
    }

    @Test
    @DisplayName("Test Sis Dea Find Movie")
    void testFindMovie() {
        System.setOut(new PrintStream(out));
        sisDea.findMovie(compFestXXI, "Si Juki The Movie");
        String output = out.toString().trim();
        assertTrue(output.equals("Film Si Juki The Movie yang dicari Sis Dea tidak ada di bioskop CompFest XXI"));

        System.setOut(new PrintStream(out));
        sisDea.findMovie(compFestXXI, "Dilan 1990");
        output = out.toString().trim();
        assertTrue(output.contains("Dilan 1990") && output.contains("Romantis/Drama")
        && output.contains("Remaja") && output.contains("Film Lokal"));
    }

    @Test
    @DisplayName("Test Sis Dea Order tickets")
    void testSisDeaOrderTicket() {
        System.setOut(new PrintStream(out));
        sisDea.orderTicket(compFestXXI, "Dilan 1990", "Selasa", "Biasa");
        String output = out.toString().trim();
        assertEquals(output, "Tiket untuk film Dilan 1990 jenis Biasa dengan jadwal Selasa tidak tersedia di CompFest XXI");

        assertEquals(tickets2[8],
                sisDea.orderTicket(compFestXXI, "Dilan 1990", "Minggu", "Biasa"));

        System.setOut(new PrintStream(out));
        sisDea.orderTicket(cgtBlitz, "Si Juki The Movie", "Jumat", "3 Dimensi");
        output = out.toString().trim();
        assertTrue(output.contains("Sis Dea masih belum cukup umur untuk menonton Si Juki The Movie dengan rating Dewasa"));
    }

    @Test
    @DisplayName("Test Kak Pewe Order tickets")
    void testKakPeweOrderTicket() {
        System.setOut(new PrintStream(out));
        kakPewe.orderTicket(cgtBlitz,"Si Juki The Movie", "Kamis", "Biasa");
        String output = out.toString().trim();
        assertEquals(output, "Kak Pewe telah membeli tiket Si Juki The Movie jenis Biasa di CGT Blitz pada hari Kamis seharga Rp. 60000");

        assertEquals(tickets2[2],
                kakPewe.orderTicket(compFestXXI, "Black Panther", "Sabtu", "3 Dimensi"));
    }

    @Test
    @DisplayName("Test Print Total Revenue Earned")
    void testPrintTotalRevenueEarned() {
        Theater[] theaters = {cgtBlitz, compFestXXI};
        System.setOut(new PrintStream(out));
        Theater.printTotalRevenueEarned(theaters);
        String output = out.toString().trim();
        assertTrue(output.contains("Total uang yang dimiliki Koh Mas : Rp.")
        && output.contains("CGT Blitz") && output.contains("CompFest XXI"));
    }
/*
    @Test
    @DisplayName("BONUS: Kak Pewe Cancel ticket, case success")
    void testCancelTicket() {
        Ticket t = kakPewe.orderTicket(cgtBlitz,"Black Panther", "Sabtu", "3 Dimensi");
        System.setOut(new PrintStream(out));
        kakPewe.cancelTicket(cgtBlitz);
        String output = out.toString().trim();
//        logger.info("sukses: " + output);
        assertTrue(output.equals("Tiket film Black Panther dengan waktu tayang Sabtu jenis 3 Dimensi dikembalikan ke bioskop CGT Blitz"));
    }

    @Test
    @DisplayName("BONUS: Kak Pewe Cancel ticket, case fail theater not found")
    void testCancelTicketTheaterNotFound() {
        Ticket t = kakPewe.orderTicket(cgtBlitz,"Si Juki The Movie", "Kamis", "Biasa");
        System.setOut(new PrintStream(out));
        kakPewe.cancelTicket(compFestXXI);
        String output = out.toString().trim();
        assertTrue(output.equals("Maaf tiket tidak bisa dikembalikan, Si Juki The Movie tidak tersedia dalam CompFest XXI"));
    }

    @Test
    @DisplayName("BONUS: Kak Pewe Cancel ticket, case fail ticket has been used")
    void testCancelTicketHasBeenUsed() {
        Ticket t = kakPewe.orderTicket(cgtBlitz,"Si Juki The Movie", "Kamis", "Biasa");
        System.setOut(new PrintStream(out));
        kakPewe.watchMovie(t);
        String output = out.toString().trim();
        assertTrue(output.contains("Kak Pewe telah menonton film Si Juki The Movie"));

        System.setOut(new PrintStream(out));
        kakPewe.cancelTicket(cgtBlitz);
        output = out.toString().trim();
        logger.info("used: " + output);
        assertTrue(output.contains("Tiket tidak bisa dikembalikan karena film Si Juki The Movie sudah ditonton oleh Kak Pewe"));
    }

    @Test
    @DisplayName("BONUS: Kak Pewe Cancel ticket, case fail theater gone bankrupt")
    void testCancelTicketBankrupt() {
        Ticket t = kakPewe.orderTicket(compFestXXI,"Black Panther", "Sabtu", "3 Dimensi");
        System.setOut(new PrintStream(out));
        kakPewe.cancelTicket(cgtBlitz);
        String output = out.toString().trim();
        logger.info("bankrut: " + output);
        assertTrue(output.contains("Maaf ya tiket tidak bisa dibatalkan, uang kas di bioskop CGT Blitz lagi tekor..."));
    }
*/
}
