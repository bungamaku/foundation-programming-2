/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package javari.database;

import java.util.List;


public interface Database {

	long getValidData();

	long getInvalidData();

	boolean dataIsAdded(String dataName);

	void addData(List<String> lines);

	void processData(String[] tempLine);

}