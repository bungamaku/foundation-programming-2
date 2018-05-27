/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import javari.data.*;
import javari.database.*;
import javari.animal.*;
import javari.park.*;
import javari.reader.CsvReader;
// import javari.writer.RegistrationWriter;

public class A3Festival {
	static CategoryDatabase categoryDatabase = new CategoryDatabase();
	static SectionDatabase sectionDatabase = new SectionDatabase();
	static AttractionDatabase attractionDatabase = new AttractionDatabase();
	static AnimalDatabase animalDatabase = new AnimalDatabase();

	public static void inputData(Path categoriesPath,
		Path attractionsPath, Path recordsPath) throws IOException {

		CsvReader readAnimalCategories = new CsvReader(categoriesPath);
		CsvReader readAnimalAttractions = new CsvReader(attractionsPath);
		CsvReader readAnimalRecords = new CsvReader(recordsPath);

		categoryDatabase.addData(readAnimalCategories.getLines());
		sectionDatabase.addData(readAnimalCategories.getLines());
		attractionDatabase.addData(readAnimalAttractions.getLines());
		animalDatabase.addData(readAnimalRecords.getLines());

		System.out.println("\n\n... Loading... Success... System is populating data...\n");
		System.out.format("Found %d valid sections and %d invalid sections\n",
			sectionDatabase.getValidData(), sectionDatabase.getInvalidData());
		System.out.format("Found %d valid attractions and %d invalid attractions\n",
			attractionDatabase.getValidData(), attractionDatabase.getInvalidData());
		System.out.format("Found %d valid animal categories and %d invalid animal categories\n",
			categoryDatabase.getValidData(), categoryDatabase.getInvalidData());
		System.out.format("Found %d valid animal records and %d invalid animal records\n",
			animalDatabase.getValidData(), animalDatabase.getInvalidData());
	}

	public static void selectSection() {
		System.out.format("\nJavari Park has %d sections:\n", sectionDatabase.getValidData());

		List<Data> sections = sectionDatabase.getListData();

		for (int i = 0; i < sections.size(); i++) {
			System.out.format(i + 1 + ". " + sections.get(i).getDataName() + "\n");
		}

		System.out.print("Please choose your preferred section (type the number): ");
	}

	public static void selectAnimal(int command) {
		Data selectedSection = sectionDatabase.getListData().get(command-1);
		Map<String, ArrayList<String>> sectionContents = sectionDatabase.getSectionContents();
		List<String> animalsInSection = sectionContents.get(selectedSection.getDataName());

		System.out.format("\n--%s--\n", selectedSection.getDataName());

		for (int i = 0; i < animalsInSection.size(); i++) {
			System.out.format(i + 1 + ". " + animalsInSection.get(i) + "\n");
		}

		System.out.print("Please choose your preferred animals (type the number): ");
	}

	public static String getSelectedType(int command) {
		Data selectedSection = sectionDatabase.getListData().get(command);
		return sectionDatabase.getSectionContents().get(selectedSection.getDataName()).get(command);
	}

	public static List<Animal> checkSelectedAnimal(int command) {
		String selectedAnimalType = getSelectedType(command-1);
		List<Animal> animalInType = animalDatabase.getAnimalInType(selectedAnimalType);
		List<Animal> checkedAnimal = new ArrayList<Animal>();

		if (animalInType != null) {
			for (int i = 0; i < animalInType.size(); i++) {
				if (animalInType.get(i).getCondition() == Condition.HEALTHY
					&& animalInType.get(i).specificCondition()) {
					checkedAnimal.add(animalInType.get(i));
				} 
			}
		}
		return checkedAnimal;
	}

	public static void selectAttraction(int command, List<Animal> checkedAnimal) {
		String selectedAnimalType = getSelectedType(command-1);
		Map<String, ArrayList<String>> attractionByType = attractionDatabase.getAttractionByType();
		List<String> attractionByAnimal = attractionByType.get(selectedAnimalType);

		System.out.format("\n--%s--\nAttractions by %s:\n", selectedAnimalType, selectedAnimalType);

		for (int i = 0; i < attractionByAnimal.size(); i++) {
			System.out.format(i + 1 + ". " + attractionByAnimal.get(i) + "\n");
		}

		System.out.print("Please choose your preferred attractions (type the number): ");

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String defaultPath = "C:\\Users\\Fia\\ddp2\\tp\\assignment-3\\data";

		System.out.print("Welcome to Javari Park Festival - Registration Service!\n\n"
			+ "... Opening default section database from data.");

		Path defCategoriesPath = Paths.get(defaultPath + "\\animals_categories.csv");
		Path defAttractionsPath = Paths.get(defaultPath + "\\animals_attractions.csv");
		Path defRecordsPath = Paths.get(defaultPath + "\\animals_records.csv");

		try {
			inputData(defCategoriesPath, defAttractionsPath, defRecordsPath);
		} catch (IOException e0) {
			int doneRead = 0;

			while (doneRead == 0) {
				System.out.println(" ... File not found or incorrect file!\n\n"
					+ "Please provide the source data path: ");

				String dataPath = input.nextLine();

				Path categoriesPath = Paths.get(dataPath + "\\animals_categories.csv");
				Path attractionsPath = Paths.get(dataPath + "\\animals_attractions.csv");
				Path recordsPath = Paths.get(dataPath + "\\animals_records.csv");

				try {
					inputData(categoriesPath, attractionsPath, recordsPath);
				} catch (IOException e1) {
					continue;
				}
			}
		}

		System.out.println("\nWelcome to Javari Park Festival - Registration Service!\n\n"
			+ "Please answer the questions by typing the number. "
			+ "Type # if you want to return to the previous menu");

		int state = 0;
		String commandSection = "";
		String commandAnimal = "";
		String commandAttraction = "";
		List<Animal> checkedAnimal = new ArrayList<Animal>();

		while (true) {

			if (state == 0) {
				selectSection();
				commandSection = input.nextLine();
				if (!commandSection.equals("#")) {
					state++;
				}
			} else if (state == 1) {
				selectAnimal(Integer.parseInt(commandSection));
		 		commandAnimal = input.nextLine();
		 		if (commandAnimal.equals("#")) {
					state--;
				} else {
					state++;
				}
			} else if (state == 2) {
				checkedAnimal = checkSelectedAnimal(Integer.parseInt(commandAnimal));

				if (checkedAnimal == null) {
					System.out.println("Unfortunately, no " 
						+ getSelectedType(Integer.parseInt(commandAnimal))
						+ " can perform any attraction, please choose other animals");
					state--;
				} else {
					selectAttraction(Integer.parseInt(commandAnimal), checkedAnimal);
					commandAttraction = input.nextLine();
					if (commandAttraction.equals("#")) {
						state--;
					} else {
						state++;
					}
				}
			}
		}
	}
}