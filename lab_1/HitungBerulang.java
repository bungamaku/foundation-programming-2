public class HitungBerulang {

	public static void main(String[] args) {
		
		int hasil = 0;
		for(int a = 0; a<10; a++){
			hasil = hasil + (a*100 - a);
		}
		System.out.println(hasil);
	}
}