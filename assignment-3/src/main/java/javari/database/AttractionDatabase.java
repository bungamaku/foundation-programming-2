/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package javari.database;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javari.data.Data;
import javari.data.Attraction;

public class AttractionDatabase implements Database {

	private final String COMMA = ",";
	private long validAttraction;
	private long invalidAttraction;
	private List<Data> attractionData = new ArrayList<Data>();
	private Map<String, ArrayList<String>> attractionByType = new HashMap<String, ArrayList<String>>();

	public long getValidData() {
		return validAttraction;
	}

	public long getInvalidData() {
		return invalidAttraction;
	}


	public List<Data> getListData() {
		return attractionData;
	}

	public Map<String, ArrayList<String>> getAttractionByType() {
		return attractionByType;
	}

	public boolean dataIsAdded(String dataName) {
		for (int i = 0; i < attractionData.size(); i++) {
			if (attractionData.get(i).getDataName().equals(dataName)) {
				return true;
			}
		}
		return false;
	}

	public void addData(List<String> lines) {
		String[] tempLine;

		for (int i = 0; i < lines.size(); i++) {
			tempLine = lines.get(i).split(COMMA);
			processData(tempLine);
		}
	}

	public void processData(String[] tempLine) {
		String animalType = tempLine[0];
		String attractionName = tempLine[1];
		Data newAttraction = new Attraction(attractionName);

		if (!dataIsAdded(attractionName) && newAttraction.canAddData()) {
			attractionData.add(newAttraction);
			validAttraction++;
		} else if (!newAttraction.canAddData()) {
			invalidAttraction++;
		}

		ArrayList<String> attractionByAnimal = attractionByType.get(animalType);

		if(attractionByAnimal == null) {
	    	attractionByAnimal = new ArrayList<String>();
	    	attractionByAnimal.add(attractionName);
	    	attractionByType.put(animalType, attractionByAnimal);
	    } else {
	    	if(!attractionByAnimal.contains(attractionName)) {
	    		attractionByAnimal.add(attractionName);
	    	}
	    }

	}
}