/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package javari.data;

import javari.animal.Animal;

public class Category implements Data {
	private String dataName;

	public Category(String dataName) {
		this.dataName = dataName;
	}

	public String getDataType() {
		return "Category";
	}

	public String getDataName() {
		return dataName;
	}

	public boolean canAddData() {
		if (getDataName().equals("mammals")
			|| getDataName().equals("aves")
			|| getDataName().equals("reptiles")) {
			return true;
		}
		return false;
	}

	// public boolean canContain(Animal animal) {
	// 	switch (getDataName()) {
	// 		case "mammals":
	// 			if (animal.getType().equals("Hamster")
	// 				|| animal.getType().equals("Lion")
	// 				|| animal.getType().equals("Cat")
	// 				|| animal.getType().equals("Whale")) {
	// 				return true;
	// 			}
	// 			return false;
	// 		case "aves":
	// 			if (animal.getType().equals("Eagle")
	// 				|| animal.getType().equals("Parrot")) {
	// 				return true;
	// 			}
	// 			return false;
	// 		case "reptiles":
	// 			if (animal.getType().equals("Snake")) {
	// 				return true;
	// 			}
	// 			return false;
	// 	}
	// }
}