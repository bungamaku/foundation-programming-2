/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package javari.database;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javari.data.Data;
import javari.data.Section;

public class SectionDatabase implements Database {

	private final String COMMA = ",";
	private long validSection;
	private long invalidSection;
	private List<Data> sectionData = new ArrayList<Data>();
	private Map<String, ArrayList<String>> sectionContents = new HashMap<String, ArrayList<String>>();

	public long getValidData() {
		return validSection;
	}

	public long getInvalidData() {
		return invalidSection;
	}


	public List<Data> getListData() {
		return sectionData;
	}

	public Map<String, ArrayList<String>> getSectionContents() {
		return sectionContents;
	}

	public boolean dataIsAdded(String dataName) {
		for (int i = 0; i < sectionData.size(); i++) {
			if (sectionData.get(i).getDataName().equals(dataName)) {
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
		String sectionName = tempLine[2];
		Data newSection = new Section(sectionName);

		if (!dataIsAdded(sectionName) && newSection.canAddData()) {
			sectionData.add(newSection);
			validSection++;
		} else if (!newSection.canAddData()) {
			invalidSection++;
		}

		ArrayList<String> animalsInSection = sectionContents.get(sectionName);

	    if(animalsInSection == null) {
	    	animalsInSection = new ArrayList<String>();
	    	animalsInSection.add(animalType);
	    	sectionContents.put(sectionName, animalsInSection);
	    } else {
	    	if(!animalsInSection.contains(animalType)) {
	    		animalsInSection.add(animalType);
	    	}
	    }
	}
}