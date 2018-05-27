/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package character;

public class Monster extends Player {

	protected String soundRoar = "AAAAAAaaaAAAAAaaaAAAAAA";

	public Monster(String name, int hp) {
		super(name, hp);
		this.hp = hp * 2;
		this.type = "Monster";
	}

	public void setRoar(String soundRoar) {
		if (this.getType() == "Monster") {
			this.soundRoar = soundRoar;
		}
	}

	public String roar() {
		if (this.getType() == "Monster") {
			return soundRoar;
		}
		return "";
	}
}
