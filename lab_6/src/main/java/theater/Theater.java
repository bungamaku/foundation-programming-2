/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package theater;
import java.util.ArrayList;
import movie.Movie;
import ticket.Ticket;

public class Theater {
	private String namaBioskop;
	private int saldoBioskop;
	private ArrayList<Ticket> tickets;
	private Movie[] movies;
	private static int totalRevenueEarned;

	public Theater(String namaBioskop, int saldoBioskop, ArrayList<Ticket> tickets, Movie[] movies) {
		this.namaBioskop = namaBioskop;
		this.saldoBioskop = saldoBioskop;
		this.tickets = tickets;
		this.movies = movies;
	}

	public String getNamaBioskop() {
		return namaBioskop;
	}

	public int getSaldoBioskop() {
		return saldoBioskop;
	}

	public void setSaldoBioskop(int saldoBioskop) {
		this.saldoBioskop = saldoBioskop;
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Movie[] getMovies() {
		return movies;
	}

	public void setMovies(Movie[] movies) {
		this.movies = movies;
	}

	public void revenueEarned(int harga) {
		setSaldoBioskop(getSaldoBioskop() + harga);
	}

	public static void countTotalRevenueEarned(Theater[] theaters) {
		for (int i = 0; i < theaters.length ; i++) {
			totalRevenueEarned += theaters[i].getSaldoBioskop();
		}
	}

	public static void printTotalRevenueEarned(Theater[] theaters) {
		countTotalRevenueEarned(theaters);

		System.out.println("Total uang yang dimiliki Koh Mas : Rp. " + totalRevenueEarned +
			"\n------------------------------------------------------------------");

		for (int i = 0; i < theaters.length; i++) {
			System.out.println("Bioskop         : " + theaters[i].getNamaBioskop() +
				"\nSaldo Kas       : Rp. " + theaters[i].getSaldoBioskop());
		}

		System.out.println("------------------------------------------------------------------");
	}

	public void printInfo() {
		String tmp = "";
		System.out.print("------------------------------------------------------------------" +
			"\nBioskop                 : " + getNamaBioskop() + "\nSaldo Kas               : " +
			getSaldoBioskop() + "\nJumlah tiket tersedia   : " + getTickets().size() +
			"\nDaftar Film tersedia    : ");

		for (int i = 0; i < getMovies().length; i++) {
			tmp += getMovies()[i].getJudul() + ", ";
		}

		System.out.println(tmp.substring(0, tmp.length()-2) + 
			"\n------------------------------------------------------------------");
	}
}