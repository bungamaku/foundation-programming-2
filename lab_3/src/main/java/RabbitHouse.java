import java.util.Scanner;

/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

public class RabbitHouse {
	public static int beranak(int nama) {
		if (nama <= 1) {
			return 1;
		} else {
			return 1 + (nama * beranak(nama-1));
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String mode = input.next();
		String nama = input.next();
		if (nama.length() > 10) {
			System.out.print("Panjang nama melebihi 10 huruf!");
			System.exit(0);
		}
		System.out.print(beranak(nama.length()));
	}
}