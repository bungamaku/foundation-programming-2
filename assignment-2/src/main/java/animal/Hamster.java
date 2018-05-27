/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package animal;

import java.text.MessageFormat;

public class Hamster extends Animal {

	public Hamster(String name, int length) {
		super(name, length);
		this.isWild = false;
		this.actions = new String[] {"See it gnawing", "Order to run in the hamster wheel"};
	}

	public void Gnaw() {
		String text = MessageFormat.format("{0} makes a voice: ngkkrit.. ngkkrrriiit", getName());
		System.out.println(text);
	}

	public void Run() {
		String text = MessageFormat.format("{0} makes a voice:  trrr... trrr...", getName());
		System.out.println(text);
	}

	public void doAction(int command) {
		if (command == 1) {
			Gnaw();
		} else if (command == 2) {
			Run();
		} else {
			System.out.println("You do nothing...");
		}
	}

}