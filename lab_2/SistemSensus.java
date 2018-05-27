import java.util.Scanner;

/**
 * @author Template Author: Ichlasul Affan dan Arga Ghulam Ahmad
 * Template ini digunakan untuk Tutorial 02 DDP2 Semester Genap 2017/2018.
 * Anda sangat disarankan untuk menggunakan template ini.
 * Namun Anda diperbolehkan untuk menambahkan hal lain berdasarkan kreativitas Anda
 * selama tidak bertentangan dengan ketentuan soal.
 *
 * Cara penggunaan template ini adalah:
 * 1. Isi bagian kosong yang ditandai dengan komentar dengan kata TODO
 * 2. Ganti titik-titik yang ada pada template agar program dapat berjalan dengan baik.
 *
 * Code Author (Mahasiswa):
 * @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
 */

public class SistemSensus {
	public static void main(String[] args) {
		// Buat input scanner baru
		Scanner input = new Scanner(System.in);


		// TODO Bagian ini digunakan untuk soal Tutorial "Sensus Daerah Kumuh"
		// User Interface untuk meminta masukan
		System.out.print("PROGRAM PENCETAK DATA SENSUS\n" +
				"--------------------\n" +
				"Nama Kepala Keluarga   : ");
		String nama = input.nextLine();
		System.out.print("Alamat Rumah           : "); 
		String alamat = input.nextLine();
		System.out.print("Panjang Tubuh (cm)     : ");
		short panjang = Short.parseShort(input.nextLine());
		if (panjang <= 0 || panjang > 250) {
			System.out.print("WARNING: Keluarga ini tidak perlu direlokasi!");
			System.exit(0);
		}
		System.out.print("Lebar Tubuh (cm)       : "); 
		short lebar = Short.parseShort(input.nextLine());
		if (lebar <= 0 || lebar > 250) {
			System.out.print("WARNING: Keluarga ini tidak perlu direlokasi!");
			System.exit(0);
		}
		System.out.print("Tinggi Tubuh (cm)      : "); 
		short tinggi = Short.parseShort(input.nextLine());
		if (tinggi <= 0 || tinggi > 250) {
			System.out.print("WARNING: Keluarga ini tidak perlu direlokasi!");
			System.exit(0);
		}
		System.out.print("Berat Tubuh (kg)       : "); 
		float berat = Float.parseFloat(input.nextLine());
		if (berat <= 0 || berat > 150) {
			System.out.print("WARNING: Keluarga ini tidak perlu direlokasi!");
			System.exit(0);
		}
		System.out.print("Jumlah Anggota Keluarga: "); 
		byte makanan = Byte.parseByte(input.nextLine());
		if (makanan <= 0 || makanan > 20) {
			System.out.print("WARNING: Keluarga ini tidak perlu direlokasi!");
			System.exit(0);
		}
		System.out.print("Tanggal Lahir          : "); 
		String tanggalLahir = input.nextLine();
		System.out.print("Catatan Tambahan       : "); 
		String catatan = input.nextLine();
		System.out.print("Jumlah Cetakan Data    : "); 
		byte jumlahCetakan = Byte.parseByte(input.nextLine());


		// TODO Bagian ini digunakan untuk soal Tutorial "Sensus Daerah Kumuh"
		// TODO Hitung rasio berat per volume (rumus lihat soal)

		int rasio = (int) (berat / (panjang*0.01) * (lebar*0.01) * (tinggi*0.01));

		for (byte i=1; i<=jumlahCetakan; i++) {
			// TODO Minta masukan terkait nama penerima hasil cetak data
			System.out.print("\nPencetakan " + i + " dari " + jumlahCetakan + " untuk: ");
			String penerima = input.nextLine().toUpperCase(); // Lakukan baca input lalu langsung jadikan uppercase

			// TODO Periksa ada catatan atau tidak
			if (catatan.length() > 0) catatan = catatan;
			else catatan = "Tidak ada catatan tambahan";

			// TODO Cetak hasil (ganti string kosong agar keluaran sesuai)
			String hasil = "DATA SIAP DICETAK UNTUK " + penerima +
			"\n-----------------\n" + nama + " - " + alamat + "\n" +
			"Lahir pada tanggal " + tanggalLahir + "\n" +
			"Rasio Berat Per Volume = " + rasio + " kg/m^3\n" +
			"Catatan: " + catatan;
			System.out.print(hasil + "\n");
		}

		// TODO Bagian ini digunakan untuk soal bonus "Rekomendasi Apartemen"
		// TODO Hitung nomor keluarga dari parameter yang telah disediakan (rumus lihat soal)
		byte jumlahAscii = 0;
		for (byte j=0; j<nama.length(); j++) {
			if ((int) nama.charAt(j) == 127){
				continue;
			} 
			jumlahAscii += (int) nama.charAt(j);
		}
		int kalkulasi = ((panjang * tinggi * lebar) + jumlahAscii) % 10000;
		// TODO Gabungkan hasil perhitungan sesuai format sehingga membentuk nomor keluarga
		String nomorKeluarga = nama.charAt(0) + String.valueOf(kalkulasi);

		// TODO Hitung anggaran makanan per tahun (rumus lihat soal)
		int anggaran = 50000 * 365 * makanan;

		// TODO Hitung umur dari tanggalLahir (rumus lihat soal)
		String[] lahir = tanggalLahir.split("-");
		String tahun = lahir[2];
		short tahunLahir = Short.parseShort(tahun); // lihat hint jika bingung
		short umur = (short)(2018 - tahunLahir);

		// TODO Lakukan proses menentukan apartemen (kriteria lihat soal)
		String apartemen = "";
		String kabupaten = "";

		if (umur <= 18) {
			apartemen = "PPMT";
			kabupaten = "Rotunda";
		} else if (anggaran < 100000000) {
			apartemen = "Teksas";
			kabupaten = "Sastra";
		} else {
			apartemen = "Mares";
			kabupaten = "Margonda";
		}

		// TODO Cetak rekomendasi (ganti string kosong agar keluaran sesuai)
		String rekomendasi = "REKOMENDASI APARTEMEN\n--------------------\n" +
		"MENGETAHUI: Identitas keluarga: " + nama + " - " + nomorKeluarga +
		"\nMENIMBANG: Anggaran makanan tahunan: Rp " + anggaran +
		"\nUmur kepala keluarga: " + umur + " tahun" +
		"\nMEMUTUSKAN: keluarga " + nama + " akan ditempatkan di:\n" +
		apartemen + ", kabupaten " + kabupaten;
		System.out.print(rekomendasi + "\n");
		
		input.close();
	}
}