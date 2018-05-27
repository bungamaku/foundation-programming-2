/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package javari.animal.category;
import javari.animal.Animal;
import javari.animal.Body;
import javari.animal.Condition;
import javari.animal.Gender;

public class Mammals extends Animal {

	public Mammals(Integer id, String type, String name, Gender gender, double length,
                  double weight, String specialStatus, Condition condition) {
		super(id, type, name, gender, length, weight, specialStatus, condition);
		setCategory("mammals");
	}

	public boolean specificCondition() {
		if (getSpecialStatus().equals("pregnant")) {
			return false;
		} else if (getType().equals("Lion") && getGender() == Gender.FEMALE) {
			return false;
		}
		return true;
	}

}