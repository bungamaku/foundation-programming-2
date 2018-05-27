/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

import java.util.*;
import animal.*;
import cage.*;

public class JavariPark {
	private static Scanner input = new Scanner(System.in);

	private static ArrayList<Animal> cats = new ArrayList<Animal>();
	private static ArrayList<Animal> lions = new ArrayList<Animal>();
	private static ArrayList<Animal> eagles = new ArrayList<Animal>();
	private static ArrayList<Animal> parrots = new ArrayList<Animal>();
	private static ArrayList<Animal> hamsters = new ArrayList<Animal>();
	private static ArrayList<ArrayList<Animal>> animalList = new ArrayList<ArrayList<Animal>>();

	private static ArrayList<Cage> catCages = new ArrayList<Cage>();
	private static ArrayList<Cage> eagleCages = new ArrayList<Cage>();
	private static ArrayList<Cage> hamsterCages = new ArrayList<Cage>();
	private static ArrayList<Cage> parrotCages = new ArrayList<Cage>();
	private static ArrayList<Cage> lionCages = new ArrayList<Cage>();
	private static ArrayList<ArrayList<Cage>> animalCages = new ArrayList<ArrayList<Cage>>();

	public static void main(String[] args) {
		System.out.println("Welcome to Javari Park!");
		inputAnimals();
		cageArrangement();
		visitAnimals();
	} 

	public static void inputAnimals() {
		int tempSum;
		String tempInput;
		String[] tempInfo = new String[2];
		String[] animals = {"cat", "lion", "eagle", "parrot", "hamster"};

		System.out.println("Input the number of animals");

		for (int i = 0; i < animals.length; i++) {
			System.out.format("%s: ", animals[i]);
			tempSum = input.nextInt();
			String[] arrInput = new String[tempSum];

			if (tempSum > 0) {
				System.out.format("Provide the information of %s(s):\n", animals[i]);
				tempInput = input.next();

				if (tempSum == 1) {
					arrInput[0] = tempInput;
				} else {
					arrInput = tempInput.split(",");
				}

				for (int j = 0; j < tempSum; j++) {
					tempInfo = arrInput[j].split("\\|");
					String name = tempInfo[0];
					int length = Integer.valueOf(tempInfo[1]);
					switch(i) {
						case 0 : 
							Animal newCat = new Cat(name, length);
							cats.add(newCat);
							break;
						case 1 : 
							Animal newLion = new Lion(name, length);
							lions.add(newLion);
							break;
						case 2 : 
							Animal newEagle = new Eagle(name, length);
							eagles.add(newEagle);
							break;
						case 3 : 
							Animal newParrot = new Parrot(name, length);
							parrots.add(newParrot);
							break;
						case 4 : 
							Animal newHamster = new Hamster(name, length);
							hamsters.add(newHamster);
							break;
					}
				}
			} else {
				continue;
			}
		}

		animalList.add(cats);
		animalList.add(eagles);
		animalList.add(hamsters);
		animalList.add(parrots);
		animalList.add(lions);

		System.out.println("Animals have been successfully recorded!\n\n" + 
			"=============================================\n");
	}

	public static void cageArrangement() {
		String[] animals = {"cat", "eagle", "hamster", "parrot", "lion"};

		for (int k = 0; k < animals.length; k++) {
			ArrayList<Animal> tempAnimalList = animalList.get(k);
			for (int i = 0; i < tempAnimalList.size(); i++) {
				switch(k) {
					case 0 : 
						Cage newCatCage = new Cage(tempAnimalList.get(i));
						catCages.add(newCatCage);
						break;
					case 1 : 
						Cage newEagleCage = new Cage(tempAnimalList.get(i));
						eagleCages.add(newEagleCage);
						break;
					case 2 : 
						Cage newHamsterCage = new Cage(tempAnimalList.get(i));
						hamsterCages.add(newHamsterCage);
						break;
					case 3 : 
						Cage newParrotCage = new Cage(tempAnimalList.get(i));
						parrotCages.add(newParrotCage);
						break;
					case 4 : 
						Cage newLionCage = new Cage(tempAnimalList.get(i));
						lionCages.add(newLionCage);
						break;
				}
			}
		}

		animalCages.add(catCages);
		animalCages.add(eagleCages);
		animalCages.add(hamsterCages);
		animalCages.add(parrotCages);
		animalCages.add(lionCages);

		System.out.println("Cage arrangement:");

		arrangement();

		System.out.println("NUMBER OF ANIMALS:");

		for (int i = 0; i < animals.length; i++) {
			System.out.format("%s:%d\n", animals[i], animalList.get(i).size());
		}

		System.out.println("\n=============================================");
	}

