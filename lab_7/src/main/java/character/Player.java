/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/
package character;

import java.lang.Math;
import java.util.ArrayList;

public class Player {

	protected String name;
	protected int hp;
	protected boolean isDead = false;
	protected boolean isBurned = false;
	protected boolean hasBeenEaten = false;
	protected boolean isCooked = false;
	protected String type;
	protected String soundRoar = "AAAAAAaaaAAAAAaaaAAAAAA";
	protected ArrayList<Player> eats = new ArrayList<Player>();

	public Player(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setHp(int hp) {
		this.hp = hp;

		if (this.hp <= 0) {
			this.setIsDead(true);
		}
	}

	public int getHp() {
		return hp;
	}

	public String getType() {
		return type;
	}

	public ArrayList<Player> getDiet() {
		return eats;
	}

	public void setIsDead(boolean isDead) {
		this.isDead = isDead;
	}

	public boolean getIsDead() {
		return isDead;
	}

	public void setIsBurned(boolean isBurned) {
		this.isBurned = isBurned;
	}

	public boolean getIsBurned() {
		return isBurned;
	}

	public void setHasBeenEaten(boolean hasBeenEaten) {
		this.hasBeenEaten = hasBeenEaten;
	}

	public boolean getHasBeenEaten() {
		return hasBeenEaten;
	}

	public void setIsCooked(boolean isCooked) {
		this.isCooked = isCooked;
	}

	public boolean getIsCooked() {
		return isCooked;
	}

	public boolean canEat(Player otherPlayer) {
		if (otherPlayer.getIsDead()) {
			if (this.getType() == "Human" && this.getType() == "Magician") {
				if (otherPlayer.getType() == "Monster" && otherPlayer.getIsCooked()) {
					return true;
				} 
				return false;
			} 
			return true;
		}
		return false;
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

	public String burn(Player otherPlayer) {
		String statusMatang = "";

		if (this.getType() == "Magician" && !this.getIsDead() && !otherPlayer.getIsDead()) {
			if (otherPlayer.getType() == "Magician") {
				otherPlayer.setHp(Math.max(0, otherPlayer.getHp()-20));
			} else {
				otherPlayer.setHp(Math.max(0, otherPlayer.getHp()-10));
			}

			if (otherPlayer.getHp() == 0) {
				otherPlayer.setIsCooked(true);
				statusMatang = " \n dan matang";
			}

			return "Nyawa " + otherPlayer.getName() + " " + otherPlayer.getHp() + statusMatang;
		}
		return this.getName() + " tidak bisa membakar " + otherPlayer.getName();
	}

	public String attack(Player otherPlayer) {
		if (!otherPlayer.getIsDead() && !this.getIsDead()) {
			if (otherPlayer.getType() == "Magician") {
				otherPlayer.setHp(Math.max(0, otherPlayer.getHp()-20));
			} else {
				otherPlayer.setHp(Math.max(0, otherPlayer.getHp()-10));
			}
			return "Nyawa " + otherPlayer.getName() + " " + otherPlayer.getHp();
		}
		return this.getName() + " tidak bisa menyerang " + otherPlayer.getName();
	}

	public String eat(Player otherPlayer) {
		this.setHp(this.getHp()+15);
		otherPlayer.setHasBeenEaten(true);
		this.eats.add(otherPlayer);
		return this.getName() + " memakan " + otherPlayer.getName() +
			"\nNyawa " + this.getName() + " kini " + this.getHp();
	}

	public String diet() {
		String allDiet = "";
		for (int i=0; i < eats.size(); i++) {
			allDiet += eats.get(i).getType() + " " + eats.get(i).getName() + "\n";
		}
		return allDiet.substring(0, allDiet.length()-1);
	}

	public String status() {
		String stateDead;
		String eatsWhat;

		if (this.getIsDead()) {
			stateDead = "Sudah meninggal dunia dengan damai";
		} else {
			stateDead = "Masih hidup";
		}

		if (this.eats == null) {
			eatsWhat = "Belum memakan siapa siapa";
		} else {
			eatsWhat = "Memakan ";
			for (int i=0; i < this.eats.size(); i++) {
				eatsWhat += this.eats.get(i).getType() + " " +
					this.eats.get(i).getName() + " ";
			}
		}

		return this.getType() + " " + this.getName() + "\nHP: " + this.getHp()
			+ "\n" + stateDead + "\n" + eatsWhat;
	}
}