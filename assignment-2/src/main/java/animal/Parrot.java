/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package animal;

import java.text.MessageFormat;
import java.util.*;

public class Parrot extends Animal {

	public Parrot(String name, int length) {
		super(name, length);
		this.isWild = false;
		this.actions = new String[] {"Order to fly", "Do conversation"};
	}

	public void Fly() {
		String text = MessageFormat.format("Parrot {0} flies!\n{0} makes a voice: FLYYYY...", getName());
		System.out.println(text);
	}

	public void Conversation() {
		System.out.println("You say: ");
		Scanner input = new Scanner(System.in);
		String say = input.next();
		String text = MessageFormat.format("{0} says: {1}", getName(), say.toUpperCase());
		System.out.println(text);
	}

	public void doAction(int command) {
		if (command == 1) {
			Fly();
		} else if (command == 2) {
			Conversation();
		} else {
			System.out.println("You do nothing...");
		}
	}

}