/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package customer;
import theater.Theater;
import movie.Movie;
import ticket.Ticket;

public class Customer {
	private String namaCustomer;
	private String gender;
	private int umur;

	public Customer(String namaCustomer, String gender, int umur) {
		this.namaCustomer = namaCustomer;
		this.gender = gender;
		this.umur = umur;
	}

	public String getNamaCustomer() {
		return namaCustomer;
	}

	public void setNamaCustomer(String namaCustomer) {
		this.namaCustomer = namaCustomer;
	}

	public String getGender() {
		return gender;
	}

	public void setGender() {
		this.gender = gender;
	}

	public int getUmur() {
		return umur;
	}

	public void setUmur(int umur) {
		this.umur = umur;
	}

	public Movie findMovie(Theater theater, String judul) {
		for (int i = 0; i < theater.getMovies().length; i++) {
			if (theater.getMovies()[i].getJudul().equals(judul)) {
				System.out.println(theater.getMovies()[i].returnInfo());
				return theater.getMovies()[i];
			}
		}

		System.out.println("Film " + judul + " yang dicari " + getNamaCustomer() +
			" tidak ada di bioskop " + theater.getNamaBioskop());
		return null;
	}

	public Ticket findTicket(Theater theater, String judul, String hari, String jenis) {
		for (int i = 0; i < theater.getTickets().size(); i++) {
			Ticket ticket = theater.getTickets().get(i);
			Movie movie = ticket.getMovie();

			if (movie.getJudul().equals(judul) && ticket.getJadwalTayang().equals(hari) && ticket.getJenis().equals(jenis)) {
				return ticket;
			}
		}

		return null;
	}

	public Ticket orderTicket(Theater theater, String judul, String hari, String jenis) {
		Ticket ticket = findTicket(theater, judul, hari, jenis);
		if (ticket == null) {
			System.out.println("Tiket untuk film " + judul + " jenis " + jenis + " dengan jadwal " +
				hari + " tidak tersedia di " + theater.getNamaBioskop());
			return null;

		} else if (getUmur() < ticket.getMovie().getMinUmur()) {
			System.out.println(getNamaCustomer() + " masih belum cukup umur untuk menonton " +
				judul + " dengan rating " + ticket.getMovie().getRatingUmur());
			return null;

		} else {
			theater.revenueEarned(findTicket(theater, judul, hari, jenis).getHargaTicket());
			System.out.println(getNamaCustomer() + " telah membeli tiket " + judul + " jenis " +
				jenis + " di " + theater.getNamaBioskop() + " pada hari " + hari + 
				" seharga Rp. " + ticket.getHargaTicket());
			return ticket;
		}
	}
}