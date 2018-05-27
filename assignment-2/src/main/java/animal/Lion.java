/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package animal;

import java.text.MessageFormat;

public class Lion extends Animal {

	public Lion(String name, int length) {
		super(name, length);
		this.isWild = true;
		this.actions = new String[] {"See it hunting", "Brush the mane", "Disturb it"};
	}

	public void Hunt() {
		String text = MessageFormat.format("Lion is hunting..\n{0} makes a voice: err...!", getName());
		System.out.println(text);
	}

	public void Brush() {
		String text = MessageFormat.format("Clean the lion’s mane..\n{0} makes a voice: Hauhhmm!", getName());
		System.out.println(text);
	}

	public void Disturb() {
		String text = MessageFormat.format("{0} makes a voice: HAUHHMM!", getName());
		System.out.println(text);
	}

	public void doAction(int command) {
		if (command == 1) {
			Hunt();
		} else if (command == 2) {
			Brush();
		} else if (command == 3) {
			Disturb();
		} else {
			System.out.println("You do nothing...");
		}
	}

}