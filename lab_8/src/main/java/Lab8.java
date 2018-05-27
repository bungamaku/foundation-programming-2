/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

import java.util.Scanner;

class Lab8 {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	int payCounter = 0;

    	int payLimitStaff = input.nextInt();
    	input.nextLine();
    	Korporasi korporasi = new Korporasi(payLimitStaff);

    	while(true) {
    		String[] commands = input.nextLine().split(" ");

    		switch (commands[0]) {
    			case "TAMBAH_KARYAWAN":
    				System.out.println(
    					korporasi.add(commands[1], commands[2], Double.parseDouble(commands[3])));
    				break;
    			case "STATUS":
    				System.out.println(korporasi.status(commands[1]));
    				break;
    			case "TAMBAH_BAWAHAN":
    				System.out.println(korporasi.recruit(commands[1], commands[2]));
    				break;
    			case "GAJIAN":
    				System.out.println(korporasi.payDay());
    				payCounter++;

	    			if(payCounter == 6) {
	    				System.out.print(korporasi.increaseAllPay());
	    				System.out.print(korporasi.promoteStaff());
	    				payCounter = 0;
	    			}
	    			break;
	    		default:
	    			System.out.println("Input yang anda masukkan salah");
    		}

    		// if(commands[0] .equals("TAMBAH_KARYAWAN")) {
    		// 	System.out.println(korporasi.add(commands[1], commands[2], Integer.parseInt(commands[3])));
    		// } else if(commands[0].equals("STATUS")) {
    		// 	System.out.println(korporasi.status(commands[1]));
    		// } else if(commands[0].equals("TAMBAH_BAWAHAN")) {
    		// 	System.out.println(korporasi.recruit(commands[1], commands[2]));
    		// } else if(commands[0].equals("GAJIAN")) {
    		// 	System.out.println(korporasi.payDay());
    		// 	payCounter++;

    		// 	if(payCounter == 6) {
    		// 		System.out.println(korporasi.increaseAllPay());
    		// 		System.out.print(korporasi.promoteStaff());
    		// 		payCounter = 0;
    		// 	}
    		// } else {
    		// 	System.out.println("Input yang anda masukkan salah");
    		// }
    	}
    }
}