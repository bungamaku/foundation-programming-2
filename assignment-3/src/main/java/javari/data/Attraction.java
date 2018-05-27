/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package javari.data;

// import java.util.List;
// import java.util.ArrayList;
import javari.animal.Animal;

public class Attraction implements Data {
	private String dataName;
	// private List<Animal> performers = new ArrayList<Animal>();

	public Attraction(String dataName) {
		this.dataName = dataName;
	}

	public String getDataType() {
		return "Attractions";
	}

	public String getDataName() {
		return dataName;
	}

	// public List<Animal> getPerformers() {
	// 	return performers;
	// }

	public boolean canAddData() {
		if (getDataName().equals("Circles of Fires")
			|| getDataName().equals("Dancing Animals")
			|| getDataName().equals("Counting Masters")
			|| getDataName().equals("Passionate Coders")) {
			return true;
		}
		return false;
	}

	// public void addPerformer(Animal performer) {
	// 	switch (getDataName()) {
	// 		case "Circles of Fires":
	// 			if (performer.getType().equals("Whale")
	// 				|| performer.getType().equals("Lion")
	// 				|| performer.getType().equals("Eagle")) {
	// 				performers.add(performer);
	// 			}
	// 			break;
	// 		case "Dancing Animals":
	// 			if (performer.getType().equals("Cat")
	// 				|| performer.getType().equals("Snake")
	// 				|| performer.getType().equals("Parrot")
	// 				|| performer.getType().equals("Hamster")) {
	// 				performers.add(performer);
	// 			}
	// 			break;
	// 		case "Counting Masters":
	// 			if (performer.getType().equals("Hamster")
	// 				|| performer.getType().equals("Whale")
	// 				|| performer.getType().equals("Parrot")) {
	// 				performers.add(performer);
	// 			}
	// 			break;
	// 		case "Passionate Coders":
	// 			if (performer.getType().equals("Cat")
	// 				|| performer.getType().equals("Hamster")
	// 				|| performer.getType().equals("Snake")) {
	// 				performers.add(performer);
	// 			}
	// 			break;
	// 	}
	// }

	// public boolean canContain(Animal animal) {
	// 	switch (getDataName()) {
	// 		case "Circles of Fires":
	// 			if (animal.getType().equals("Whale")
	// 				|| animal.getType().equals("Lion")
	// 				|| animal.getType().equals("Eagle")) {
	// 				return true;
	// 			}
	// 			return false;
	// 		case "Dancing Animals":
	// 			if (animal.getType().equals("Cat")
	// 				|| animal.getType().equals("Snake")
	// 				|| animal.getType().equals("Parrot")
	// 				|| animal.getType().equals("Hamster")) {
	// 				return true;
	// 			}
	// 			return false;
	// 		case "Counting Masters":
	// 			if (animal.getType().equals("Hamster")
	// 				|| animal.getType().equals("Whale")
	// 				|| animal.getType().equals("Parrot")) {
	// 				return true;
	// 			}
	// 			return false;
	// 		case "Passionate Coders":
	// 			if (animal.getType().equals("Cat")
	// 				|| animal.getType().equals("Hamster")
	// 				|| animal.getType().equals("Snake")) {
	// 				return true;
	// 			}
	// 			return false;
	// 	}
	// }
}