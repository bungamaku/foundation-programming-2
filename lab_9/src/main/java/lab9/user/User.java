/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package lab9.user;

import lab9.event.EventComparator;
import lab9.event.Event;
import java.util.ArrayList;
import java.util.Collections;
import java.math.BigInteger;

/**
* Class representing a user, willing to attend event(s)
*/

public class User {
    /** Name of user */
    private String name;
    
    /** List of events this user plans to attend */
    private ArrayList<Event> events;
    private BigInteger totalCost = BigInteger.valueOf(0);
    
    /**
    * Constructor
    * Initializes a user object with given name and empty event list
    */
    public User(String name) {
        this.name = name;
        this.events = new ArrayList<>();
    }
    
    /**
    * Accessor for name field
    * @return name of this instance
    */
    public String getName() {
        return name;
    }
    
    /**
    * Adds a new event to this user's planned events, if not overlapping
    * with currently planned events.
    *
    * @return true if the event if successfully added, false otherwise
    */

    public boolean addEvent(Event newEvent) {
        for (Event oldEvent : events) {
            if (newEvent.overlapsWith(oldEvent)) {
                return false;
            }
        }
        events.add(newEvent);
        return true;
    }

    /**
    * Returns the list of events this user plans to attend,
    * Sorted by their starting time.
    * Note: The list returned from this method is a copy of the actual
    *       events field, to avoid mutation from external sources
    *
    * @return list of events this user plans to attend
    */

    public ArrayList<Event> getEvents() {
        ArrayList<Event> newEvents = new ArrayList<>(events);
        Collections.sort(newEvents, new EventComparator());
        return newEvents;
    }

    public BigInteger getTotalCost() {
        for (Event event : events) {
            totalCost = totalCost.add(event.getCost());
        }

        return totalCost;
    }
}
