/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package animal;

public abstract class Animal {

	protected String name;
	protected int length;
	protected boolean isWild;
	protected String[] actions;

	public Animal(String name, int length) {
		this.name = name;
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public int getLength() {
		return length;
	}

	public boolean getIsWild() {
		return isWild;
	}

	public String[] getActions() {
		return actions;
	}

	public abstract void doAction(int command); 
}