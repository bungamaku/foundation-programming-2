public class GenapGanjil {

	public static void main(String[] args) {
		
		int hasil = 0;
		int ulangan = 10;

		for(int angka = 0; angka < ulangan; angka++){
			if(angka % 2 == 0){
				System.out.println("Angka Genap");
			}else if(angka % 2 == 1){
				System.out.println("Angka Ganjil");
			}if(angka == ulangan/2){
				System.out.println("Angka Tengah");
			}
			hasil += angka;
		}
		System.out.println(hasil);
	}
}