	public static void arrangement() {
		String[] animals = {"cat", "eagle", "hamster", "parrot", "lion"};

		for (int k = 0; k < animals.length; k++) {
			ArrayList<Cage> tempAnimalCage = animalCages.get(k);
			System.out.format("location: %s\n", tempAnimalCage.get(0).getCageLoc());
			int sumCages = tempAnimalCage.size();

			for (int i = 3; i > 0; i--) {
				System.out.format("level %d: ", i);
				for (int j = 0; j < sumCages/3; j++){
					System.out.print(tempAnimalCage.get(3*(i-1)+j).getCageInfo());
				}
				
				if (sumCages % 3 == 1) {
					if (i == 3) {
						System.out.print(tempAnimalCage.get(sumCages-1).getCageInfo());
					}
				}

				if (sumCages % 3 == 2) {
					if (i == 2) {
						System.out.print(tempAnimalCage.get(sumCages-1).getCageInfo());
					} else if (i == 1) {
						System.out.print(tempAnimalCage.get(sumCages-2).getCageInfo());
					}
				}
				System.out.println();
			}

			System.out.println("\nAfter rearrangement...");
			int[] rearr = new int[] {3, 1, 2};

			for (int i = 2; i > -1; i--) {
				System.out.format("level %d: ", i+1);

				if (sumCages % 3 == 1) {
					if (rearr[i] == 3) {
						System.out.print(tempAnimalCage.get(sumCages-1).getCageInfo());
					}
				}

				if (sumCages % 3 == 2) {
					if (rearr[i] == 2) {
						System.out.print(tempAnimalCage.get(sumCages-1).getCageInfo());
					} else if (rearr[i] == 1) {
						System.out.print(tempAnimalCage.get(sumCages-2).getCageInfo());
					}
				}

				for (int j = sumCages/3-1; j >= 0; j--){
					System.out.print(tempAnimalCage.get(3*(rearr[i]-1)+j).getCageInfo());
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void visitAnimals() {
		String[] animals = {"cat", "eagle", "hamster", "parrot", "lion"};
		int visitedLoc = -1;

		while(true) {
			System.out.println("Which animal you want to visit?\n" + 
				"(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99: Exit)");

			int visitedCages = input.nextInt();

			if (visitedCages == 99) {
				break;
			}

			System.out.format("Mention the name of %s you want to visit: ", animals[visitedCages-1]);

			String visitedName = input.next();
			ArrayList<Animal> visitedAnimals = animalList.get(visitedCages-1);

			for (int i = 0; i < visitedAnimals.size(); i++) {
				if (visitedName == visitedAnimals.get(i).getName()) {
					visitedLoc = i;
					break;
				}
			}

			if (visitedLoc == -1) {
				System.out.format("There is no %s with that name! Back to the office!\n", animals[visitedCages-1]);
				continue;
			}

			Animal visitedAnimal = visitedAnimals.get(visitedLoc);

			System.out.format("You are visiting %s (%s) now, what would you like to do?\n", visitedAnimal.getName(), animals[visitedCages-1]);

			for (int i = 0; i < visitedAnimal.getActions().length; i++) {
				System.out.format("%d: %s ", i, visitedAnimal.getActions()[i]);		
			}

			System.out.println();
			int command = input.nextInt()-1;

			visitedAnimal.doAction(command);
			
			System.out.println("Back to the office!\n");
		}
	}
}

