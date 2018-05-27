/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package javari.animal.category;
import javari.animal.Animal;
import javari.animal.Body;
import javari.animal.Condition;
import javari.animal.Gender;

public class Reptiles extends Animal {

	public Reptiles(Integer id, String type, String name, Gender gender, double length,
                  double weight, String specialStatus, Condition condition) {
		super(id, type, name, gender, length, weight, specialStatus, condition);
		setCategory("reptiles");
	}

	public boolean specificCondition() {
		if (getSpecialStatus().equals("wild")) {
			return false;
		}
		return true;
	}
	
}