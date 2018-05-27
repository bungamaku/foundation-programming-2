/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package lab9.event;

import java.util.Comparator;

public class EventComparator implements Comparator<Event> {

	public int compare(Event self, Event other) {
        return self.getStartTime().compareTo(other.getStartTime());
    }
}