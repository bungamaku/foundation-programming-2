/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package javari.database;

import java.util.List;
import java.util.ArrayList;
import javari.data.Data;
import javari.data.Category;

public class CategoryDatabase implements Database {

	private final String COMMA = ",";
	private long validCategory;
	private long invalidCategory;
	private List<Data> categoryData = new ArrayList<Data>();

	public long getValidData() {
		return validCategory;
	}

	public long getInvalidData() {
		return invalidCategory;
	}


	public List<Data> getListData() {
		return categoryData;
	}

	public boolean dataIsAdded(String dataName) {
		for (int i = 0; i < categoryData.size(); i++) {
			if (categoryData.get(i).getDataName().equals(dataName)) {
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
		String categoryName = tempLine[1];
		Data newCategory = new Category(categoryName);

		if (!dataIsAdded(categoryName) && newCategory.canAddData()) {
			categoryData.add(newCategory);
			validCategory++;
		} else if (!newCategory.canAddData()) {
			invalidCategory++;
		}
	}
}