/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package javari.database;

import java.util.List;
import java.util.ArrayList;
import javari.animal.Animal;
import javari.animal.Body;
import javari.animal.Condition;
import javari.animal.Gender;
import javari.animal.category.Aves;
import javari.animal.category.Mammals;
import javari.animal.category.Reptiles;


public class AnimalDatabase implements Database {

	private final String COMMA = ",";
	private long validAnimal;
	private long invalidAnimal;
	private List<Animal> animalData = new ArrayList<Animal>();

	public long getValidData() {
		return validAnimal;
	}

	public long getInvalidData() {
		return invalidAnimal;
	}


	public List<Animal> getAnimalInType(String animalType) {
		List<Animal> animalInType = new ArrayList<Animal>();

		for (int i = 0; i < animalData.size(); i++) {
			if (animalData.get(i).getType().equals(animalType)) {
				animalInType.add(animalData.get(i));
			}
		}
		return animalInType;
	}

	public boolean dataIsAdded(String dataName) {
		for (int i = 0; i < animalData.size(); i++) {
			if (animalData.get(i).getName().equals(dataName)) {
				return true;
			}
		}
		return false;
	}

	public void addData(List<String> lines) {
		String[] tempLine;

		for (int i = 0; i < lines.size(); i++) {
			tempLine = lines.get(i).split(COMMA);
			processData(tempLine);
		}
	}

	public void processData(String[] tempLine) {
		Integer id = Integer.parseInt(tempLine[0]);
		String type = tempLine[1];
		String name = tempLine[2];
		Gender gender = Gender.parseGender(tempLine[3]);
		double length = Double.parseDouble(tempLine[4]);
		double weight = Double.parseDouble(tempLine[5]);
		String specialStatus = tempLine[6];
		Condition condition = Condition.parseCondition(tempLine[7]);

		if (type.equals("Hamster") || type.equals("Lion")
			|| type.equals("Cat") || type.equals("Whale")) {

			Animal newAnimal = new Mammals(id, type, name, gender,
				length, weight, specialStatus, condition);

			animalData.add(newAnimal);
			validAnimal++;
		} else if (type.equals("Eagle") || type.equals("Parrot")) {

			Animal newAnimal = new Aves(id, type, name, gender,
				length, weight, specialStatus, condition);

			animalData.add(newAnimal);
			validAnimal++;
		} else if (type.equals("Snake")) {

			Animal newAnimal = new Reptiles(id, type, name, gender,
				length, weight, specialStatus, condition);
			
			animalData.add(newAnimal);
			validAnimal++;
		} else {
			invalidAnimal++;
		}
	}
}