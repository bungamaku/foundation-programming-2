/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package ticket;
import movie.Movie;

public class Ticket {
	private Movie movie;
	private String jadwalTayang;
	private boolean is3D;
	private String jenis;
	private int hargaTicket = 60000;

	public Ticket(Movie movie, String jadwalTayang, boolean is3D) {
		this.movie = movie;
		this.jadwalTayang = jadwalTayang;
		this.is3D = is3D;
		setJenis();
		setHargaTicket();
	}

	public Movie getMovie() {
		return movie;
	}

	public String getJadwalTayang() {
		return jadwalTayang;
	}

	public boolean getIs3D() {
		return is3D;
	}

	public String getJenis() {
		return jenis;
	}

	public void setJenis() {
		if (getIs3D()) {
			this.jenis = "3 Dimensi";
		} else {
			this.jenis = "Biasa";
		}
	}

	public int getHargaTicket() {
		return hargaTicket;
	}

	public void setHargaTicket() {
		if (getJadwalTayang().equals("Sabtu") || getJadwalTayang().equals("Minggu")) {
			hargaTicket += 40000;
		}

		if (getIs3D()) {
			hargaTicket += hargaTicket/5;
		}
		this.hargaTicket = hargaTicket;
	}

	public void printInfo() {
		System.out.print("------------------------------------------------------------------" +
			"\nFilm            : " + getMovie().getJudul() + "\nJadwal Tayang   : " +
			getJadwalTayang() + "\nJenis           : " + getJenis() +
			"\n------------------------------------------------------------------");
	}
}