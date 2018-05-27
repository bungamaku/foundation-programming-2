import java.util.Scanner;

/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

public class BingoCard {

	private Number[][] numbers;
	private Number[] numberStates; 
	private boolean isBingo;
	
	public BingoCard(Number[][] numbers, Number[] numberStates) {
		this.numbers = numbers;
		this.numberStates = numberStates;
		this.isBingo = false;
	}

	public Number[][] getNumbers() {
		return numbers;
	}

	public void setNumbers(Number[][] numbers) {
		this.numbers = numbers;
	}

	public Number[] getNumberStates() {
		return numberStates;
	}

	public void setNumberStates(Number[] numberStates) {
		this.numberStates = numberStates;
	}	

	public boolean isBingo() {
		return isBingo;
	}

	public void setBingo(boolean isBingo) {
		this.isBingo = isBingo;
	}

	public void checkBingo() {
		int checkRow = 0;
		int checkColumn = 0;
		int checkDiagonal = 0;

		for (int i = 0; i < 5; i++) {
			if (this.numbers[i][i].isChecked()) {
				checkDiagonal += 1;
			}

			for (int j = 0; j < 5; j++) {
				if (this.numbers[i][j].isChecked()) {
					checkRow += 1;
				}
				if (this.numbers[j][i].isChecked()) {
					checkColumn += 1;
				}
			}

			if (checkRow == 5 || checkColumn == 5) {
				setBingo(true);
			}
			checkRow = 0;
			checkColumn = 0;
		}

		if (checkDiagonal == 5) {
			setBingo(true);
		}
		checkDiagonal = 0;

		for (int i = 0, j = 4; i < 5; i++, j--) {
			if (this.numbers[i][j].isChecked()) {
				checkDiagonal += 1;
			}
		}

		if (checkDiagonal == 5) {
			setBingo(true);
		}
	}

	public String markNum(int num){
		if (this.numberStates[num] == null) {
			return "Kartu tidak memiliki angka " + num;
		} else if (!this.numberStates[num].isChecked()) {
			this.numberStates[num].setChecked(true);
			checkBingo();
			return num + " tersilang";
		} else {
			return num + " sebelumnya sudah tersilang";
		}
	}	
	
	public String info(){
		String tmp = "";
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (!this.numbers[i][j].isChecked()) {
					tmp += "| " + this.numbers[i][j].getValue() + " ";
				} else {
					tmp += "| X  ";
				}
			}
			tmp += "|\n";
		}
		return tmp.substring(0, tmp.length()-1);
	}
	
	public void restart(){
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.numbers[i][j].setChecked(false);
			}
		}
		System.out.println("Mulligan!");
	}

	public static void main(String[] args) {
		Number[][] Play = new Number[5][5];
		Number[] PlayStates = new Number[100];
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					int inputNumber = input.nextInt();
					Play[i][j] = new Number(inputNumber, i, j);
					PlayStates[inputNumber] = Play[i][j];
				}
			}

		BingoCard PlayBingo = new BingoCard(Play, PlayStates);

		while (!PlayBingo.isBingo()) {
			String[] inputCommand = input.nextLine().split(" ");
			
			if (inputCommand[0].equals("MARK")) {
				System.out.println(PlayBingo.markNum(Integer.parseInt(inputCommand[1])));
			} else if (inputCommand[0].equals("INFO")) {
				System.out.println(PlayBingo.info());
			} else if (inputCommand[0].equals("RESTART")) {
				PlayBingo.restart();
			}
		}
		System.out.println("BINGO!");
		System.out.println(PlayBingo.info());
	}
}