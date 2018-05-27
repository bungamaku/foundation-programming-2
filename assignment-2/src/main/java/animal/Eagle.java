/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package animal;

import java.text.MessageFormat;

public class Eagle extends Animal {

	public Eagle(String name, int length) {
		super(name, length);
		this.isWild = true;
		this.actions = new String[] {"Order to fly"};
	}

	public void Fly() {
		String text = MessageFormat.format("{0} makes a voice: kwaakk...\nYou hurt!", getName());
		System.out.println(text);
	}

	public void doAction(int command) {
		if (command == 1) {
			Fly();
		} else {
			System.out.println("You do nothing...");
		}
	}
	
}