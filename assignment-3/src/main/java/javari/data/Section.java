/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package javari.data;

import java.util.List;
import java.util.ArrayList;
import javari.animal.Animal;

public class Section implements Data {
	private String dataName;
	private List<String> content = new ArrayList<String>();

	public Section(String dataName) {
		this.dataName = dataName;
	}

	public String getDataType() {
		return "Sections";
	}

	public String getDataName() {
		return dataName;
	}

	public List<String> getContent() {
		return content;
	}

	public void setContent(String animalType) {
		content.add(animalType);
	}

	public boolean canAddData() {
		if (getDataName().equals("Explore the Mammals")
			|| getDataName().equals("World of Aves")
			|| getDataName().equals("Reptillian Kingdom")) {
			return true;
		}
		return false;
	}

	// public boolean canContain(Animal animal) {
	// 	switch (getDataName()) {
	// 		case "Explore the Mammals":
	// 			if (animal.getType().equals("Hamster")
	// 				|| animal.getType().equals("Lion")
	// 				|| animal.getType().equals("Cat")
	// 				|| animal.getType().equals("Whale")) {
	// 				return true;
	// 			}
	// 			return false;
	// 		case "World of Aves":
	// 			if (animal.getType().equals("Eagle")
	// 				|| animal.getType().equals("Parrot")) {
	// 				return true;
	// 			}
	// 			return false;
	// 		case "Reptillian Kingdom":
	// 			if (animal.getType().equals("Snake")) {
	// 				return true;
	// 			}
	// 			return false;
	// 	}
	// }
}