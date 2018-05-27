/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/
package animal;

import java.util.Random;
import java.text.MessageFormat;

public class Cat extends Animal {

	public Cat(String name, int length) {
		super(name, length);
		this.isWild = false;
		this.actions = new String[] {"Brush the fur", "Cuddle"};
	}

	public void Brush() {
		String text = MessageFormat.format("Time to clean {0}'s fur\n{0} makes a voice: Nyaaan...", getName());
		System.out.println(text);
	}

	public void Cuddle() {
		String[] cuddles = {"Miaaaw..", "Purrr..", "Mwaw!", "Mraaawr!"};
		Random random = new Random();
		int intRandom = random.nextInt(4);
		String text = MessageFormat.format("{0} makes a voice: {1}", getName(), cuddles[intRandom]);
		System.out.println(text);
	}

	public void doAction(int command) {
		if (command == 1) {
			Brush();
		} else if (command == 2) {
			Cuddle();
		} else {
			System.out.println("You do nothing...");
		}
	}

}