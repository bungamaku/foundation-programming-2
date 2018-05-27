/**	
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package cage;

import animal.Animal;

public class Cage {
	private Animal animal;
	private String cageType;
	private String cageInfo;
	private String cageLoc;

	public Cage(Animal animal) {
		if (!animal.getIsWild()) {
			this.cageLoc = "indoor";
			if (animal.getLength() < 45) {
				this.cageType = "A";
			} else if (animal.getLength() < 60) {
				this.cageType = "B";
			} else {
				this.cageType = "C";
			}
		} else {
			this.cageLoc = "outdoor";
			if (animal.getLength() < 75) {
				this.cageType = "A";
			} else if (animal.getLength() < 90) {
				this.cageType = "B";
			} else {
				this.cageType = "C";
			}
		}
		setCageInfo(animal, this.cageType);
	}

	public void setCageInfo(Animal animal, String cageType) {
		this.cageInfo = String.format("%s (%d - %s), ", animal.getName(), animal.getLength(), cageType);
	}

	public String getCageInfo() {
		return cageInfo;
	}

	public String getCageLoc() {
		return cageLoc;
	}

}