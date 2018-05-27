/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package karyawan;

import java.util.ArrayList;

public class Intern extends Karyawan {

	public Intern(String name, double pay) {
		super(name, pay);
		setType("INTERN");
	}

	public String recruit(Karyawan karyawanRec) {
		return "Anda tidak layak memiliki bawahan";
	}

}