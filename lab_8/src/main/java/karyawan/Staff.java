/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package karyawan;

import java.util.ArrayList;

public class Staff extends Karyawan {
	private ArrayList<Karyawan> subordinates = new ArrayList<Karyawan>();

	public Staff(String name, double pay) {
		super(name, pay);
		setType("STAFF");
	}

	public String recruit(Karyawan karyawanRec) {
		for (int i = 0; i < subordinates.size(); i++) {
			if (subordinates.get(i).getName() == karyawanRec.getName()) {
				return "Karyawan " + karyawanRec.getName() + 
					" telah menjadi bawahan " + getName();
			}
		}

		if (subordinates.size() < 10 && karyawanRec.getType() == "INTERN") {
			subordinates.add(karyawanRec);
			return "Karyawan " + karyawanRec.getName() +
				" berhasil ditambahkan menjadi bawahan " + getName();
		}
		return "Anda tidak layak memiliki bawahan";
	}

}