/**
* @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
*/

package lab9.event;

import java.util.Comparator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.math.BigInteger;

/**
* A class representing an event and its properties
*/

public class Event {
    /** Name of event */
    private String name;
    private Date startTime;
    private Date endTime;  
    private BigInteger costPerHour;

    public Event(String name, String startTimeStr, String endTimeStr, String costPerHourStr) {
        this.name = name;
        this.startTime = toDate(startTimeStr);
        this.endTime = toDate(endTimeStr);
        this.costPerHour = new BigInteger(costPerHourStr);
    }
    
    /**
    * Accessor for name field. 
    * @return name of this event instance
    */

    public String getName() {
        return this.name;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public BigInteger getCost() {
        return costPerHour;
    }

    public Date toDate(String timeStr) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

        try {
            Date date = sf.parse(timeStr);
            return date;
        }
        catch (Exception e) {
            Date date = new Date();
            return date;
        }
    }
    
    public String toString() {
        SimpleDateFormat pattern = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        return name + "\nWaktu mulai: " + pattern.format(startTime)
            + "\nWaktu selesai: " + pattern.format(endTime)
            + "\nBiaya kehadiran: " + getCost();
    }

    public boolean overlapsWith(Event other) {
        return this.startTime.before(other.endTime) && other.startTime.before(this.endTime);
    }

    public boolean startBeforeEnd() {
        return this.startTime.before(this.endTime);
    }
    
}
