/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package lab9;

import lab9.user.User;
import lab9.event.Event;

import java.util.ArrayList;

/**
* Class representing event managing system
*/
public class EventSystem
{
    /**
    * List of events
    */
    private ArrayList<Event> events;
    
    /**
    * List of users
    */
    private ArrayList<User> users;
    
    /**
    * Constructor. Initializes events and users with empty lists.
    */
    public EventSystem()
    {
        this.events = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public Event findEvent(String name) {
        for (Event check : events) {
            if (check.getName().equalsIgnoreCase(name)) {
                return check;
            }
        }
        return null;
    }

    public User getUser(String name) {
        for (User check : users) {
            if (check.getName().equalsIgnoreCase(name)) {
                return check;
            }
        }
        return null;
    }
    
    public String addEvent(String name, String startTimeStr, String endTimeStr, String costPerHourStr) {
        Event newEvent = new Event(name, startTimeStr, endTimeStr, costPerHourStr);

        if (findEvent(name) != null) {
            return "Event " + name + " sudah ada!";
        } else if (!newEvent.startBeforeEnd()) {
            return "Waktu yang diinputkan tidak valid!";
        } else {
            events.add(newEvent);
            return "Event " + name + " berhasil ditambahkan!";
        }
    }
    
    public String addUser(String name) {
        User newUser = new User(name);

        if (getUser(name) != null) {
            return "User " + name + " sudah ada!";
        } else {
            users.add(newUser);
            return "User " + name + " berhasil ditambahkan!";
        }
    }
    
    public String getEvent(String eventName) {
        Event event = findEvent(eventName);
        return event.toString();
    }

    public String registerToEvent(String userName, String eventName) {
        User user = getUser(userName);
        Event event = findEvent(eventName);

        if (user == null && event == null) {
            return "Tidak ada pengguna dengan nama " + userName + " dan acara dengan nama " + eventName + "!";
        } else if (user == null) {
            return "Tidak ada pengguna dengan nama " + userName + "!";
        } else if (event == null) {
            return "Tidak ada acara dengan nama " + eventName + "!";
        } else if (user.addEvent(event)) {
            user.addEvent(event);
            return userName + " berencana menghadiri " + eventName + "!";
        } else {
            return userName + " sibuk sehingga tidak dapat menghadiri " + eventName + "!";
        }
    }
}