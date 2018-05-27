/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package karyawan;

import java.util.ArrayList;

public class Manager extends Karyawan {
	private ArrayList<Karyawan> subordinates = new ArrayList<Karyawan>();

	public Manager(String name, double pay) {
		super(name, pay);
		setType("MANAGER");
	}

	public String recruit(Karyawan karyawanRec) {
		for (int i = 0; i < subordinates.size(); i++) {
			if (subordinates.get(i).getName() == karyawanRec.getName()) {
				return "Karyawan " + karyawanRec.getName() + 
					" telah menjadi bawahan " + getName();
			}
		}

		if (subordinates.size() < 10 && karyawanRec.getType() != "MANAGER") {
			subordinates.add(karyawanRec);
			return "Karyawan " + karyawanRec.getName() +
				" berhasil ditambahkan menjadi bawahan " + getName();
		}
		return "Anda tidak layak memiliki bawahan";
	}

}