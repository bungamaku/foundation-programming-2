/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package karyawan;

public abstract class Karyawan {
	private String name;
	private String type;
	private double pay;

	public Karyawan(String name, double pay) {
		this.name = name;
		this.pay = pay;
	}

	public String getName() {
		return name;
	}

	public double getPay() {
		return pay;
	}

	public double increasePay() {
		this.pay += pay/10;
		return pay;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public abstract String recruit(Karyawan karyawanRec);
}