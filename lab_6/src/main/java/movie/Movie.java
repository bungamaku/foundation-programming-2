/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package movie;

public class Movie {

	private String judul;
	private String ratingUmur;
	private int minUmur;
	private int durasi;
	private String genre;
	private String status;

	public Movie(String judul, String ratingUmur, int durasi, String genre, String status) {
		this.judul = judul;
		this.ratingUmur = ratingUmur;
		this.durasi = durasi;
		this.genre = genre;
		this.status = status;
		setMinUmur();
	}

	public String getJudul() {
		return judul;
	}
	
	public String getRatingUmur() {
		return ratingUmur;
	}

	public int getDurasi() {
		return durasi;
	}

	public String getGenre() {
		return genre;
	}

	public String getStatus() {
		return status;
	}

	public int getMinUmur() {
		return minUmur;
	}

	public void setMinUmur() {
		if (getRatingUmur().equals("Dewasa")) {
			this.minUmur = 17;
		} else if (getRatingUmur().equals("Remaja")) {
			this.minUmur = 13;
		} else if (getRatingUmur().equals("Umum")) {
			this.minUmur = 0;
		}
	}

	public String returnInfo() {
		return "------------------------------------------------------------------" +
			"\nJudul   : " + getJudul() + "\nGenre   : " + getGenre() +
			"\nDurasi  : " + getDurasi() + " menit\nRating  : " + getRatingUmur() +
			"\nJenis   : Film " + getStatus() +
			"\n------------------------------------------------------------------";
	}
}