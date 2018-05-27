import java.util.Scanner;

/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

public class Manusia {

	private String nama;
	private int umur;
	private int uang;
	private float kebahagiaan = 50.0f;

	public Manusia(String nama, int umur) {
		this.nama = nama;
		this.umur = umur;
		this.uang = 50000;
		this.kebahagiaan = kebahagiaan;
	}

	public Manusia(String nama, int umur, int uang) {
		this.nama = nama;
		this.umur = umur;
		this.uang = uang;
		this.kebahagiaan = kebahagiaan;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNama() {
		return nama;
	}

	public void setUmur(int umur) {
		this.umur = umur;
	}

	public int getUmur() {
		return umur;
	}

	public void setUang(int uang) {
		this.uang = uang;
	}

	public int getUang() {
		return uang;
	}

	public void setKebahagiaan(float kebahagiaan) {
		this.kebahagiaan = kebahagiaan;
		if (this.kebahagiaan > 100.0f) {
			this.kebahagiaan = 100.0f;
		} else if (this.kebahagiaan < 0.0f) {
			this.kebahagiaan = 0.0f;
		}
	}

	public float getKebahagiaan() {
		return kebahagiaan;
	}

	public void beriUang(Manusia penerima) {
		int jumlahUang = 0;

		for (int i=0; i<penerima.getNama().length(); i++) {
			jumlahUang += (int) penerima.getNama().charAt(i);
		}

		jumlahUang *= 100;

		if (this.getUang() >= jumlahUang) {
			this.setUang(this.getUang() - jumlahUang);
			penerima.setUang(penerima.getUang() + jumlahUang);
			this.setKebahagiaan(this.getKebahagiaan() + jumlahUang / 6000.0f);
			penerima.setKebahagiaan(penerima.getKebahagiaan() + jumlahUang / 6000.0f);
			System.out.println(this.getNama() + " memberi uang sebanyak " + 
				jumlahUang + " kepada " + penerima.getNama() + ", mereka berdua senang :D");
		} else {
			System.out.println(this.getNama() + " ingin memberi uang kepada " +
				penerima.getNama() + " namun tidak memiliki cukup uang :'(");
		}
	}

	public void beriUang(Manusia penerima, int jumlah) {
		if (this.getUang() >= jumlah) {
			this.setUang(this.getUang() - jumlah);
			penerima.setUang(penerima.getUang() + jumlah);
			this.setKebahagiaan(this.getKebahagiaan() + jumlah / 6000.0f);
			penerima.setKebahagiaan(penerima.getKebahagiaan() + jumlah / 6000.0f);
			System.out.println(this.getNama() + " memberi uang sebanyak " + 
				jumlah + " kepada " + penerima.getNama() + ", mereka berdua senang :D");
		} else {
			System.out.println(this.getNama() + " ingin memberi uang kepada " +
				penerima.getNama() + " namun tidak memiliki cukup uang :'(");
		}
	}

	public void bekerja(int durasi, int bebanKerja) {
		int pendapatan;
		int BebanKerjaTotal;
		BebanKerjaTotal = durasi * bebanKerja;

		if (this.getUmur() < 18) {
			System.out.println(this.getNama() + " belum boleh bekerja karena masih dibawah umur D:");
		} else {
			if (BebanKerjaTotal <= this.getKebahagiaan()) {
				pendapatan = BebanKerjaTotal * 10000;
				this.setKebahagiaan(this.getKebahagiaan() - BebanKerjaTotal);
				this.setUang(this.getUang() + pendapatan);
				System.out.println(this.getNama() + " bekerja full time, total pendapatan : " + pendapatan);
			} else {
				durasi = ((int) this.getKebahagiaan())/bebanKerja;
				BebanKerjaTotal = durasi * bebanKerja;
				pendapatan = BebanKerjaTotal * 10000;
				this.setKebahagiaan(this.getKebahagiaan() - BebanKerjaTotal);
				this.setUang(this.getUang() + pendapatan);
				System.out.println(this.getNama() + " tidak bekerja secara full time karena sudah terlalu lelah, total pendapatan : " + pendapatan);
			}
		}
	}

	public void rekreasi(String namaTempat) {
		int biaya = namaTempat.length() * 10000;

		if (this.getUang() < biaya) {
			System.out.println(this.getNama() + " tidak mempunyai cukup uang untuk berekreasi di " + namaTempat + " :(");
		} else {
			this.setUang(this.getUang() - biaya);
			this.setKebahagiaan(this.getKebahagiaan() + namaTempat.length());
			System.out.println(this.getNama() + " berekreasi di " + namaTempat + ", " + this.getNama() + " senang :)");
		}
	}

	public void sakit(String namaPenyakit) {
		this.setKebahagiaan(this.getKebahagiaan() - namaPenyakit.length());
		System.out.println(this.getNama() + " terkena penyakit " + namaPenyakit + " :O");
	}

	public String toString() {
		return "Nama\t\t: " + this.getNama() + "\nUmur\t\t: " + this.getUmur() +
			"\nUang\t\t: " + this.getUang() + "\nKebahagiaan\t: " + this.getKebahagiaan();
	}
}