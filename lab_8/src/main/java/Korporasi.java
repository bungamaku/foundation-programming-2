/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

import karyawan.*;
import java.util.ArrayList;

public class Korporasi {
	private double payLimitStaff;
	ArrayList<Karyawan> listKaryawan = new ArrayList<Karyawan>();

	public Korporasi(int payLimitStaff) {
		this.payLimitStaff = ((double) payLimitStaff);
	}

	public Karyawan find(String name) {
        for (int i=0; i < listKaryawan.size(); i++) {
            if (listKaryawan.get(i).getName().equals(name)) {
                return listKaryawan.get(i);
            }
        }
        return null;
    }

    public String add(String type, String name, double pay){
        Karyawan karyawan = find(name);
        if (karyawan == null) {
            if (type.equals("MANAGER")) {
                Karyawan newKaryawan = new Manager(name, pay);
                listKaryawan.add(newKaryawan);
            } else if (type.equals("STAFF")) {
                Karyawan newKaryawan = new Staff(name, pay);
                listKaryawan.add(newKaryawan);
            } else if (type.equals("INTERN")) {
                Karyawan newKaryawan = new Intern(name, pay);
                listKaryawan.add(newKaryawan);
            } else {
            	return "Format input salah";
            }
            return name + " mulai bekerja sebagai " + type + " di PT. TAMPAN";
        } 
        return "Karyawan dengan nama " + name + " telah terdaftar";
    }

    public void remove(String name) {
    	Karyawan karyawan = find(name);
    	listKaryawan.remove(karyawan);
    }

    public String status(String name) {
    	Karyawan karyawan = find(name);
    	if (karyawan != null) {
    		return karyawan.getName() + " " + karyawan.getPay();
    	}
		return "Karyawan tidak ditemukan";
	}

	public String recruit(String recruiterName, String recruitedName) {
		Karyawan recruiter = find(recruiterName);
		Karyawan recruited = find(recruitedName);

		if (recruiter != null && recruited != null) {
			return recruiter.recruit(recruited);
		}
		return "Nama tidak berhasil ditemukan";
	}

	public String payDay() {
		return "Semua karyawan telah diberikan gaji";
	}

	public String increaseAllPay() {
		String allPay = "";

		for (int i = 0; i < listKaryawan.size(); i++) {
			Karyawan karyawan = listKaryawan.get(i);
			allPay += karyawan.getName() + " mengalami kenaikan gaji sebesar 10% dari "
				+ karyawan.getPay() + " menjadi " + karyawan.increasePay() + "\n";
		}
		return allPay;
	}

	public String promoteStaff() {
		String allPromote = "";

		for (int i = 0; i < listKaryawan.size(); i++) {
			Karyawan karyawan = listKaryawan.get(i);

			if (karyawan.getType() == "STAFF" && karyawan.getPay() > payLimitStaff) {
				Karyawan newManager = new Manager(karyawan.getName(), karyawan.getPay());
				listKaryawan.add(newManager);
				listKaryawan.remove(karyawan);
				allPromote += "Selamat, " + newManager.getName() + " telah dipromosikan menjadi MANAGER\n";
			}
		}
		return allPromote;
	}
}