public class CekUmur {

	public static void main(String[] args) {
		int umur = 19;
		
		if(umur < 10){
			System.out.println("Anak-anak");
		}else if(umur < 20){
			System.out.println("Remaja");
		}else if(umur < 50){
			System.out.println("Dewasa");
		}else{
			System.out.println("Lansia");
		}
	}
}